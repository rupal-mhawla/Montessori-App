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
   // BackgroundSound mBackgroundSound;

    int i = 0;
    int j = 0;

   /** private boolean mIsBound = false;
    private MusicService mServ;
    private ServiceConnection Scon = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            mServ = ((MusicService.ServiceBinder)binder).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

            mServ = null;
        }
    };

    void doBindService(){
        bindService(new Intent(this,MusicService.class),Scon,Context.BIND_AUTO_CREATE);
        mIsBound = true;
    }

    void doUnbindService(){
        if(mIsBound){
            unbindService(Scon);
            mIsBound = false;
        }
    }
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       // getActionBar().setDisplayShowTitleEnabled(false);

     //mBackgroundSound = new BackgroundSound();

       // Intent music = new Intent();
        //music.setClass(this,MusicService.class);
        //startService(music);

        backmusic = MediaPlayer.create(this,R.raw.background_score);
        backmusic.setLooping(true);
        backmusic.setVolume(0.5f,0.5f);
        backmusic.start();

        }

   /** @Override
    protected void onResume() {
        super.onResume();
        mBackgroundSound.execute((Void[]) null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mBackgroundSound.cancel(true);
    }
*/
    public void MainClick(View view) {



        String button_click  = getResources().getResourceEntryName(view.getId());

        int id = getResources().getIdentifier(button_click, "string", "com.tegnosis.abc");

        String val = getResources().getString(id);

       // Toast.makeText(this,"i = "+val,Toast.LENGTH_SHORT ).show();

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


    public void Home(View view) {
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
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if ((keyCode == KeyEvent.KEYCODE_BACK) || (keyCode == KeyEvent.KEYCODE_HOME)
                || (keyCode == KeyEvent.KEYCODE_CALL))
            return false;
        else
            return true;
    }

    /**

    public class BackgroundSound extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... params) {

            backmusic = MediaPlayer.create(MainActivity.this,R.raw.background_score);
            backmusic.setLooping(true);//set looping
            backmusic.setVolume(50,50);
            backmusic.start();
            return null;
        }
    }
     */
}
