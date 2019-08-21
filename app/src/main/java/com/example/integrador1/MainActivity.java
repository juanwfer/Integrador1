package com.example.integrador1;

import android.Manifest;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private SmsReceiver sr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECEIVE_SMS},0);
        }

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
        super.onPause();
    }
}
