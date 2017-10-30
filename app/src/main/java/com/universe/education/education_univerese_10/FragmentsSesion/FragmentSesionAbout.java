package com.universe.education.education_univerese_10.FragmentsSesion;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.universe.education.education_univerese_10.R;


public class FragmentSesionAbout extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sesion_about, container, false);


    }

    public interface OnFragmentInteractionListener {
    }
}
