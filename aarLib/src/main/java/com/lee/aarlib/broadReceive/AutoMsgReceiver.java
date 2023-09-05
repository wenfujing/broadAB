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
        if(intent.getAction()=="BroadCastB"){
            Log.e("我是A应用","-----------------------收到来自B的广播了");
            Log.e("我是A应用","|广播名字="+intent.getAction());//信息：intent.getStringExtra("字段")
            Log.e("我是A应用","|广播数据="+intent.getStringExtra("chifan"));
            Log.e("我是A应用","______________________________________________");
        }
    }
}
