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
 * Created by Rupal on 6/8/2015.
 */
public class MainFlow extends Fragment {

    int i = 0;
    int j = 0;
    int k = 0;
    int count = 0;

    float x1, x2, y1, y2;

    ImageButton prev, next,back,forward ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_flow,container,false);

        i = this.getArguments().getInt("i");
        j = this.getArguments().getInt("j");

        prev = (ImageButton) view.findViewById(R.id.prev_ImageButton);
        next = (ImageButton) view.findViewById(R.id.next_ImageButton);
        back = (ImageButton)view.findViewById(R.id.back_ImageButton);
        forward = (ImageButton)view.findViewById(R.id.forward_ImageButton);

        prev.setVisibility(View.INVISIBLE);
        next.setVisibility(View.INVISIBLE);
        back.setVisibility(View.INVISIBLE);
        forward.setVisibility(View.INVISIBLE);

        if(i == 0){
            prev.setVisibility(View.INVISIBLE);
            next.setVisibility(View.VISIBLE);
        }else if (i < 25) {
            prev.setVisibility(View.VISIBLE);
            next.setVisibility(View.VISIBLE);
        }else{
            prev.setVisibility(View.VISIBLE);
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               count = 1;
                i ++;
                j = j + 3;

                if (i < 26) {
                    Navigate();
                }else {
                    i--;
                    j = j - 3;

                }
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               count = 0;
                i --;
                j = j - 3;
                if(i >= 0){
                    Navigate();
                }else {
                    i = 0;
                    j = 0;
                }

            }
        });

        return view;
    }


    private void Navigate() {
        Intent intent = new Intent(getActivity(),DisplayMain.class);
        intent.putExtra("i", i);
        intent.putExtra("j", j);
        getActivity().finish();
        getActivity().startActivity(intent);
        if (count == 1){
            //slide in
            getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
        }else{
            //slide out
           getActivity().overridePendingTransition(R.anim.rotate_in,R.anim.rotate_out);
        }
    }

}
