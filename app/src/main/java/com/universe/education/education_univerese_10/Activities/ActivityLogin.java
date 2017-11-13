package com.universe.education.education_univerese_10.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.universe.education.education_univerese_10.Classes.ClassConexion;
import com.universe.education.education_univerese_10.Classes.ClassZohoJSONDocuments;
import com.universe.education.education_univerese_10.Classes.ClassZohoJSONPotential;
import com.universe.education.education_univerese_10.Classes.ClassZohoJSONQuotes;
import com.universe.education.education_univerese_10.Classes.Potential;
import com.universe.education.education_univerese_10.FragmentsSesion.FragmentSesionHome;
import com.universe.education.education_univerese_10.R;

import java.util.regex.Pattern;

public class ActivityLogin extends AppCompatActivity {

    private RelativeLayout rl;
    private TextView tv1;
    private TextView tv2;
    private TextView tv_or;
    private TextView tv_pass;
    private TextView tv_btn1;
    private TextView tv_btn2;
    private EditText et_email;
    private EditText et_pass;
    private Button btn1;
    private Button btn2;
    private String email;
    private String password;
    private View v;
    protected ProgressBar progressBar;

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = (ProgressBar) findViewById(R.id.progressBar1) ;
        progressBar.setMax(10);
        progressBar.setVisibility(View.GONE);

        rl = (RelativeLayout) findViewById(R.id.rl);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv_pass = (TextView) findViewById(R.id.tv_pass);
        tv_btn1 = (TextView) findViewById(R.id.tv_btn1);
        tv_btn2 = (TextView) findViewById(R.id.tv_btn2);
        tv_or = (TextView) findViewById(R.id.tv_or);
        et_email = (EditText) findViewById(R.id.et_email);
        et_pass = (EditText) findViewById(R.id.et_pass);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        Typeface bell_centennial = Typeface.createFromAsset(getAssets(),"fonts/bell_centennial.otf");
        tv1.setTypeface(bell_centennial);
        tv2.setTypeface(bell_centennial);
        tv_pass.setTypeface(bell_centennial);
        tv_or.setTypeface(bell_centennial);
        et_email.setTypeface(bell_centennial);
        et_pass.setTypeface(bell_centennial);
        tv_btn1.setTypeface(bell_centennial);
        tv_btn2.setTypeface(bell_centennial);

        //Evento del boton iniciar con facebook

        btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("hola");
                }
            }
        );

        //Evento del boton iniciar con email
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                v = view;
                email = et_email.getText().toString();
                password = et_pass.getText().toString();

                if ((email.equals("")) && (password.equals("")))
                {
                    et_email.setError("Ingrese un Email");
                    et_pass.setError("Ingrese un Password");
                }
                else if (email.equals(""))
                {
                    et_email.setError("Ingrese un Email");
                }
                else if (password.equals(""))
                {
                    et_pass.setError("Ingrese un Password");
                }
                else if (!validarEmail(email))
                {
                    et_email.setError("Email no válido");
                }
                else
                {
                    TareaAsincrona task = new TareaAsincrona();
                    task.execute(email,password);
                    /*Intent intent = new Intent(ActivityLogin.this, ActivitySesion.class);
                    FragmentSesionHome.ContrFrag = false;
                    startActivity(intent);
                    finish();*/
                }
            }
        });

        //Evento del link olvido contraseña
        tv_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Intent intent = new Intent(ActivityLogin.this,ActivitySesionPrueba.class);
                startActivity(intent);*/
            }
        });
    }

    private boolean validarEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }


    private class TareaAsincrona extends AsyncTask<String, Integer, Boolean> {

        Boolean control = false;

        @Override
        public void onPreExecute()
        {
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            progressBar.setVisibility(View.VISIBLE);
            et_email.setEnabled(false);
            et_pass.setEnabled(false);
            tv_pass.setEnabled(false);
            /*ImageView image = (ImageView) findViewById(R.id.imv1);
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.together);
            image.startAnimation(animation);*/
            //aquí se puede colocar código a ejecutarse previo
            //a la operación
        }

        @Override
        protected void onPostExecute(Boolean result)
        {
            //aquí se puede colocar código que
            //se ejecutará tras finalizar
            //progressDialog.dismiss();
            btn1.setEnabled(true);
            btn2.setEnabled(true);
            progressBar.setVisibility(View.GONE);
            et_email.setEnabled(true);
            et_pass.setEnabled(true);
            tv_pass.setEnabled(true);
            if(control)
            {
                Intent intent = new Intent(ActivityLogin.this, ActivitySesion.class);
                FragmentSesionHome.ContrFrag = false;
                startActivity(intent);
                finish();
                //Snackbar.make(v, ClassZohoJSONQuotes.aux +" "+ ClassZohoJSONQuotes.auxInt,Snackbar.LENGTH_LONG).show();
            }
            else
            {

                Snackbar.make(v, ClassConexion.mensaje,Snackbar.LENGTH_LONG).show();
                /*Toast.makeText(ActivityLogin.this, mensaje,
                        Toast.LENGTH_SHORT).show();*/
            }
        }

        @Override
        protected Boolean doInBackground(String... params) {

            //realizar la operación aquí
            if (ClassConexion.isNetworkConnected(getApplicationContext()))
            {
                new ClassConexion("https://crm.zoho.com/crm/private/json/Potentials/" +
                        "searchRecords?authtoken=8b49fd4b66f4a9e2098d9c2d79652405&" +
                        "scope=crmapi&&newFormat=1&version=2&" +
                        "selectColumns=" +
                        "Potentials(" +
                        "Potential%20Name," +
                        "Stage," +
                        "Correo%20electronico," +
                        "Codigo," +
                        "Nivel%20de%20ingles," +
                        "Viaja," +
                        "Nivel%20de%20estudios," +
                        "Numero%20pasaporte%20estudiante," +
                        "Nacionalidad%20estudiante," +
                        "Fecha%20Aprox%20desea%20viajar," +
                        "Estado%20de%20aplicacion%20visa)&" +
                        "criteria=(Correo%20electronico:"+params[0]+")");
                new ClassZohoJSONPotential();

                if (ClassZohoJSONPotential.compPot){
                    new ClassConexion("https://crm.zoho.com/crm/private/json/Quotes/getRelatedRecords?" +
                            "authtoken=8b49fd4b66f4a9e2098d9c2d79652405&scope=crmapi&" +
                            "id="+Potential.getIdPot()+"&parentModule=Potentials&newFormat=1");
                    new ClassZohoJSONQuotes();

                    new ClassConexion("https://crm.zoho.com/crm/private/json/Attachments/getRelatedRecords?" +
                            "authtoken=8b49fd4b66f4a9e2098d9c2d79652405&newFormat=1&scope=crmapi&" +
                            "parentModule=Potentials&id="+Potential.getIdPot());
                    new ClassZohoJSONDocuments();
                }

                if (ClassConexion.msj) {
                    if (!ClassZohoJSONPotential.correoBusc.equals(params[0]) ||
                            !ClassZohoJSONPotential.passBusc.equals(params[1])) {
                        control = false;
                        ClassConexion.mensaje = "El correo electrónico y la contraseña no coinciden";
                    }
                    else {
                        control = true;
                    }
                }
            } else {
                ClassConexion.mensaje = "Verifique su conexión a internet";
                control = false;
            }
            return null;
        }
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(ActivityLogin.this, ActivityInicio.class);
        startActivity(intent);
        finish();
        //Añade más funciones si fuese necesario
    }
}
