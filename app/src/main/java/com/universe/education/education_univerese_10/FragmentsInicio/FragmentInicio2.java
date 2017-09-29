package com.universe.education.education_univerese_10.FragmentsInicio;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.universe.education.education_univerese_10.R;


public class FragmentInicio2 extends Fragment {

    TextView tv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inicio2, container, false);

        tv = (TextView) view.findViewById(R.id.textView);

        Typeface face = Typeface.createFromAsset(getContext().getAssets(),"fonts/audiowide.ttf");
        tv.setTypeface(face);

        return view;
    }

}
