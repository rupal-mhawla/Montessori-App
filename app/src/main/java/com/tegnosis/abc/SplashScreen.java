package com.tegnosis.abc;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Rupal on 7/9/2015.
 */
public class SplashScreen extends AppCompatActivity {

    int SPLASH_SCREEN_DELAY = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        actionBar.hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Executed after timer is finshed open main
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);

                //Kill this Activity
                finish();
            }
        }, SPLASH_SCREEN_DELAY);
    }
}
