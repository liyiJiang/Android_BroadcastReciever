package com.example.administrator.android_broadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Administrator on 2016/9/22.
 */
public class MyReciever2 extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        String name=intent.getStringExtra("info");
        Log.e("MyReciever2","广播传递的数据:"+name);

    }
}
