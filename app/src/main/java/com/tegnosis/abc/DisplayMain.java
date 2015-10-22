package com.tegnosis.abc;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Rupal on 6/8/2015.
 */
public class DisplayMain extends MainActivity{


    MainFlow mainFlow = new MainFlow();
    MainActivity mainActivity = new MainActivity();
    float x1,x2;
    int i;
    int j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
         i = intent.getExtras().getInt("i");
         j = intent.getExtras().getInt("j");

        FragmentManager fragmentManager = getFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Letter_Fragment letter_fragment = new Letter_Fragment();
        Letter_Buttton_Fragment letter_buttton_fragment = new Letter_Buttton_Fragment();



        Bundle args = new Bundle();
        args.putInt("i",i);
        args.putInt("j", j);


        letter_fragment.setArguments(args);
        letter_buttton_fragment.setArguments(args);
           mainFlow.setArguments(args);

        fragmentTransaction.add(R.id.letter_FrameLayout, letter_fragment);



        fragmentTransaction.add(R.id.button_FrameLayout, letter_buttton_fragment);

        fragmentTransaction.add(R.id.navigation_FrameLayout, mainFlow);




        fragmentTransaction.commit();



    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            //When user touch the screen for first time

            case MotionEvent.ACTION_DOWN :{
                x1 = event.getX();

                break;
            }

            case MotionEvent.ACTION_UP:{
                x2 = event.getX();
                //for right to left sweep - new page
                if(x1>x2){
                    mainFlow.next.performClick();
                    break;
                }
                // for left to right sweep - prev page
                if(x1 < x2 ){
                    mainFlow.prev.performClick();
                    break;
                }


            }
            default:
                break;

        }


        return false;
    }

    @Override
    public void onBackPressed() {
        super.Home();
    }

}
