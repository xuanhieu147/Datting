package com.example.datting.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.datting.R;
import com.example.datting.adapter.TinNhanAdapter;
import com.example.datting.class_khac.SetColorStatusBar;
import com.example.datting.model.TinNhan;
import com.example.datting.model.UserGanDay;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class ChatActivity extends AppCompatActivity {

    MqttAndroidClient client;
    String topic;
    EditText edChat;
    TextView tvGui;
    String payload;
    String tinNhan;
    String name = Build.DEVICE;
    private RecyclerView recyclerView;
    private TinNhanAdapter adapter;
    ArrayList<TinNhan> tinNhans;
    String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        edChat = findViewById(R.id.edChat);
        tvGui = findViewById(R.id.tvGui);
        recyclerView = findViewById(R.id.rvListChat);
        topic = "testtopic/12";
        tinNhans = new ArrayList<TinNhan>();

        connect();
        tvGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pub();
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat dinhDangGio = new SimpleDateFormat("hh:mm: a");
                time = dinhDangGio.format(calendar.getTime());
                edChat.setText("");

            }
        });
        adapter = new TinNhanAdapter(getApplicationContext(), tinNhans);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    private void connect() {
        // create a new MqttAndroidClient using the current context
        String clientId = MqttClient.generateClientId();
        client = new MqttAndroidClient(getApplicationContext(), "tcp://broker.hivemq.com:1883", clientId);

        try {
            IMqttToken token = client.connect();
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    // We are connected
                    sub();
                    Toast.makeText(ChatActivity.this, "Thanh cong", Toast.LENGTH_LONG).show();

                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    // Something went wrong e.g. connection timeout or firewall problems
                    Toast.makeText(ChatActivity.this, "That bai", Toast.LENGTH_LONG).show();

                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void pub() {
        String topic = "testtopic/12";
        payload = edChat.getText().toString();
        payload = name + ":" + payload;
        byte[] encodedPayload = new byte[0];
        try {
            encodedPayload = payload.getBytes("UTF-8");

            MqttMessage message = new MqttMessage(encodedPayload);
            client.publish(topic, message);
        } catch (UnsupportedEncodingException | MqttException e) {
            e.printStackTrace();
        }
    }

    public void sub() {
        try {
            client.subscribe(topic, 2);
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {

                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    Log.d("Push", "topic: " + topic);
                    Log.d("Push", "message: " + new String(message.getPayload()));
                    String tenmay = new String(message.getPayload()).substring(0, new String(message.getPayload()).indexOf(":"));
                    tinNhan = new String(message.getPayload()).substring(new String(message.getPayload()).indexOf(":") + 1);
                    tinNhans.add(new TinNhan(tinNhan, tenmay, time));
                    adapter.notifyDataSetChanged();

                    Log.d("Push", "time: " + time);

                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {

                }
            });
        } catch (MqttSecurityException e) {
            e.printStackTrace();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

}
