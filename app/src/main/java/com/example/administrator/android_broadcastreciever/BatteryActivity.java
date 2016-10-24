package com.example.administrator.android_broadcastreciever;

/**
 * Created by Administrator on 2016/9/22.
 */
public class BatteryActivity extends Activity {
    private ToggleButton tb = null;
    private TextView tv = null;
    private BatteryReceiver receiver = null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        receiver = new BatteryReceiver();
        tv = (TextView) findViewById(R.id.tv);
        tb = (ToggleButton) findViewById(R.id.tb);
        tb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton,
                                         boolean isChecked) {
                // 获取电池电量
                if (isChecked) {
                    IntentFilter filter = new IntentFilter(
                            Intent.ACTION_BATTERY_CHANGED);
                    // 注册BroadcastReceiver
                    registerReceiver(receiver, filter);
                } else {
                    // 停止获取电池电量
                    unregisterReceiver(receiver);
                    tv.setText(null);
                }
            }
        });
    }

    private class BatteryReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            int current = intent.getExtras().getInt("level");// 获得当前电量
            int total = intent.getExtras().getInt("scale");// 获得总电量
            int percent = current * 100 / total;
            tv.setText("现在的电量是" + percent + "%。");
        }
    }
}
