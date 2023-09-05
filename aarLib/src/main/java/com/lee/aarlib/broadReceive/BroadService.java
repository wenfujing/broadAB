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
        Log.e("我是A应用", "service started,广播服务启动了");

        //注册广播
        receiver = new AutoMsgReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("BroadCastB");//自定义,最好全局搜索下我那些地方用了这个名字
        registerReceiver(receiver, filter);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String name = intent.getStringExtra("command");
        if (name != null) {
            Log.e("我是A应用", "我对外发送了广播 " + name+",数据="+intent.getStringExtra("data"));

            //给B应用发送广播通知
            Intent intentBroad = new Intent("BroadCastA");
            intentBroad.putExtra("command",name);
            intentBroad.putExtra("data", intent.getStringExtra("data"));
            sendBroadcast(intentBroad);
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
