package com.tegnosis.abc;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import java.lang.reflect.Field;


public class MainActivity extends AppCompatActivity {

    MediaPlayer backmusic;

    int i = 0;
    int j = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        backmusic = MediaPlayer.create(this,R.raw.background_score);
        backmusic.setLooping(true);
        backmusic.setVolume(0.5f, 0.5f);
        backmusic.start();

        }

    public void MainClick(View view) {



        String button_click  = getResources().getResourceEntryName(view.getId());

        int id = getResources().getIdentifier(button_click, "string", "com.tegnosis.abc");

        String val = getResources().getString(id);



        i = Integer.parseInt(val);
        j = i+i+i;

       Intent intent = new Intent(getApplicationContext(),DisplayMain.class);
        intent.putExtra("i",i);
        intent.putExtra("j", j);


        startActivity(intent);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayShowCustomEnabled(true);

        LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.actionbar_ui,null);
        actionBar.setCustomView(v);

        return super.onCreateOptionsMenu(menu);
    }


    public void Home() {
        Toast.makeText(this,"Home selected ",Toast.LENGTH_SHORT ).show();
        finish();
        startActivity(new Intent(this, MainActivity.class));

    }

    public void Book(View view) {
        Toast.makeText(this,"Book selected ",Toast.LENGTH_SHORT ).show();


        Intent intent = new Intent(getApplicationContext(),DisplayMain.class);
        intent.putExtra("i",i);
        intent.putExtra("j", j);


        startActivity(intent);
        finish();

    }

    @Override
    protected void onPause() {
        super.onPause();
        backmusic.release();
        //finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
