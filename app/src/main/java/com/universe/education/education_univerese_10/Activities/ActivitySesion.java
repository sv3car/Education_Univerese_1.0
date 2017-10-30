package com.universe.education.education_univerese_10.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.universe.education.education_univerese_10.Classes.ClassViewPagerAdapter;
import com.universe.education.education_univerese_10.Classes.ClassZohoJSONPotential;
import com.universe.education.education_univerese_10.FragmentsSesion.FragmentSesionAbout;
import com.universe.education.education_univerese_10.FragmentsSesion.FragmentSesionHome;
import com.universe.education.education_univerese_10.FragmentsSesion.FragmentSesionVideos;
import com.universe.education.education_univerese_10.R;
import com.zoho.salesiqembed.ZohoSalesIQ;

import java.util.Locale;

public class ActivitySesion extends AppCompatActivity {

    private ViewPager mViewPager;

    MenuItem prevMenuItem;

    FragmentSesionHome sesion2;
    FragmentSesionVideos sesion3;
    FragmentSesionAbout sesion5;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mViewPager.setCurrentItem(0);
                    break;
                case R.id.navigation_video:
                    mViewPager.setCurrentItem(1);
                    break;
                case R.id.navigation_about:
                    mViewPager.setCurrentItem(2);
                    break;
            }
            return false;
        }
    };

    private void setupViewPager(ViewPager viewPager) {
        ClassViewPagerAdapter adapter = new ClassViewPagerAdapter(getSupportFragmentManager());
        sesion2 = new FragmentSesionHome();
        sesion3 = new FragmentSesionVideos();
        sesion5 = new FragmentSesionAbout();
        adapter.addFragment(sesion2);
        adapter.addFragment(sesion3);
        adapter.addFragment(sesion5);
        viewPager.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);

        ZohoSalesIQ.init(getApplication(), "Nra1CWc37MKwFzi96shTCTphUN6TqeHsAL%2BLm2JPNpMgBRJ83uvKbeU%" +
                        "2BizaMdoNjguy4%2F4%2FpmgnkY75UgGoTfTQ585eZV5bM",
                        "KluWxIcE%2FzUEA%2BMc4NS7mkv7Qi9XLce28gucDjayoCw8bHCXpi%2FE0gD6FacMLgS8kSuVWkcDl3o3o8SMH4dF5ZQY%" +
                        "2F3BscfJpHVbicAf1L0gINsgsh%2F43IlhYbAHM8PwenMJUsinKNfqVq2SVrNg3Gw%3D%3D");

        ZohoSalesIQ.Chat.setTitle("Hola mundo");
        ZohoSalesIQ.Chat.setLanguage(new Locale("es"));
        ZohoSalesIQ.Visitor.startChat("Hi I need assistance");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //ZohoSalesIQ.Chat.Show();
            }
        });


        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);

        mViewPager = (ViewPager) findViewById(R.id.content);

        mViewPager.setCurrentItem(0);

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

    public void ShowDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Cerrar Sesión");
        builder.setMessage("¿Seguro que desea cerrar la sesión actual?");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener(){
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
}
