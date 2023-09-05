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

        broadcastBReceiver = new BroadcastBReceiver();
        IntentFilter intentFilter = new IntentFilter("com.lee.aarlib.BroadMsgReceiver");
        registerReceiver(broadcastBReceiver,intentFilter);

        findViewById(R.id.btClickB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //给外部发送广播通知
                Intent intent=new Intent("com.lee.aarlib.BroadMsgReceiver");
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