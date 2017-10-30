package com.universe.education.education_univerese_10.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.universe.education.education_univerese_10.Adapters.AdapterQuotes;
import com.universe.education.education_univerese_10.Classes.ClassZohoJSONQuotes;
import com.universe.education.education_univerese_10.Classes.Quote;
import com.universe.education.education_univerese_10.R;

public class ActivityQuotes extends AppCompatActivity{

    private RecyclerView recycler;
    public static Quote quoteVer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);

       Toolbar toolbar = (Toolbar) findViewById(R.id.home_screen_toolbar_presupuesto);
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

        recycler = (RecyclerView) findViewById(R.id.rvPres);
        recycler.setHasFixedSize(true);
        final GridLayoutManager lManager = new GridLayoutManager(ActivityQuotes.this, 2);
        final AdapterQuotes adapter = new AdapterQuotes(ClassZohoJSONQuotes.listQuote);

        recycler.setAdapter(adapter);
        recycler.setLayoutManager(lManager);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                quoteVer = new Quote();

                int posAct = recycler.getChildAdapterPosition(v);
                Quote quoteAux;
                quoteAux = ClassZohoJSONQuotes.listQuote.get(posAct);
//////////////////////////////////////////////////////////////////////////
                quoteVer.setNumPres(quoteAux.getNumPres());
                quoteVer.setAsunto(quoteAux.getAsunto());
                quoteVer.setFasPres(quoteAux.getFasPres());
                quoteVer.setSubTotal(quoteAux.getSubTotal());
                quoteVer.setImpuesto(quoteAux.getImpuesto());
                quoteVer.setAjuste(quoteAux.getAjuste());
                quoteVer.setTotalGen(quoteAux.getTotalGen());
                quoteVer.setTermAndCond(quoteAux.getTermAndCond());
                quoteVer.setDescuento(quoteAux.getDescuento());
                quoteVer.setVend(quoteAux.getVend());
                quoteVer.setMontIni(quoteAux.getMontIni());
                quoteVer.setMontRest(quoteAux.getMontRest());
                quoteVer.setListProduct(quoteAux.getListProduct());

                Intent intent = new Intent(getApplicationContext(), ActivityVerQuote.class);
                startActivity(intent);
                finish();
                /*Toast.makeText(getApplicationContext(), "Pulsado el elemento " +
                        aux,Toast.LENGTH_SHORT).show();*/
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ActivityQuotes.this, ActivitySesion.class);
        startActivity(intent);
        finish();
    }
}
