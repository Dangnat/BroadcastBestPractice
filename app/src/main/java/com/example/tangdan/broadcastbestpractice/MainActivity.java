package com.example.tangdan.broadcastbestpractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    LocalBroadcastManager localBroadcastManager;
    ForceOfficeReceiver forceOfficeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button forceOffline=(Button)findViewById(R.id.force_offline);
        localBroadcastManager=LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("com.example.broadcastbestpractice.FORCE_OFFLINE");
        forceOfficeReceiver=new ForceOfficeReceiver();
        localBroadcastManager.registerReceiver(forceOfficeReceiver,intentFilter);
        forceOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("com.example.broadcastbestpractice.FORCE_OFFLINE");
                localBroadcastManager.sendBroadcast(intent);
            }
        });
    }
}
