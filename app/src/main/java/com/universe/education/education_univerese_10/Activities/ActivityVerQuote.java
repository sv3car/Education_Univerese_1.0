package com.universe.education.education_univerese_10.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import com.universe.education.education_univerese_10.Classes.Product;
import com.universe.education.education_univerese_10.Classes.Tabla;
import com.universe.education.education_univerese_10.R;

import java.util.ArrayList;


public class ActivityVerQuote extends AppCompatActivity {

    TextView tvAsuntoPres;
    TextView tvSubTotPres;
    TextView tvImpPres;
    TextView tvAjustPres;
    TextView tvTotalPres;
    TextView tvNumPres;
    TextView tvFasePres;
    Button btnAtrVer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_quote);

        tvAsuntoPres =(TextView) findViewById(R.id.tvAsuntoPres);
        tvSubTotPres = (TextView) findViewById(R.id.tvSubTotPres);
        tvImpPres = (TextView) findViewById(R.id.tvImpPres);
        tvAjustPres = (TextView) findViewById(R.id.tvAjustPres);
        tvTotalPres = (TextView) findViewById(R.id.tvTotalPres);
        tvNumPres = (TextView) findViewById(R.id.tvNumPres);
        tvFasePres = (TextView) findViewById(R.id.tvFasePres);
        btnAtrVer = (Button) findViewById(R.id.btnAtrVer);

        Tabla tabla = new Tabla(this, (TableLayout)findViewById(R.id.tabla));
        tabla.agregarCabecera(R.array.cabecera_tabla);

        tvAsuntoPres.setText(ActivityQuotes.quoteVer.getAsunto());
        tvSubTotPres.setText(ActivityQuotes.quoteVer.getSubTotal()+"AUD");
        tvImpPres.setText(ActivityQuotes.quoteVer.getImpuesto()+"AUD");
        tvAjustPres.setText(ActivityQuotes.quoteVer.getAjuste()+"AUD");
        tvTotalPres.setText(ActivityQuotes.quoteVer.getTotalGen()+"AUD");
        tvNumPres.setText(ActivityQuotes.quoteVer.getNumPres());
        tvFasePres.setText(ActivityQuotes.quoteVer.getFasPres());

        for(int i = 0; i < ActivityQuotes.quoteVer.getListProduct().size(); i++)
        {
            Product prodAux;
            prodAux = ActivityQuotes.quoteVer.getListProduct().get(i);

            ArrayList<String> elementos = new ArrayList<String>();
            elementos.add(prodAux.getNameProd());
            elementos.add(prodAux.getDescripcion());
            elementos.add(prodAux.getPrecUnit()+"AUD");
            elementos.add(prodAux.getCant());
            elementos.add(prodAux.getTotal()+"AUD");
            elementos.add(prodAux.getDescu()+"AUD");
            elementos.add(prodAux.getTotalAftDesc()+"AUD");

            tabla.agregarFilaTabla(elementos);
        }

        btnAtrVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityVerQuote.this, ActivityQuotes.class);
                startActivity(intent);
                finish();
            }
        });

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ActivityVerQuote.this, ActivityQuotes.class);
        startActivity(intent);
        finish();
    }
}
