package com.lee.appb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BroadcastBReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction()=="BroadCastA"){
            Log.e("我是厂商端", "-----我是厂商，我收到aar的广播" );
            Log.e("我是厂商端", "|onReceive: 广播名字="+intent.getAction());
            Log.e("我是厂商端", "|onReceive: tag="+intent.getStringExtra("tag"));
            Log.e("我是厂商端", "|onReceive: data="+intent.getStringExtra("data"));
            Log.e("我是厂商端", "__________________________________________________");
        }
    }
}
