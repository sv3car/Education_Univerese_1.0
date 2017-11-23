package com.universe.education.education_univerese_10.FragmentsSesion;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.universe.education.education_univerese_10.R;


public class FragmentSesionAbout extends Fragment {

    Button btnFac, btnIns, btnInl, btnTwi;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sesion_about, container, false);

        btnFac = (Button) view.findViewById(R.id.btnFac);
        btnIns = (Button) view.findViewById(R.id.btnIns);
        btnInl = (Button) view.findViewById(R.id.btnInl);
        btnTwi = (Button) view.findViewById(R.id.btnTwi);

        btnFac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FACEBOOK_URL = "https://www.facebook.com/YourPageName";
                String FACEBOOK_PAGE_ID = "YourPageName";
                String facebookUrl;
                PackageManager packageManager = getContext().getPackageManager();
                try {
                    int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
                    if (versionCode >= 3002850) {
                        //versiones nuevas de facebook
                        facebookUrl = "fb://facewebmodal/f?href=" + FACEBOOK_URL;
                    } else {
                        //versiones antiguas de fb
                        facebookUrl = "fb://page/" + FACEBOOK_PAGE_ID;
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    facebookUrl = FACEBOOK_URL; //normal web url
                }

                Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
                facebookIntent.setData(Uri.parse(facebookUrl));
                startActivity(facebookIntent);
            }
        });

        btnIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnInl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnTwi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }



}
