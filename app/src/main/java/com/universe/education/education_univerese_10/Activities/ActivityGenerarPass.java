package com.universe.education.education_univerese_10.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.universe.education.education_univerese_10.Classes.ClassConexion;
import com.universe.education.education_univerese_10.Classes.ClassZohoJSONPotential;
import com.universe.education.education_univerese_10.Classes.ClassZohoJSONPotentialCons;
import com.universe.education.education_univerese_10.Classes.ClassZohoXMLPotentialPass;
import com.universe.education.education_univerese_10.Classes.Mail;
import com.universe.education.education_univerese_10.Classes.PasswordGenerator;
import com.universe.education.education_univerese_10.R;

import java.util.regex.Pattern;

public class ActivityGenerarPass extends AppCompatActivity {

    private TextView tv1;
    private TextView tv2;
    private TextView tv_btn2;
    private Button btn2;
    private EditText et_email;
    private View v;
    private String email;
    private String psw;

    protected ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generar_pass);

        progressBar = (ProgressBar) findViewById(R.id.progressBar1) ;
        progressBar.setMax(10);
        progressBar.setVisibility(View.GONE);

        btn2 = (Button) findViewById(R.id.btn2);
        et_email = (EditText) findViewById(R.id.et_email);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv_btn2 = (TextView) findViewById(R.id.tv_btn2);

        Typeface bell_centennial = Typeface.createFromAsset(getAssets(),"fonts/bell_centennial.otf");

        et_email.setTypeface(bell_centennial);
        tv1.setTypeface(bell_centennial);
        tv2.setTypeface(bell_centennial);
        tv_btn2.setTypeface(bell_centennial);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v = view;
                email = et_email.getText().toString();
                psw = PasswordGenerator.getPassword(
                        PasswordGenerator.MINUSCULAS+
                                PasswordGenerator.MAYUSCULAS+
                                PasswordGenerator.NUMEROS,8);

                if (email.equals(""))
                {
                    et_email.setError("Ingrese un Email");
                } else if (!validarEmail(email)) {
                    et_email.setError("Email no válido");
                } else {
                    TareaAsincrona task = new TareaAsincrona();
                    task.execute(email,psw);
                    /*Intent intent = new Intent(ActivityLogin.this, ActivitySesion.class);
                    FragmentSesionHome.ContrFrag = false;
                    startActivity(intent);
                    finish();*/
                }

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
            btn2.setEnabled(false);
            progressBar.setVisibility(View.VISIBLE);
            et_email.setEnabled(false);
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
            btn2.setEnabled(true);
            progressBar.setVisibility(View.GONE);
            et_email.setEnabled(true);
            Snackbar.make(v, ClassConexion.mensaje,Snackbar.LENGTH_LONG).show();
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
                        "Correo%20electronico)&" +
                        "criteria=(Correo%20electronico:"+params[0]+")");
                new ClassZohoJSONPotentialCons();

                if (ClassZohoJSONPotentialCons.compPot){
                    new ClassConexion("https://crm.zoho.com/crm/private/xml/Potentials" +
                            "/updateRecords?authtoken=8b49fd4b66f4a9e2098d9c2d79652405" +
                            "&scope=crmapi&newFormat=1&id=" + ClassZohoJSONPotentialCons.idPotPass + "&" +
                            "xmlData=%3cLeads%3e%3crow%20no=%221%22%3e%3cFL%20val=%22Codigo%22%3e" +
                            "" + params[1] + "" +
                            "%3c/FL%3e%3c/row%3e%3c/Leads%3e");
                    new ClassZohoXMLPotentialPass().respuesta();
                }

                if (ClassConexion.msj) {
                    if (!ClassZohoJSONPotentialCons.correoBusc.equals(params[0])) {
                        ClassConexion.mensaje = "El correo electrónico no se encuentra en la BD";
                    } else {
                        Mail m = new Mail("sv3car@gmail.com", "sv3131tes");
                        String[] toArr = {"sv3car@gmail.com"};
                        m.setTo(toArr);
                        m.setFrom("sv3car@gmail.com");
                        m.setSubject("Nueva Contraseña");
                        m.setBody("Su contraseña es: " + params[1]);
                        try {
                            //m.addAttachment("/sdcard/filelocation");
                            if(m.send()) {
                                ClassConexion.mensaje = "Se ha enviado un correo con su contraseña";
                            } else {
                                ClassConexion.mensaje = "No se pudo enviar el correo, intente mas tarde";
                            }
                        } catch(Exception e) {
                            //Toast.makeText(MailApp.this, "There was a problem sending the email.", Toast.LENGTH_LONG).show();
                            Log.e("MailApp", "Could not send email", e);
                        }
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
        Intent intent = new Intent(ActivityGenerarPass.this, ActivityLogin.class);
        startActivity(intent);
        finish();
        //Añade más funciones si fuese necesario
    }
}
