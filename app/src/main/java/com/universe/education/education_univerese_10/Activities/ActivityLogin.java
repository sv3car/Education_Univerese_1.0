package com.universe.education.education_univerese_10.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.util.Xml;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.universe.education.education_univerese_10.Classes.ClassConexion;
import com.universe.education.education_univerese_10.Classes.ClassZohoVar;
import com.universe.education.education_univerese_10.Classes.ClassZohoXMLPotential;
import com.universe.education.education_univerese_10.FragmentsSesion.FragmentSesion2;
import com.universe.education.education_univerese_10.R;

import org.xmlpull.v1.XmlPullParser;

import java.util.regex.Pattern;

public class ActivityLogin extends AppCompatActivity {

    RelativeLayout rl;
    TextView tv1;
    TextView tv2;
    TextView tv_or;
    TextView tv_pass;
    TextView tv_btn1;
    TextView tv_btn2;
    EditText et_email;
    EditText et_pass;
    Button btn1;
    Button btn2;
    String email;
    String password;
    String mes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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

        rl.setVisibility(View.GONE);

        //Evento del boton iniciar con facebook
        btn1.setOnClickListener(v ->
                System.out.println("hola")
        );



        //Evento del boton iniciar con email
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
                }
            }
        });

        //Evento del link olvido contraseña
        tv_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Intent intent = new Intent(ActivityLogin.this,ActivitySesion.class);
                startActivity(intent);*/
            }
        });
    }

    private boolean validarEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }


    private class TareaAsincrona extends AsyncTask<String, Integer, Boolean> {

        String IdOrMes;
        String mensaje;
        Boolean Control = false;

        @Override
        public void onPreExecute()
        {
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            rl.setVisibility(View.VISIBLE);
            et_email.setEnabled(false);
            et_pass.setEnabled(false);
            tv_pass.setEnabled(false);
            ImageView image = (ImageView) findViewById(R.id.imv1);
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.together);
            image.startAnimation(animation);
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
            rl.setVisibility(View.GONE);
            et_email.setEnabled(true);
            et_pass.setEnabled(true);
            tv_pass.setEnabled(true);
            if(Control)
            {
                Intent intent = new Intent(ActivityLogin.this, ActivitySesion.class);
                FragmentSesion2.ContrFrag = false;
                startActivity(intent);
                finish();
            }
            else
            {
                Toast.makeText(ActivityLogin.this, mensaje,
                        Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected Boolean doInBackground(String... params) {

            //realizar la operación aquí
            if (ClassConexion.isNetworkConnected(getApplicationContext()))
            {
                new ClassConexion("https://crm.zoho.com/crm/private/xml/Potentials" +
                        "/searchRecords?authtoken=8b49fd4b66f4a9e2098d9c2d79652405" +
                        "&scope=crmapi&criteria=(Correo%20electronico:"+params[0]+")&newFormat=1");
                ///////////////////////////////////////////////////////////////////////////////////
                XmlPullParser parser = Xml.newPullParser();


                IdOrMes = new ClassZohoXMLPotential().IdOrMes();
                if (IdOrMes.equals("There is no data to show") ||
                        !ClassZohoXMLPotential.correoBusc.equals(params[0]) ||
                        !ClassZohoXMLPotential.passBusc.equals(params[1]))
                {
                    Control = false;
                    mensaje = "El correo electrónico y la contraseña no coinciden";

                }
                else
                {
                    Control = true;
                }
            }
            else
            {
                mensaje = "Verifique su conexión a internet";
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
