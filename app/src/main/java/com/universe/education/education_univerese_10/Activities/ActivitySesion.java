package com.universe.education.education_univerese_10.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.universe.education.education_univerese_10.Classes.ClassViewPagerAdapter;
import com.universe.education.education_univerese_10.FragmentsSesion.FragmentSesion1;
import com.universe.education.education_univerese_10.FragmentsSesion.FragmentSesion2;
import com.universe.education.education_univerese_10.FragmentsSesion.FragmentSesion3;
import com.universe.education.education_univerese_10.FragmentsSesion.FragmentSesion4;
import com.universe.education.education_univerese_10.FragmentsSesion.FragmentSesion5;
import com.universe.education.education_univerese_10.R;

public class ActivitySesion extends AppCompatActivity implements View.OnClickListener,
        FragmentSesion1.OnFragmentInteractionListener,
        FragmentSesion2.OnFragmentInteractionListener,
        FragmentSesion3.OnFragmentInteractionListener,
        FragmentSesion4.OnFragmentInteractionListener,
        FragmentSesion5.OnFragmentInteractionListener{

    /*private ViewPager mViewPager;

    MenuItem prevMenuItem;

    FragmentSesion1 sesion1;
    FragmentSesion2 sesion2;
    FragmentSesion3 sesion3;
    FragmentSesion4 sesion4;
    FragmentSesion5 sesion5;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_contact:
                    mViewPager.setCurrentItem(0);
                    break;
                case R.id.navigation_home:
                    mViewPager.setCurrentItem(1);
                    break;
                case R.id.navigation_video:
                    mViewPager.setCurrentItem(2);
                    break;
                case R.id.navigation_info:
                    mViewPager.setCurrentItem(3);
                    break;
                case R.id.navigation_about:
                    mViewPager.setCurrentItem(4);
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);

        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);

        mViewPager = (ViewPager) findViewById(R.id.container1);

        mViewPager.setCurrentItem(1);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

            mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

                @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+position);
                navigation.getMenu().getItem(position).setChecked(true);
                prevMenuItem = navigation.getMenu().getItem(position);}

                @Override
                public void onPageScrollStateChanged(int state) {
                }

            });
        setupViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager)
    {
        ClassViewPagerAdapter adapter = new ClassViewPagerAdapter(getSupportFragmentManager());
        sesion1 = new FragmentSesion1();
        sesion2 = new FragmentSesion2();
        sesion3 = new FragmentSesion3();
        sesion4 = new FragmentSesion4();
        sesion5 = new FragmentSesion5();
        adapter.addFragment(sesion1);
        adapter.addFragment(sesion2);
        adapter.addFragment(sesion3);
        adapter.addFragment(sesion4);
        adapter.addFragment(sesion5);
        viewPager.setAdapter(adapter);
    }*/

    Button btnfr1, btnfr2, btnfr3, btnfr4, btnfr5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        FragmentSesion2 fragmento2 = new FragmentSesion2();
        FragmentSesion4 fragmento4 = new FragmentSesion4();



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



        if (FragmentSesion2.ContrFrag)
        {
            getSupportFragmentManager().beginTransaction().add(R.id.contenedor, fragmento4).commit();
            btnfr4.setBackgroundColor(getResources().getColor(R.color.hold_sesion));
        }
        else
        {
            getSupportFragmentManager().beginTransaction().add(R.id.contenedor, fragmento2).commit();
            FragmentSesion2.ContrFrag = true;
            btnfr2.setBackgroundColor(getResources().getColor(R.color.hold_sesion));
        }

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
                FragmentSesion2 fragmento2 = new FragmentSesion2();
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
                FragmentSesion3 fragmento3 = new FragmentSesion3();
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
                FragmentSesion5 fragmento5 = new FragmentSesion5();
                FragmentTransaction transition4 =  getSupportFragmentManager().beginTransaction();
                transition4.replace(R.id.contenedor, fragmento5);
                transition4.commit();
                break;
        }
    }

    public void ShowDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Cerrar Sesión");
        builder.setMessage("¿Seguro que desea cerrar la sesión actual?");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(ActivitySesion.this, ActivityLogin.class);
                startActivity(intent);
                finish();
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }); // Create the AlertDialog object and return it
        builder.create().show();
    }

    @Override
    public void onBackPressed()
    {
        ShowDialog();
        //Añade más funciones si fuese necesario
    }

    public void InfoPotent()
    {

    }

}
