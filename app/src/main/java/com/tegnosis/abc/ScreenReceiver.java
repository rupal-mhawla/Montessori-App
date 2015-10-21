package com.tegnosis.abc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Rupal on 7/23/2015.
 */
public class ScreenReceiver extends BroadcastReceiver {

    public static boolean wasScreenon= true;

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals((Intent.ACTION_SCREEN_OFF))){
            wasScreenon= false;
            System.out.println("On inside Screen off inner ");

        }else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)){
            wasScreenon = true;
            System.out.println("On inside Screen on inner ");


        }
    }
}