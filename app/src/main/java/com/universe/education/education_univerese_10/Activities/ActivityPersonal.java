package com.universe.education.education_univerese_10.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.universe.education.education_univerese_10.Classes.Potential;
import com.universe.education.education_univerese_10.R;

public class ActivityPersonal extends AppCompatActivity {

    TextView TvNom;
    TextView TvCorreoFrag;
    TextView TvNivEst;
    TextView TvNumPasa;
    TextView TvNac;
    TextView TvViaja;
    TextView TvFecViaja;
    TextView TvNivIng;
    TextView TvAplicVisa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        Toolbar toolbar = (Toolbar) findViewById(R.id.home_screen_toolbar_personal);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //regresar...
                Intent intent = new Intent(getApplicationContext(), ActivitySesion.class);
                startActivity(intent);
                finish();
            }
        });

        TvNom = (TextView) findViewById(R.id.TvNom);
        TvCorreoFrag = (TextView) findViewById(R.id.TvCorreoFrag);
        TvNivEst = (TextView) findViewById(R.id.TvNivEst);
        TvNumPasa = (TextView) findViewById(R.id.TvNumPasa);
        TvNac = (TextView) findViewById(R.id.TvNac);
        TvViaja = (TextView) findViewById(R.id.TvViaja);
        TvFecViaja = (TextView) findViewById(R.id.TvFecViaja);
        TvNivIng = (TextView) findViewById(R.id.TvNivIng);
        TvAplicVisa = (TextView) findViewById(R.id.TvAplicVisa);

        TvNom.setText(Potential.getName());
        TvCorreoFrag.setText(Potential.getCorreo());
        TvNivEst.setText(Potential.getNEst());
        TvNumPasa.setText(Potential.getNPass());
        TvNac.setText(Potential.getNacEst());
        TvViaja.setText(Potential.getViaja());
        TvFecViaja.setText(Potential.getFecAp());
        TvNivIng.setText(Potential.getIngles());
        TvAplicVisa.setText(Potential.getEstVisa());

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), ActivitySesion.class);
        startActivity(intent);
        finish();
    }
}
