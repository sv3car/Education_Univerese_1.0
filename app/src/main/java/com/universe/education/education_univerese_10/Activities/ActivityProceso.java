package com.universe.education.education_univerese_10.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.universe.education.education_univerese_10.Classes.ClassConexion;
import com.universe.education.education_univerese_10.Classes.ClassZohoJSONDocuments;
import com.universe.education.education_univerese_10.Classes.ClassZohoJSONPotential;
import com.universe.education.education_univerese_10.Classes.ClassZohoJSONQuotes;
import com.universe.education.education_univerese_10.Classes.Potential;
import com.universe.education.education_univerese_10.FragmentsSesion.FragmentSesionHome;
import com.universe.education.education_univerese_10.R;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class ActivityProceso extends AppCompatActivity {

    Bitmap bm;

    ImageView imgV1;
    ImageView imgV2;
    ImageView imgV3;
    ImageView imgV4;
    ImageView imgV5;
    ImageView imgV6;
    ImageView imgV7;
    ImageView imgV8;
    ImageView imgV9;
    ImageView imgV10;
    ImageView imgV11;
    ImageView imgV12;

    ImageView imgVThum1;
    ImageView imgVThum2;
    ImageView imgVThum3;
    ImageView imgVThum4;
    ImageView imgVThum5;
    ImageView imgVThum6;
    ImageView imgVThum7;
    ImageView imgVThum8;
    ImageView imgVThum9;
    ImageView imgVThum10;
    ImageView imgVThum11;
    ImageView imgVThum12;

    Button btnVid1;
    Button btnVid2;
    Button btnVid3;
    Button btnVid4;
    Button btnVid5;
    Button btnVid6;
    Button btnVid7;
    Button btnVid8;
    Button btnVid9;
    Button btnVid10;
    Button btnVid11;
    Button btnVid12;

    RelativeLayout rlProc1;
    RelativeLayout rlProc2;
    RelativeLayout rlProc3;
    RelativeLayout rlProc4;
    RelativeLayout rlProc5;
    RelativeLayout rlProc6;
    RelativeLayout rlProc7;
    RelativeLayout rlProc8;
    RelativeLayout rlProc9;
    RelativeLayout rlProc10;
    RelativeLayout rlProc11;
    RelativeLayout rlProc12;

    TextView tvProc1;
    TextView tvProc2;
    TextView tvProc3;
    TextView tvProc4;
    TextView tvProc5;
    TextView tvProc6;
    TextView tvProc7;
    TextView tvProc8;
    TextView tvProc9;
    TextView tvProc10;
    TextView tvProc11;
    TextView tvProc12;

    TextView tvPorc1;
    TextView tvPorc2;
    TextView tvPorc3;
    TextView tvPorc4;
    TextView tvPorc5;
    TextView tvPorc6;
    TextView tvPorc7;
    TextView tvPorc8;
    TextView tvPorc9;
    TextView tvPorc10;
    TextView tvPorc11;
    TextView tvPorc12;
    String idVideo;

    Boolean control = false;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), ActivitySesion.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso);

        Toolbar toolbar = (Toolbar) findViewById(R.id.home_screen_toolbar_proceso);
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

        imgV1 = (ImageView) findViewById(R.id.imgV1);
        imgV2 = (ImageView) findViewById(R.id.imgV2);
        imgV3 = (ImageView) findViewById(R.id.imgV3);
        imgV4 = (ImageView) findViewById(R.id.imgV4);
        imgV5 = (ImageView) findViewById(R.id.imgV5);
        imgV6 = (ImageView) findViewById(R.id.imgV6);
        imgV7 = (ImageView) findViewById(R.id.imgV7);
        imgV8 = (ImageView) findViewById(R.id.imgV8);
        imgV9 = (ImageView) findViewById(R.id.imgV9);
        imgV10 = (ImageView) findViewById(R.id.imgV10);
        imgV11 = (ImageView) findViewById(R.id.imgV11);
        imgV12 = (ImageView) findViewById(R.id.imgV12);

        imgVThum1 = (ImageView) findViewById(R.id.imgVThum1);
        imgVThum2 = (ImageView) findViewById(R.id.imgVThum2);
        imgVThum3 = (ImageView) findViewById(R.id.imgVThum3);
        imgVThum4 = (ImageView) findViewById(R.id.imgVThum4);
        imgVThum5 = (ImageView) findViewById(R.id.imgVThum5);
        imgVThum6 = (ImageView) findViewById(R.id.imgVThum6);
        imgVThum7 = (ImageView) findViewById(R.id.imgVThum7);
        imgVThum8 = (ImageView) findViewById(R.id.imgVThum8);
        imgVThum9 = (ImageView) findViewById(R.id.imgVThum9);
        imgVThum10= (ImageView) findViewById(R.id.imgVThum10);
        imgVThum11 = (ImageView) findViewById(R.id.imgVThum11);
        imgVThum12 = (ImageView) findViewById(R.id.imgVThum12);

        btnVid1 = (Button) findViewById(R.id.btnVid1);
        btnVid2 = (Button) findViewById(R.id.btnVid2);
        btnVid3 = (Button) findViewById(R.id.btnVid3);
        btnVid4 = (Button) findViewById(R.id.btnVid4);
        btnVid5 = (Button) findViewById(R.id.btnVid5);
        btnVid6 = (Button) findViewById(R.id.btnVid6);
        btnVid7 = (Button) findViewById(R.id.btnVid7);
        btnVid8 = (Button) findViewById(R.id.btnVid8);
        btnVid9 = (Button) findViewById(R.id.btnVid9);
        btnVid10 = (Button) findViewById(R.id.btnVid10);
        btnVid11 = (Button) findViewById(R.id.btnVid11);
        btnVid12 = (Button) findViewById(R.id.btnVid12);

        rlProc1 = (RelativeLayout) findViewById(R.id.rlProc1);
        rlProc2 = (RelativeLayout) findViewById(R.id.rlProc2);
        rlProc3 = (RelativeLayout) findViewById(R.id.rlProc3);
        rlProc4 = (RelativeLayout) findViewById(R.id.rlProc4);
        rlProc5 = (RelativeLayout) findViewById(R.id.rlProc5);
        rlProc6 = (RelativeLayout) findViewById(R.id.rlProc6);
        rlProc7 = (RelativeLayout) findViewById(R.id.rlProc7);
        rlProc8 = (RelativeLayout) findViewById(R.id.rlProc8);
        rlProc9 = (RelativeLayout) findViewById(R.id.rlProc9);
        rlProc10 = (RelativeLayout) findViewById(R.id.rlProc10);
        rlProc11 = (RelativeLayout) findViewById(R.id.rlProc11);
        rlProc12 = (RelativeLayout) findViewById(R.id.rlProc12);

        tvProc1 = (TextView) findViewById(R.id.tvProc1);
        tvProc2 = (TextView) findViewById(R.id.tvProc2);
        tvProc3 = (TextView) findViewById(R.id.tvProc3);
        tvProc4 = (TextView) findViewById(R.id.tvProc4);
        tvProc5 = (TextView) findViewById(R.id.tvProc5);
        tvProc6 = (TextView) findViewById(R.id.tvProc6);
        tvProc7 = (TextView) findViewById(R.id.tvProc7);
        tvProc8 = (TextView) findViewById(R.id.tvProc8);
        tvProc9 = (TextView) findViewById(R.id.tvProc9);
        tvProc10 = (TextView) findViewById(R.id.tvProc10);
        tvProc11 = (TextView) findViewById(R.id.tvProc11);
        tvProc12 = (TextView) findViewById(R.id.tvProc12);

        tvPorc1 = (TextView) findViewById(R.id.tvPorc1);
        tvPorc2 = (TextView) findViewById(R.id.tvPorc2);
        tvPorc3 = (TextView) findViewById(R.id.tvPorc3);
        tvPorc4 = (TextView) findViewById(R.id.tvPorc4);
        tvPorc5 = (TextView) findViewById(R.id.tvPorc5);
        tvPorc6 = (TextView) findViewById(R.id.tvPorc6);
        tvPorc7 = (TextView) findViewById(R.id.tvPorc7);
        tvPorc8 = (TextView) findViewById(R.id.tvPorc8);
        tvPorc9 = (TextView) findViewById(R.id.tvPorc9);
        tvPorc10 = (TextView) findViewById(R.id.tvPorc10);
        tvPorc11 = (TextView) findViewById(R.id.tvPorc11);
        tvPorc12 = (TextView) findViewById(R.id.tvPorc12);

        TareaAsincrona task = new TareaAsincrona();

        try{
            switch (Potential.getFase()) {
                case "Negociación":
                    idVideo = "lzwWiIPHxJ4";
                    rlProc1.setVisibility(View.VISIBLE);
                    task.execute("http://img.youtube.com/vi/"+idVideo+"/0.jpg");
                    imgV1.setImageResource(R.drawable.img_proces_enab);
                    tvProc1.setTypeface(Typeface.DEFAULT_BOLD);
                    tvPorc1.setText("20%");
                    tvPorc1.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case "Presupuesto":
                    idVideo = "Ir1UFs4bSyA";
                    rlProc2.setVisibility(View.VISIBLE);
                    task.execute("http://img.youtube.com/vi/"+idVideo+"/0.jpg");
                    imgV1.setImageResource(R.drawable.img_proces_enab);
                    imgV2.setImageResource(R.drawable.img_proces_enab);
                    tvProc2.setTypeface(Typeface.DEFAULT_BOLD);
                    tvPorc2.setText("30%");
                    tvPorc2.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case "Afiliación/Membresía":
                    idVideo = "59K0vkE1bZE";
                    rlProc3.setVisibility(View.VISIBLE);
                    task.execute("http://img.youtube.com/vi/"+idVideo+"/0.jpg");
                    imgV1.setImageResource(R.drawable.img_proces_enab);
                    imgV2.setImageResource(R.drawable.img_proces_enab);
                    imgV3.setImageResource(R.drawable.img_proces_enab);
                    tvProc3.setTypeface(Typeface.DEFAULT_BOLD);
                    tvPorc3.setText("40%");
                    tvPorc3.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case "Documentos":
                    idVideo = "QnHTE-8DdxU";
                    rlProc4.setVisibility(View.VISIBLE);
                    task.execute("http://img.youtube.com/vi/"+idVideo+"/0.jpg");
                    imgV1.setImageResource(R.drawable.img_proces_enab);
                    imgV2.setImageResource(R.drawable.img_proces_enab);
                    imgV3.setImageResource(R.drawable.img_proces_enab);
                    imgV4.setImageResource(R.drawable.img_proces_enab);
                    tvProc4.setTypeface(Typeface.DEFAULT_BOLD);
                    tvPorc4.setText("50%");
                    tvPorc4.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case "Enrollment":
                    idVideo = "BMXbWnXYaAM";
                    rlProc5.setVisibility(View.VISIBLE);
                    task.execute("http://img.youtube.com/vi/"+idVideo+"/0.jpg");
                    imgV1.setImageResource(R.drawable.img_proces_enab);
                    imgV2.setImageResource(R.drawable.img_proces_enab);
                    imgV3.setImageResource(R.drawable.img_proces_enab);
                    imgV4.setImageResource(R.drawable.img_proces_enab);
                    imgV5.setImageResource(R.drawable.img_proces_enab);
                    tvProc5.setTypeface(Typeface.DEFAULT_BOLD);
                    tvPorc5.setText("55%");
                    tvPorc5.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case "Loo":
                    idVideo = "8iYtQ4Gnx0o";
                    rlProc6.setVisibility(View.VISIBLE);
                    task.execute("http://img.youtube.com/vi/"+idVideo+"/0.jpg");
                    imgV1.setImageResource(R.drawable.img_proces_enab);
                    imgV2.setImageResource(R.drawable.img_proces_enab);
                    imgV3.setImageResource(R.drawable.img_proces_enab);
                    imgV4.setImageResource(R.drawable.img_proces_enab);
                    imgV5.setImageResource(R.drawable.img_proces_enab);
                    imgV6.setImageResource(R.drawable.img_proces_enab);
                    tvProc6.setTypeface(Typeface.DEFAULT_BOLD);
                    tvPorc6.setText("60%");
                    tvPorc6.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case "Confirmación de pago":
                    idVideo = "GRSLTqDE_jo";
                    rlProc7.setVisibility(View.VISIBLE);
                    task.execute("http://img.youtube.com/vi/"+idVideo+"/0.jpg");
                    imgV1.setImageResource(R.drawable.img_proces_enab);
                    imgV2.setImageResource(R.drawable.img_proces_enab);
                    imgV3.setImageResource(R.drawable.img_proces_enab);
                    imgV4.setImageResource(R.drawable.img_proces_enab);
                    imgV5.setImageResource(R.drawable.img_proces_enab);
                    imgV6.setImageResource(R.drawable.img_proces_enab);
                    imgV7.setImageResource(R.drawable.img_proces_enab);
                    tvProc7.setTypeface(Typeface.DEFAULT_BOLD);
                    tvPorc7.setText("70%");
                    tvPorc7.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case "Pago a la escuela":
                    idVideo = "1LS-1BpK55o";
                    rlProc8.setVisibility(View.VISIBLE);
                    task.execute("http://img.youtube.com/vi/"+idVideo+"/0.jpg");
                    imgV1.setImageResource(R.drawable.img_proces_enab);
                    imgV2.setImageResource(R.drawable.img_proces_enab);
                    imgV3.setImageResource(R.drawable.img_proces_enab);
                    imgV4.setImageResource(R.drawable.img_proces_enab);
                    imgV5.setImageResource(R.drawable.img_proces_enab);
                    imgV6.setImageResource(R.drawable.img_proces_enab);
                    imgV7.setImageResource(R.drawable.img_proces_enab);
                    imgV8.setImageResource(R.drawable.img_proces_enab);
                    tvProc8.setTypeface(Typeface.DEFAULT_BOLD);
                    tvPorc8.setText("80%");
                    tvPorc8.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case "Coes":
                    idVideo = "iVDu9NRBn0U";
                    rlProc9.setVisibility(View.VISIBLE);
                    task.execute("http://img.youtube.com/vi/"+idVideo+"/0.jpg");
                    imgV1.setImageResource(R.drawable.img_proces_enab);
                    imgV2.setImageResource(R.drawable.img_proces_enab);
                    imgV3.setImageResource(R.drawable.img_proces_enab);
                    imgV4.setImageResource(R.drawable.img_proces_enab);
                    imgV5.setImageResource(R.drawable.img_proces_enab);
                    imgV6.setImageResource(R.drawable.img_proces_enab);
                    imgV7.setImageResource(R.drawable.img_proces_enab);
                    imgV8.setImageResource(R.drawable.img_proces_enab);
                    imgV9.setImageResource(R.drawable.img_proces_enab);
                    tvProc9.setTypeface(Typeface.DEFAULT_BOLD);
                    tvPorc9.setText("90%");
                    tvPorc9.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case "Visa":
                    idVideo = "UUQ-0Jwwr0M";
                    rlProc10.setVisibility(View.VISIBLE);
                    task.execute("http://img.youtube.com/vi/"+idVideo+"/0.jpg");
                    imgV1.setImageResource(R.drawable.img_proces_enab);
                    imgV2.setImageResource(R.drawable.img_proces_enab);
                    imgV3.setImageResource(R.drawable.img_proces_enab);
                    imgV4.setImageResource(R.drawable.img_proces_enab);
                    imgV5.setImageResource(R.drawable.img_proces_enab);
                    imgV6.setImageResource(R.drawable.img_proces_enab);
                    imgV7.setImageResource(R.drawable.img_proces_enab);
                    imgV8.setImageResource(R.drawable.img_proces_enab);
                    imgV9.setImageResource(R.drawable.img_proces_enab);
                    imgV10.setImageResource(R.drawable.img_proces_enab);
                    tvProc10.setTypeface(Typeface.DEFAULT_BOLD);
                    tvPorc10.setText("95%");
                    tvPorc10.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case "Proximo a viajar":
                    idVideo = "KLACH7lEHQs";
                    rlProc11.setVisibility(View.VISIBLE);
                    task.execute("http://img.youtube.com/vi/"+idVideo+"/0.jpg");
                    imgV1.setImageResource(R.drawable.img_proces_enab);
                    imgV2.setImageResource(R.drawable.img_proces_enab);
                    imgV3.setImageResource(R.drawable.img_proces_enab);
                    imgV4.setImageResource(R.drawable.img_proces_enab);
                    imgV5.setImageResource(R.drawable.img_proces_enab);
                    imgV6.setImageResource(R.drawable.img_proces_enab);
                    imgV7.setImageResource(R.drawable.img_proces_enab);
                    imgV8.setImageResource(R.drawable.img_proces_enab);
                    imgV9.setImageResource(R.drawable.img_proces_enab);
                    imgV10.setImageResource(R.drawable.img_proces_enab);
                    imgV11.setImageResource(R.drawable.img_proces_enab);
                    tvProc11.setTypeface(Typeface.DEFAULT_BOLD);
                    tvPorc11.setText("100%");
                    tvPorc11.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case "Sin actividad":
                    idVideo = "VRA_hR86u-8";
                    rlProc12.setVisibility(View.VISIBLE);
                    task.execute("http://img.youtube.com/vi/"+idVideo+"/0.jpg");
                    imgV1.setImageResource(R.drawable.img_proces_enab);
                    imgV2.setImageResource(R.drawable.img_proces_enab);
                    imgV3.setImageResource(R.drawable.img_proces_enab);
                    imgV4.setImageResource(R.drawable.img_proces_enab);
                    imgV5.setImageResource(R.drawable.img_proces_enab);
                    imgV6.setImageResource(R.drawable.img_proces_enab);
                    imgV7.setImageResource(R.drawable.img_proces_enab);
                    imgV8.setImageResource(R.drawable.img_proces_enab);
                    imgV9.setImageResource(R.drawable.img_proces_enab);
                    imgV10.setImageResource(R.drawable.img_proces_enab);
                    imgV11.setImageResource(R.drawable.img_proces_enab);
                    imgV12.setImageResource(R.drawable.img_proces_sinact);
                    tvProc12.setTypeface(Typeface.DEFAULT_BOLD);
                    tvPorc12.setText("0%");
                    tvPorc12.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                }

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"No se pudo establecer el proceso",Toast.LENGTH_SHORT).show();
        }

        btnVid1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+ idVideo)));
            }
        });

        btnVid2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+ idVideo)));
            }
        });

        btnVid3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+ idVideo)));
            }
        });

        btnVid4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+ idVideo)));
            }
        });

        btnVid5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+ idVideo)));
            }
        });

        btnVid6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+ idVideo)));
            }
        });

        btnVid7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+ idVideo)));
            }
        });

        btnVid8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+ idVideo)));
            }
        });

        btnVid9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+ idVideo)));
            }
        });

        btnVid10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+ idVideo)));
            }
        });

        btnVid11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+ idVideo)));
            }
        });

        btnVid12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+ idVideo)));
            }
        });

    }


    private class TareaAsincrona extends AsyncTask<String, Integer, Boolean> {

        @Override
        public void onPreExecute()
        {
            //aquí se puede colocar código a ejecutarse previo
            //a la operación
        }

        @Override
        protected void onPostExecute(Boolean result)
        {
            //aquí se puede colocar código que
            //se ejecutará tras finalizar
            //progressDialog.dismiss();
            if (control){
                switch (Potential.getFase()) {
                    case "Negociación":
                        imgVThum1.setImageBitmap(bm);
                        imgVThum1.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        break;
                    case "Presupuesto":
                        imgVThum2.setImageBitmap(bm);
                        imgVThum2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        break;
                    case "Afiliación/Membresía":
                        imgVThum3.setImageBitmap(bm);
                        imgVThum3.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        break;
                    case "Documentos":
                        imgVThum4.setImageBitmap(bm);
                        imgVThum4.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        break;
                    case "Enrollment":
                        imgVThum5.setImageBitmap(bm);
                        imgVThum5.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        break;
                    case "Loo":
                        imgVThum6.setImageBitmap(bm);
                        imgVThum6.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        break;
                    case "Confirmación de pago":
                        imgVThum7.setImageBitmap(bm);
                        imgVThum7.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        break;
                    case "Pago a la escuela":
                        imgVThum8.setImageBitmap(bm);
                        imgVThum8.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        break;
                    case "Coes":
                        imgVThum9.setImageBitmap(bm);
                        imgVThum9.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        break;
                    case "Visa":
                        imgVThum10.setImageBitmap(bm);
                        imgVThum10.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        break;
                    case "Proximo a viajar":
                        imgVThum11.setImageBitmap(bm);
                        imgVThum11.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        break;
                    case "Sin actividad":
                        imgVThum12.setImageBitmap(bm);
                        imgVThum12.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        break;
                }
            } else{
                Toast.makeText(getApplicationContext(),ClassConexion.mensaje,Toast.LENGTH_SHORT).show();
            }

        }
        @Override
        protected Boolean doInBackground(String... params) {
            control = false;
            //realizar la operación aquí
            bm = get_imagen(params[0]);
            return null;
        }
    }

    private Bitmap get_imagen(String url) {
        Bitmap bm = null;
        try {
            URL _url = new URL(url);
            URLConnection con = _url.openConnection();
            con.connect();
            InputStream is = con.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();
            control = true;
        } catch (Exception e) {
            ClassConexion.mensaje = "Error al obtener los datos";
            control = false;
        }
        return bm;
    }





}
