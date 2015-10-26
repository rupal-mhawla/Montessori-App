package com.tegnosis.abc;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Rupal on 5/29/2015.
 */

public class DetailActivity extends MainActivity  {


    MediaPlayer lyrics;
    float x1, x2;

    DetailFlow detailFlow = new DetailFlow();
    int i ;
    int j;

    int button_num, counter;

    private int longClickDuration = 200; //for long click to trigger after 0.2 second
    private long then;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();

        button_num = intent.getExtras().getInt("button_id");
         i = intent.getExtras().getInt("i");
         j = intent.getExtras().getInt("j");

        counter = intent.getExtras().getInt("counter");



          FragmentManager detailFragmentManager = getFragmentManager();
          FragmentTransaction detailFragmentTransaction = detailFragmentManager.beginTransaction();

           Detail_Letter_Fragment detail_letter_fragment = new Detail_Letter_Fragment();
            Image_Fragment image_fragment = new Image_Fragment();


            Word_Fragment word_fragment = new Word_Fragment();


            Bundle args = new Bundle();
            args.putInt("index",button_num);
            args.putInt("i",i);
            args.putInt("j",j);

            args.putInt("counter", counter);

            detail_letter_fragment.setArguments(args);
            image_fragment.setArguments(args);
            word_fragment.setArguments(args);
            detailFlow.setArguments(args);

            detailFragmentTransaction.add(R.id.image_DetailActivity, image_fragment);
            detailFragmentTransaction.add(R.id.image_DetailActivity, detail_letter_fragment);
            detailFragmentTransaction.add(R.id.image_DetailActivity,word_fragment);
            detailFragmentTransaction.add(R.id.image_DetailActivity,detailFlow);

            detailFragmentTransaction.commit();

            AudioLyric(button_num);
    }


    private void AudioLyric(int button_num) {

        int rid = 0;

        int [] x = new int[]{R.raw.apple, R.raw.airplane,R.raw.ant,
                             R.raw.ball,R.raw.baby,R.raw.book,
                             R.raw.cat, R.raw.cap, R.raw.car,
                             R.raw.dog, R.raw.duck, R.raw.drum,
                             R.raw.egg, R.raw.elephant, R.raw.eyes,
                             R.raw.fish, R.raw.frog, R.raw.foot,
                             R.raw.grapes, R.raw.guitar, R.raw.gifts,
                             R.raw.horse, R.raw.hat, R.raw.hands,
                             R.raw.iguana, R.raw.insects, R.raw.ice_cream,
                             R.raw.jam, R.raw.jelly_fish, R.raw.jaguar,
                             R.raw.kite, R.raw.koala, R.raw.keys,
                             R.raw.lion, R.raw.lemon, R.raw.lizard,
                             R.raw.monkey, R.raw.mango,R.raw.mouse,
                             R.raw.nest, R.raw.nose, R.raw.nuts,
                             R.raw.owl, R.raw.ostrich, R.raw.orange,
                             R.raw.pig, R.raw.panda, R.raw.pencil,
                             R.raw.quail, R.raw.queen, R.raw.quilt,
                             R.raw.rainbow, R.raw.rabbit, R.raw.rhino,
                             R.raw.socks, R.raw.snake, R.raw.sun,
                             R.raw.tiger, R.raw.tree, R.raw.turtle,
                             R.raw.umbrella, R.raw.under, R.raw.urial,
                             R.raw.vase, R.raw.violin, R.raw.vulture,
                             R.raw.whale, R.raw.watch, R.raw.walrus,
                             R.raw.x_ray, R.raw.xylophone, R.raw.xenops,
                             R.raw.yo_yo, R.raw.yak, R.raw.yarn,
                             R.raw.zebra, R.raw.zipper, R.raw.zero
                             };


        rid = x[button_num];

        lyrics = MediaPlayer.create(this,rid);

        lyrics.start();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            //When user touch the screen for first time
            case MotionEvent.ACTION_DOWN :{
                x1 = event.getX();
                then = System.currentTimeMillis();
                break;
            }

            case MotionEvent.ACTION_UP:{
                x2 = event.getX();

                if ((System.currentTimeMillis()- then ) > longClickDuration ) {
                    DetailActivity.this.finish();
                    detailFlow.count = 2;
                    detailFlow.NavigateDetail();
                }
                //for right to left sweep - new page
                if(x1>x2){
                    if (detailFlow.counter == 1 || detailFlow.counter == 2){
                        detailFlow.forward.performClick();
                    }else if(detailFlow.counter == 3){
                        if (detailFlow.forward.getVisibility() == View.VISIBLE){
                            detailFlow.forward.performClick();
                        }
                        else{
                            Toast.makeText(this,"You have reached the end",Toast.LENGTH_SHORT).show();
                        }
                    }

                    break;
                }
                // for left to right sweep - prev page
                if(x1 < x2 ){
                    if (detailFlow.counter == 1){
                        if(detailFlow.back.getVisibility() == View.VISIBLE){
                            detailFlow.back.performClick();
                        }else{
                            Toast.makeText(this,"You are at start",Toast.LENGTH_SHORT).show();
                        }

                    }else if(detailFlow.counter == 2 || detailFlow.counter == 3){
                        detailFlow.back.performClick();
                    }

                    break;
                }
            }
            default:
                break;
        }

        return false;
    }


    @Override
    public void Book(View view) {
        Intent intent = new Intent(getApplicationContext(),DisplayMain.class);
        intent.putExtra("i",i);
        intent.putExtra("j", j);

        startActivity(intent);
        finish();
    }

    @Override
    protected void onPause() {

       if(ScreenReceiver.wasScreenon){
           lyrics.pause();
           lyrics.reset();
       }
        super.onPause();
    }

    @Override
    protected void onResume() {
        if(!ScreenReceiver.wasScreenon){
            AudioLyric(button_num);
        }

        super.onResume();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),DisplayMain.class);
        intent.putExtra("i",i);
        intent.putExtra("j", j);

        startActivity(intent);
        finish();

    }
}
