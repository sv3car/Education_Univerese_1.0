package com.universe.education.education_univerese_10.FragmentsSesion;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.universe.education.education_univerese_10.Activities.ActivityLogin;
import com.universe.education.education_univerese_10.Activities.ActivitySesion;
import com.universe.education.education_univerese_10.R;


public class FragmentSesion2 extends Fragment{

    private ViewPager mViewPager;

    public static Boolean ContrFrag;

    TextView tv1, tv2, tv3, tv4;
    ImageButton Ib1, Ib2, Ib3, Ib4;
    RelativeLayout rl1, rl2, rl3, rl4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sesion2, container, false);


        tv1 = (TextView) view.findViewById(R.id.tv1);
        tv2 = (TextView) view.findViewById(R.id.tv2);
        tv3 = (TextView) view.findViewById(R.id.tv3);
        tv4 = (TextView) view.findViewById(R.id.tv4);

        Ib1 = (ImageButton) view.findViewById(R.id.Ib1);
        Ib2 = (ImageButton) view.findViewById(R.id.Ib2);
        Ib3 = (ImageButton) view.findViewById(R.id.Ib3);
        Ib4 = (ImageButton) view.findViewById(R.id.Ib4);

        rl1 = (RelativeLayout) view.findViewById(R.id.rl1);
        rl2 = (RelativeLayout) view.findViewById(R.id.rl2);
        rl3 = (RelativeLayout) view.findViewById(R.id.rl3);
        rl4 = (RelativeLayout) view.findViewById(R.id.rl4);

        Typeface face = Typeface.createFromAsset(getContext().getAssets(),"fonts/audiowide.ttf");
        tv1.setTypeface(face);
        tv2.setTypeface(face);
        tv3.setTypeface(face);
        tv4.setTypeface(face);


        /*Ib1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), ActivitySesion.class);
                startActivity(intent);

            }
        });*/

        Ib1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = MotionEventCompat.getActionMasked(event);
                switch (action) {
                    case (MotionEvent.ACTION_DOWN):
                        tv1.setTextColor(getResources().getColor(R.color.text_down_sesion_fr2));
                        rl1.setBackgroundColor(getResources().getColor(R.color.down_sesion_fr2));
                        return true;
                    case (MotionEvent.ACTION_UP):
                        tv1.setTextColor(getResources().getColor(R.color.text_up_sesion_fr2));
                        rl1.setBackgroundColor(getResources().getColor(R.color.up_sesion_fr2));
                        Intent intent = new Intent(getContext(), ActivitySesion.class);
                        startActivity(intent);
                        getActivity().finish();
                        return true;
                }
                return false;
            }
        });

        Ib2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = MotionEventCompat.getActionMasked(event);
                switch (action) {
                    case (MotionEvent.ACTION_DOWN):
                        tv2.setTextColor(getResources().getColor(R.color.text_down_sesion_fr2));
                        rl2.setBackgroundColor(getResources().getColor(R.color.down_sesion_fr2));
                        return true;
                    case (MotionEvent.ACTION_UP):
                        tv2.setTextColor(getResources().getColor(R.color.text_up_sesion_fr2));
                        rl2.setBackgroundColor(getResources().getColor(R.color.up_sesion_fr2));
                        /*Intent intent = new Intent(getContext(), ActivitySesion.class);
                        startActivity(intent);
                        getActivity().finish()*/
                        return true;
                }
                return false;
            }
        });

        Ib3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = MotionEventCompat.getActionMasked(event);
                switch (action) {
                    case (MotionEvent.ACTION_DOWN):
                        tv3.setTextColor(getResources().getColor(R.color.text_down_sesion_fr2));
                        rl3.setBackgroundColor(getResources().getColor(R.color.down_sesion_fr2));
                        return true;
                    case (MotionEvent.ACTION_UP):
                        tv3.setTextColor(getResources().getColor(R.color.text_up_sesion_fr2));
                        rl3.setBackgroundColor(getResources().getColor(R.color.up_sesion_fr2));
                        /*Intent intent = new Intent(getContext(), ActivitySesion.class);
                        startActivity(intent);
                        getActivity().finish()*/
                        return true;
                }
                return false;
            }
        });

        Ib4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = MotionEventCompat.getActionMasked(event);
                switch (action) {
                    case (MotionEvent.ACTION_DOWN):
                        tv4.setTextColor(getResources().getColor(R.color.text_down_sesion_fr2));
                        rl4.setBackgroundColor(getResources().getColor(R.color.down_sesion_fr2));
                        return true;
                    case (MotionEvent.ACTION_UP):
                        tv4.setTextColor(getResources().getColor(R.color.text_up_sesion_fr2));
                        rl4.setBackgroundColor(getResources().getColor(R.color.up_sesion_fr2));
                        /*Intent intent = new Intent(getContext(), ActivitySesion.class);
                        startActivity(intent);
                        getActivity().finish()*/
                        return true;
                }
                return false;
            }
        });




        return view;
    }


    public interface OnFragmentInteractionListener {
    }
}
