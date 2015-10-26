package com.tegnosis.abc;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Rupal on 5/28/2015.
 */
public class Word_Fragment extends Fragment implements Animation.AnimationListener {

    int i = 0;
    int k = 0;
    int [] w_ids =  new int[]{R.drawable.word_apple, R.drawable.word_airplane, R.drawable.word_ant,
                              R.drawable.word_ball, R.drawable.word_baby,R.drawable.word_book,
                              R.drawable.word_cat, R.drawable.word_cap, R.drawable.word_car,
                              R.drawable.word_dog, R.drawable.word_duck, R.drawable.word_drum,
                              R.drawable.word_egg, R.drawable.word_elephant, R.drawable.word_eye,
                              R.drawable.word_fish, R.drawable.word_frog, R.drawable.word_foot,
                              R.drawable.word_grapes, R.drawable.word_guitar, R.drawable.word_gift,
                              R.drawable.word_horse, R.drawable.word_hat, R.drawable.word_hand,
                              R.drawable.word_iguana,R.drawable.word_insects,R.drawable.word_icecream,
                              R.drawable.word_jam,R.drawable.word_jellyfish,R.drawable.word_jaguar,
                              R.drawable.word_kite,R.drawable.word_koala,R.drawable.word_keys,
                              R.drawable.word_lion,R.drawable.word_lemon,R.drawable.word_lizard,
                              R.drawable.word_monkey,R.drawable.word_mango,R.drawable.word_mouse,
                              R.drawable.word_nest,R.drawable.word_nose,R.drawable.word_nuts,
                              R.drawable.word_owl,R.drawable.word_ostrich,R.drawable.word_orange,
                              R.drawable.word_pig,R.drawable.word_panda,R.drawable.word_pencil,
                              R.drawable.word_quail,R.drawable.word_queen,R.drawable.word_quilt,
                              R.drawable.word_rainbow,R.drawable.word_rabbit,R.drawable.word_rhino,
                              R.drawable.word_socks,R.drawable.word_snake,R.drawable.word_sun,
                              R.drawable.word_tiger,R.drawable.word_tree,R.drawable.word_turtle,
                              R.drawable.word_umbrella,R.drawable.word_under,R.drawable.word_urial,
                              R.drawable.word_vase,R.drawable.word_violin,R.drawable.word_vulture,
                              R.drawable.word_whale,R.drawable.word_watch,R.drawable.word_walrus,
                              R.drawable.word_x_ray,R.drawable.word_xylophone,R.drawable.word_xenops,
                              R.drawable.word_yoyo,R.drawable.word_yak,R.drawable.word_yarn,
                              R.drawable.word_zebra,R.drawable.word_zipper,R.drawable.word_zero
                                };
    int [] z_ids = new int[]{R.drawable.zoom_a, R.drawable.zoom_b, R.drawable.zoom_c, R.drawable.zoom_d,
                             R.drawable.zoom_e, R.drawable.zoom_f, R.drawable.zoom_g, R.drawable.zoom_h,
                             R.drawable.zoom_i, R.drawable.zoom_j, R.drawable.zoom_k, R.drawable.zoom_l,
                             R.drawable.zoom_m, R.drawable.zoom_n, R.drawable.zoom_o, R.drawable.zoom_p,
                             R.drawable.zoom_q, R.drawable.zoom_r, R.drawable.zoom_s, R.drawable.zoom_t,
                             R.drawable.zoom_u, R.drawable.zoom_v, R.drawable.zoom_w, R.drawable.zoom_x,
                             R.drawable.zoom_y, R.drawable.zoom_z
                                    };

    private ImageView detailNameImageView;
    private ImageView detailZoomImageView;

    Animation zoomin;

   @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view ;
        view = inflater.inflate(R.layout.word_fragment, container, false);

        k = this.getArguments().getInt("index");
        i = this.getArguments().getInt("i");

        detailNameImageView = (ImageView)view.findViewById(R.id.detailNameImageView);
        detailZoomImageView = (ImageView)view.findViewById(R.id.detailZoomNameImageView);

        zoomin = AnimationUtils.loadAnimation(getActivity(),R.anim.zoom_in);
        zoomin.setAnimationListener(this);

        detailZoomImageView.setImageResource(z_ids[i]);

        detailZoomImageView.startAnimation(zoomin);

        return view;
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

        getActivity().overridePendingTransition(0,0);
        detailNameImageView.setImageResource(w_ids[k]);

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
