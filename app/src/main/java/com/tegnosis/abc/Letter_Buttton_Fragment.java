package com.tegnosis.abc;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by Rupal on 5/28/2015.
 */
public class Letter_Buttton_Fragment extends Fragment implements View.OnClickListener {

    int i = 0;
    int j = 0;
    int k1 , k2, k3;
    int counter = 0;

    int[] ids = new int[]{R.drawable.apple,R.drawable.airplane,R.drawable.ant,
                            R.drawable.ball,R.drawable.baby,R.drawable.book,
                            R.drawable.cat,R.drawable.cap,R.drawable.car,
                            R.drawable.dog,R.drawable.duck,R.drawable.drum,
                            R.drawable.egg,R.drawable.elephant,R.drawable.eyes,
                            R.drawable.fish,R.drawable.frog,R.drawable.foot,
                            R.drawable.grapes,R.drawable.guitar,R.drawable.gifts,
                            R.drawable.horse,R.drawable.hat,R.drawable.hands,
                            R.drawable.iguana,R.drawable.insects,R.drawable.ice_cream,
                            R.drawable.jam,R.drawable.jelly_fish,R.drawable.jaguar,
                            R.drawable.kites,R.drawable.koala,R.drawable.keys,
                            R.drawable.lion,R.drawable.lemon,R.drawable.lizard,
                            R.drawable.monkey,R.drawable.mango,R.drawable.mouse,
                            R.drawable.nest,R.drawable.nose,R.drawable.nuts,
                            R.drawable.owl,R.drawable.ostrich,R.drawable.orange,
                            R.drawable.pig,R.drawable.panda,R.drawable.pencil,
                            R.drawable.quail,R.drawable.queen,R.drawable.quilt,
                            R.drawable.rainbow,R.drawable.rabbit,R.drawable.rhino,
                            R.drawable.socks,R.drawable.snake,R.drawable.sun,
                            R.drawable.tiger,R.drawable.tree,R.drawable.turtle,
                            R.drawable.umbrella,R.drawable.under,R.drawable.urial,
                            R.drawable.vase,R.drawable.violin,R.drawable.vulture,
                            R.drawable.whale,R.drawable.watch,R.drawable.walrus,
                            R.drawable.x_ray,R.drawable.xylophone,R.drawable.xenops,
                            R.drawable.yo_yo,R.drawable.yak,R.drawable.yarn,
                            R.drawable.zebra,R.drawable.zipper,R.drawable.zero
                        };

    int image_button = 0;

    private ImageButton imageButton1, imageButton2, imageButton3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        j = this.getArguments().getInt("j");
        k1 = j;
        k2 = k1 + 1;
        k3 = k2 + 1;

        View view;
        view = inflater.inflate(R.layout.letter_button_fragment,container,false);

        imageButton1 = (ImageButton)view.findViewById(R.id.imageButton1);
        imageButton2 = (ImageButton)view.findViewById(R.id.imageButton2);
        imageButton3 = (ImageButton)view.findViewById(R.id.imageButton3);


        imageButton1.setImageResource(ids[k1]);
        imageButton2.setImageResource(ids[k2]);
        imageButton3.setImageResource(ids[k3]);

        imageButton1.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
        imageButton3.setOnClickListener(this);


        return view;
    }


    @Override
    public void onClick(View v) {

        i = this.getArguments().getInt("i");

        int  button_id =0;

       if (v.getId() == R.id.imageButton1) {
           button_id = k1;
           counter = 1;
       }else if (v.getId() == R.id.imageButton2) {
           button_id = k2;
           counter = 2;
       }else if (v.getId() == R.id.imageButton3){
           button_id = k3;
           counter = 3;
        }
        Intent intent = new Intent(getActivity(),DetailActivity.class);

        intent.putExtra("button_id", button_id);
        intent.putExtra("i",i);

        intent.putExtra("counter",counter);
        intent.putExtra("j",j);
        getActivity().finish();
        getActivity().startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slide_top_in, R.anim.slide_top_out);

    }
}
