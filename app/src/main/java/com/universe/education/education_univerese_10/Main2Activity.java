package com.universe.education.education_univerese_10;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.universe.education.education_univerese_10.FragmentsSesion.FragmentSesion1;
import com.universe.education.education_univerese_10.FragmentsSesion.FragmentSesionAbout;
import com.universe.education.education_univerese_10.FragmentsSesion.FragmentSesionHome;
import com.universe.education.education_univerese_10.FragmentsSesion.FragmentSesionVideos;
import com.universe.education.education_univerese_10.FragmentsSesion.FragmentSesion4;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener,
        FragmentSesion1.OnFragmentInteractionListener,
        FragmentSesionHome.OnFragmentInteractionListener,
        FragmentSesionVideos.OnFragmentInteractionListener,
        FragmentSesion4.OnFragmentInteractionListener,
        FragmentSesionAbout.OnFragmentInteractionListener{


    //hola
    Button btnfr1, btnfr2, btnfr3, btnfr4, btnfr5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        FragmentSesionHome fragmento2 = new FragmentSesionHome();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor, fragmento2).commit();

        btnfr1 = (Button)findViewById(R.id.btnFrag1);
        btnfr2 = (Button)findViewById(R.id.btnFrag2);
        btnfr3 = (Button)findViewById(R.id.btnFrag3);
        btnfr4 = (Button) findViewById(R.id.btnFrag4);
        btnfr5 = (Button) findViewById(R.id.btnFrag5);

        btnfr1.setOnClickListener(this);
        btnfr2.setOnClickListener(this);
        btnfr3.setOnClickListener(this);
        btnfr4.setOnClickListener(this);
        btnfr5.setOnClickListener(this);

        btnfr2.setBackgroundColor(getResources().getColor(R.color.hold_sesion));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnFrag1:
                btnfr1.setBackgroundColor(getResources().getColor(R.color.hold_sesion));
                btnfr2.setBackgroundColor(getResources().getColor(R.color.btns_sesion));
                btnfr3.setBackgroundColor(getResources().getColor(R.color.btns_sesion));
                btnfr4.setBackgroundColor(getResources().getColor(R.color.btns_sesion));
                btnfr5.setBackgroundColor(getResources().getColor(R.color.btns_sesion));
                FragmentSesion1 fragmento1 = new FragmentSesion1();
                FragmentTransaction transition =  getSupportFragmentManager().beginTransaction();
                transition.replace(R.id.contenedor, fragmento1);
                transition.commit();
                break;
            case R.id.btnFrag2:
                btnfr1.setBackgroundColor(getResources().getColor(R.color.btns_sesion));
                btnfr2.setBackgroundColor(getResources().getColor(R.color.hold_sesion));
                btnfr3.setBackgroundColor(getResources().getColor(R.color.btns_sesion));
                btnfr4.setBackgroundColor(getResources().getColor(R.color.btns_sesion));
                btnfr5.setBackgroundColor(getResources().getColor(R.color.btns_sesion));
                FragmentSesionHome fragmento2 = new FragmentSesionHome();
                FragmentTransaction transition1 =  getSupportFragmentManager().beginTransaction();
                transition1.replace(R.id.contenedor, fragmento2);
                transition1.commit();
                break;
            case R.id.btnFrag3:
                btnfr1.setBackgroundColor(getResources().getColor(R.color.btns_sesion));
                btnfr2.setBackgroundColor(getResources().getColor(R.color.btns_sesion));
                btnfr3.setBackgroundColor(getResources().getColor(R.color.hold_sesion));
                btnfr4.setBackgroundColor(getResources().getColor(R.color.btns_sesion));
                btnfr5.setBackgroundColor(getResources().getColor(R.color.btns_sesion));
                FragmentSesionVideos fragmento3 = new FragmentSesionVideos();
                FragmentTransaction transition2 =  getSupportFragmentManager().beginTransaction();
                transition2.replace(R.id.contenedor, fragmento3);
                transition2.commit();
                break;
            case R.id.btnFrag4:
                btnfr1.setBackgroundColor(getResources().getColor(R.color.btns_sesion));
                btnfr2.setBackgroundColor(getResources().getColor(R.color.btns_sesion));
                btnfr3.setBackgroundColor(getResources().getColor(R.color.btns_sesion));
                btnfr4.setBackgroundColor(getResources().getColor(R.color.hold_sesion));
                btnfr5.setBackgroundColor(getResources().getColor(R.color.btns_sesion));
                FragmentSesion4 fragmento4 = new FragmentSesion4();
                FragmentTransaction transition3 =  getSupportFragmentManager().beginTransaction();
                transition3.replace(R.id.contenedor, fragmento4);
                transition3.commit();
                break;
            case R.id.btnFrag5:
                btnfr1.setBackgroundColor(getResources().getColor(R.color.btns_sesion));
                btnfr2.setBackgroundColor(getResources().getColor(R.color.btns_sesion));
                btnfr3.setBackgroundColor(getResources().getColor(R.color.btns_sesion));
                btnfr4.setBackgroundColor(getResources().getColor(R.color.btns_sesion));
                btnfr5.setBackgroundColor(getResources().getColor(R.color.hold_sesion));
                FragmentSesionAbout fragmento5 = new FragmentSesionAbout();
                FragmentTransaction transition4 =  getSupportFragmentManager().beginTransaction();
                transition4.replace(R.id.contenedor, fragmento5);
                transition4.commit();
                break;
        }

    }
}
