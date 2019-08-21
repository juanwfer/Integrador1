package com.example.integrador1;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SmsReceiver sr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        this.sr = new SmsReceiver();
        registerReceiver(this.sr, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
        super.onResume();
    }

    @Override
    protected void onPause() {
        unregisterReceiver(this.sr);
        this.sr.onReceive(this, new Intent("android.provider.Telephony.SMS_RECEIVED"));
        super.onPause();
    }
}
