package com.tegnosis.abc;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Rupal on 5/29/2015.
 */
public class Image_Fragment  extends Fragment {


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

    private ImageView detailImageView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view;
        view = inflater.inflate(R.layout.image_fragment, container, false);

        int r_id = this.getArguments().getInt("index");


        detailImageView = (ImageView)view.findViewById(R.id.detail_ImageView);
        //  Toast.makeText(getActivity(),"id"+r_id,Toast.LENGTH_LONG).show();



        detailImageView.setImageResource(ids[r_id]);

        return view;
    }
}
