package com.example.administrator.android_broadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Intent intent;
    private MyReciever5 myReciever5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1= (Button) findViewById(R.id.bt_1);
        button2= (Button) findViewById(R.id.bt_2);
        button3= (Button) findViewById(R.id.bt_3);
        button4= (Button) findViewById(R.id.bt_4);
        button5= (Button) findViewById(R.id.bt_5);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_1:
                 intent=new Intent(MainActivity.this,MyReciever.class);
                intent.putExtra("info","可爱的人");
                sendBroadcast(intent);
            break ;
            case R.id.bt_2:
                 intent=new Intent("beautiful");
                intent.putExtra("info","可爱的人");
                sendBroadcast(intent);
                break ;
            case R.id.bt_3:
                intent=new Intent("beautiful");
                intent.putExtra("info","可爱的人");
                sendOrderedBroadcast(intent,null);
                break ;
            case R.id.bt_4:
                //初始化
              myReciever5=new MyReciever5();
                //设置属性
                IntentFilter intentFilter=new IntentFilter();
                intentFilter.setPriority(100);
                intentFilter.addAction("beautiful");
                registerReceiver(myReciever5,intentFilter);

                break ;
            case R.id.bt_5:
                if(myReciever5 !=null){
                    unregisterReceiver(myReciever5);
                }
                break ;
        }

    }
}
