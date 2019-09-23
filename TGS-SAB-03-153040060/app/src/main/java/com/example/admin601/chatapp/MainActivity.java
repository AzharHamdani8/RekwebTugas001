package com.example.admin601.chatapp;

import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

public class  MainActivity extends AppCompatActivity {

    private WebSocketClient mWebSocketClient;
    private TextView mEditTextChats;
    private EditText mEditTextMessage;
    private ImageView imageView;
    private View line1, line2;
    private Button btnNama, btnNrp;
    private int position = 1;
    private Button mButtonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextChats = (TextView) findViewById(R.id.editTextChats);
        mEditTextMessage = (EditText) findViewById(R.id.editTextMessage);
        mButtonSend = (Button) findViewById(R.id.buttonSend);
        imageView = (ImageView) findViewById(R.id.imageView);
        btnNama = (Button) findViewById(R.id.btnNama);
        btnNrp = (Button) findViewById(R.id.btnNrp);
        line1 = (View) findViewById(R.id.Line1);
        line2 = (View) findViewById(R.id.Line2);



        btnNama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 1;
                int imageResource = getResources().getIdentifier("@drawable/btn_send_1", null, getPackageName());
                Drawable res = getResources().getDrawable(imageResource);
                imageView.setImageDrawable(res);
                line1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                line2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                mButtonSend.setTextColor(getResources().getColor(R.color.colorPrimary));

                btnNama.setBackgroundColor(getResources().getColor(android.R.color.white));
                mEditTextMessage.setTextColor(getResources().getColor(R.color.colorPrimary));
                mEditTextMessage.getBackground().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
            }
        });

        btnNrp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 2;
                int imageResource = getResources().getIdentifier("@drawable/btn_send_2", null, getPackageName());
                Drawable res = getResources().getDrawable(imageResource);
                imageView.setImageDrawable(res);
                line1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                line2.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                mButtonSend.setTextColor(getResources().getColor(R.color.colorAccent));
                btnNrp.setBackgroundColor(getResources().getColor(android.R.color.white));

                mEditTextMessage.setTextColor(getResources().getColor(R.color.colorAccent));
                mEditTextMessage.getBackground().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
            }
        });

        connectWebSocket();

        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptSend(position);
            }
        });
    }

    private void connectWebSocket(){
        URI uri;

        try {
            uri = new URI("ws://192.168.100.17:8887");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }

        mWebSocketClient = new WebSocketClient(uri) {
            @Override
            public void onOpen(ServerHandshake handshakedata) {
                Log.i("WebSocket", "Opened");
                mWebSocketClient.send("Hello from " + Build.MANUFACTURER + " " + Build.MODEL);
            }

            @Override
            public void onMessage(final String message) {
                final String s = message;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mEditTextChats.append(message+"\n");
                    }
                });
            }

            @Override
            public void onClose(int code, String reason, boolean remote) {
                Log.i("WebSocket", "Closed");
            }

            @Override
            public void onError(Exception ex) {
                Log.i("WebSocket", "Error" + ex.getMessage());
            }
        };
        mWebSocketClient.connect();
    }

    private void attemptSend(int i){
        String name = "";
        Date date = new Date();
        if (i == 1) {
            name = "Doni Muhammad : ";
        } else if (i == 2) {
            name = "153040060 : ";
        }

        String message = mEditTextMessage.getText().toString().trim();
        if (TextUtils.isEmpty(message)){
            return;
        }
        mEditTextMessage.setText("");
        mWebSocketClient.send("[" + date.toString() + "] " + name + message);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("Are you sure you want exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}