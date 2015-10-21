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
 * Created by Rupal on 6/9/2015.
 */
public class DetailFlow  extends Fragment {

    int i = 0;
    int j = 0;
    int button_id = 0;

    int counter = 0;

    int count = 0;

    ImageButton prev, next,back,forward ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_flow,container,false);

        i = this.getArguments().getInt("i");
        j = this.getArguments().getInt("j");
        button_id = this.getArguments().getInt("index");

        counter = this.getArguments().getInt("counter");

        prev = (ImageButton) view.findViewById(R.id.prev_ImageButton);
        next = (ImageButton) view.findViewById(R.id.next_ImageButton);
        back = (ImageButton)view.findViewById(R.id.back_ImageButton);
        forward = (ImageButton)view.findViewById(R.id.forward_ImageButton);


        prev.setVisibility(View.INVISIBLE);
        next.setVisibility(View.INVISIBLE);
        back.setVisibility(View.INVISIBLE);
        forward.setVisibility(View.INVISIBLE);

        if (counter == 1){
            //first button image
            if (i > 0 ){
                back.setVisibility(View.VISIBLE);
            }
            forward.setVisibility(View.VISIBLE);
        }else if (counter == 2){
            //second button Image
            back.setVisibility(View.VISIBLE);
            forward.setVisibility(View.VISIBLE);
        }else if(counter == 3){
            //third button image
            back.setVisibility(View.VISIBLE);
            if(i >= 25 ){
                forward.setVisibility(View.INVISIBLE);
            }else{
                forward.setVisibility(View.VISIBLE);
            }

        }









        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 1;
                button_id++;
                if(counter == 3){
                    counter = 1;
                    i++;
                    j = j + 3;
                    if (i >= 26){
                        i--;
                        j = j-3;
                        counter = 3;
                    }
                }else{
                    counter++;
                }


                NavigateDetail();

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                if(counter == 1){
                    counter = 3;
                    i--;
                    j = j-3;
                    if (i < 0){
                        i = 0;
                        j = 0;
                        counter = 1;
                    }
                }else {
                    counter--;
                }
                button_id--;

                NavigateDetail();

            }
        });

        return view;
    }

    private void NavigateDetail() {
        Intent intent = new Intent(getActivity(),DetailActivity.class);

        intent.putExtra("button_id", button_id);
        intent.putExtra("i",i);

        intent.putExtra("counter",counter);
        intent.putExtra("j",j);

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
