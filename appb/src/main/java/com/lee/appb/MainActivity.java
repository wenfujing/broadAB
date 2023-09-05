package com.lee.appb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private BroadcastBReceiver broadcastBReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //注册监听来自A的广播消息
        broadcastBReceiver = new BroadcastBReceiver();
        IntentFilter intentFilter = new IntentFilter("BroadCastA");
        registerReceiver(broadcastBReceiver,intentFilter);

        findViewById(R.id.btClickC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //给A发送广播通知
                Intent intent=new Intent("BroadCastB");
                intent.putExtra("chifan", "我是厂家端，我们正在通话了，你吃饭了吗");
                sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastBReceiver);
    }
}