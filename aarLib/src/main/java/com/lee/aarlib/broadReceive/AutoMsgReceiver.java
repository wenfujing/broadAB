package com.lee.aarlib.broadReceive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * 监听外部广播调用
 *
 * */
public class AutoMsgReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent != null){
            Log.e("Test","-----------------------收到广播了");
            Log.e("Test","广播名字="+intent.getAction());//信息：intent.getStringExtra("字段")
            Log.e("test","---------"+intent.getStringExtra("chifan"));
        }
    }
}
