package com.lee.aarlib;


import android.content.Context;
import android.content.Intent;

import com.lee.aarlib.broadReceive.BroadService;

/**
 * 给主模块调用接口
* */
public class InvokeUtils {
    private Context mContext;

    //初始化接口
    public void init(Context context){
        mContext = context;
        //启动广播服务
        Intent intent = new Intent(mContext, BroadService.class);
        context.startService(intent);

        //发送初始化广播
        intent.putExtra("command","init");
        intent.putExtra("data","我初始化好了");
        mContext.startService(intent);
    }

    //功能接口1
    public void interferce1(){
        Intent intent = new Intent(mContext, BroadService.class);
        intent.putExtra("command","interferce1");
        intent.putExtra("data","123456");
        mContext.startService(intent);


    }
}

