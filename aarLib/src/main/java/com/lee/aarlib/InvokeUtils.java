package com.lee.aarlib;


import android.content.Context;
import android.content.Intent;

import com.lee.aarlib.broadReceive.BroadService;

/**
 * 给主模块调用接口
 * todo 可以写成单例
* */
public class InvokeUtils {
    private Context mContext;

    //初始化接口
    public void init(Context context){
        mContext = context.getApplicationContext();
        //启动广播service
        Intent intent = new Intent(mContext, BroadService.class);
        context.startService(intent);

        //调用service去发送广播
        intent.putExtra("command","init");
        intent.putExtra("data","我初始化好了");
        mContext.startService(intent);
    }

    //功能接口1
    public void interferce1(){
        //调用service去发送广播
        Intent intent = new Intent(mContext, BroadService.class);
        intent.putExtra("command","interferce1");
        intent.putExtra("data","123456");
        mContext.startService(intent);


    }
}

