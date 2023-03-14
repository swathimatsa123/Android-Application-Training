package com.example.broadcastreceiver;

import android.app.ApplicationErrorReport;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class BatteryPercentageViewer extends BroadcastReceiver {

    TextView tv;
    BatteryPercentageViewer(TextView tv){
    this.tv=tv;

    }
    @Override
    public void onReceive(Context context, Intent intent) {
    int Percentage=intent.getIntExtra("LEVEL",0);
        if(Percentage!=0)
        {
            tv.setText(Percentage+"%");

        }

    }

}
