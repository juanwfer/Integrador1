package com.example.integrador1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Ernesto", "ONRECEIVE");
        Toast.makeText(context, "Bieeeeen", Toast.LENGTH_SHORT).show();
    }
}
