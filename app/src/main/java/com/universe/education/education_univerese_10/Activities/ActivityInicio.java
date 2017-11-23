package com.universe.education.education_univerese_10.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.universe.education.education_univerese_10.Classes.ClassConexion;
import com.universe.education.education_univerese_10.Classes.ClassViewPagerAdapter;
import com.universe.education.education_univerese_10.Classes.ClassZohoJSONDocuments;
import com.universe.education.education_univerese_10.Classes.ClassZohoJSONPotential;
import com.universe.education.education_univerese_10.Classes.ClassZohoJSONQuotes;
import com.universe.education.education_univerese_10.Classes.Potential;
import com.universe.education.education_univerese_10.FragmentsInicio.FragmentInicio1;
import com.universe.education.education_univerese_10.FragmentsInicio.FragmentInicio2;
import com.universe.education.education_univerese_10.FragmentsInicio.FragmentInicio3;
import com.universe.education.education_univerese_10.FragmentsInicio.FragmentInicio4;
import com.universe.education.education_univerese_10.FragmentsSesion.FragmentSesionHome;
import com.universe.education.education_univerese_10.R;

public class ActivityInicio extends AppCompatActivity {

    //private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    //TextView tv;
    Button btn1;
    Button btn2;
    TabLayout tabLayout;
    int pos = 0;
    FragmentInicio1 inicio1;
    FragmentInicio2 inicio2;
    FragmentInicio3 inicio3;
    FragmentInicio4 inicio4;

    /////////////
    private void setupViewPager(ViewPager viewPager) {
        ClassViewPagerAdapter adapter = new ClassViewPagerAdapter(getSupportFragmentManager());
        inicio1 = new FragmentInicio1();
        inicio2 = new FragmentInicio2();
        inicio3= new FragmentInicio3();
        inicio4 = new FragmentInicio4();
        adapter.addFragment(inicio1);
        adapter.addFragment(inicio2);
        adapter.addFragment(inicio3);
        adapter.addFragment(inicio4);
        viewPager.setAdapter(adapter);
    }
    //////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        //tv = (TextView) findViewById(R.id.textView);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        /*Typeface bell_centennial = Typeface.createFromAsset(getAssets(),"fonts/bell_centennial.otf");
        tv.setTypeface(bell_centennial);*/

        Typeface enigma = Typeface.createFromAsset(getAssets(),"fonts/enigma.ttf");
        btn1.setTypeface(enigma);
        btn2.setTypeface(enigma);

        //mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);

        setupViewPager(mViewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(mViewPager, true);
        tabLayout.getTabAt(0).select();
        hand1();

        /*TareaAsincrona task = new TareaAsincrona();
        task.execute();*/

        //Evento del boton Register
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityInicio.this, ActivityRegister.class);
                startActivity(intent);
                finish();
            }
        });
        //Evento del boton Login
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityInicio.this, ActivityLogin.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void hand1(){
        new Handler().postDelayed
                (new Runnable() {
                     @Override
                     public void run()
                     {
                         int pos = tabLayout.getSelectedTabPosition();
                         if (pos == 3) {
                             pos = -1;
                         }
                         tabLayout.getTabAt(pos+1).select();
                         hand2();
                     }
                 },
                        //Segundos de duración del SplashScream
                        4000);
    }

    private void hand2(){
        new Handler().postDelayed
                (new Runnable() {
                     @Override
                     public void run()
                     {
                         int pos = tabLayout.getSelectedTabPosition();
                         if (pos == 3) {
                             pos = -1;
                         }
                         tabLayout.getTabAt(pos+1).select();
                         hand1();
                     }
                 },
                        //Segundos de duración del SplashScream
                        4000);
    }


    /*public class SectionsPagerAdapter extends FragmentPagerAdapter {

            public SectionsPagerAdapter(FragmentManager fm) {
                super(fm);
            }
            @Override
            public Fragment getItem(int position) {

                switch (position) {
                    case 0:
                        FragmentInicio1 carrusel1 = new FragmentInicio1();
                        return carrusel1;
                    case 1:
                        FragmentInicio2 carrusel2 = new FragmentInicio2();
                        return carrusel2;
                    case 2:
                        FragmentInicio3 carrusel3 = new FragmentInicio3();
                        return carrusel3;
                    case 3:
                        FragmentInicio4 carrusel4 = new FragmentInicio4();
                        return carrusel4;
                }
                return null;
            }
        @Override
        public int getCount() {

            return 4;
        }*/


        /*@Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "CARRUSEL 1";
                case 1:
                    return "CARRUSEL 2";
                case 2:
                    return "CARRUSEL 3";
                case 3:
                    return "CARRUSEL 4";
            }
            return null;
        }*/
}

