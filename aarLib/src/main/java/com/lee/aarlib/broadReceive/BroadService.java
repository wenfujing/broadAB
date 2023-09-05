package com.lee.aarlib.broadReceive;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;


public class BroadService extends Service {

    private AutoMsgReceiver receiver;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("test","service started");

        //注册广播
        receiver = new AutoMsgReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.lee.aarlib.BroadMsgReceiver");//自定义,最好全局搜索下我那些地方用了这个名字
        registerReceiver(receiver, filter);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String command = intent.getStringExtra("command");
        if ("init".equals(command)) {
            init(intent.getStringExtra("data"));
        }
        else if ("interferce1".equals(command)){
            interferce1(intent.getStringExtra("data"));
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }


    public void init(String data){
        //给外部发送广播通知
        Intent intent=new Intent("com.lee.aarlib.BroadMsgReceiver");
        intent.putExtra("tag","init");
        intent.putExtra("data", data);
        sendBroadcast(intent);
    }

    public void interferce1(String data){
        //给外部发送广播通知2
        Intent intent=new Intent("com.lee.aarlib.BroadMsgReceiver");
        intent.putExtra("tag","interferce1");
        intent.putExtra("data", data);
        sendBroadcast(intent);
    }
}
