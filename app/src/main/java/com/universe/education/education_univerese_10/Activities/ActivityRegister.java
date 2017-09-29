package com.universe.education.education_univerese_10.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.universe.education.education_univerese_10.R;

public class ActivityRegister extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tv6;
    TextView tv7;
    TextView tv_btn1;
    TextView tv_btn2;
    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv6 = (TextView) findViewById(R.id.tv6);
        tv7 = (TextView) findViewById(R.id.tv7);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        tv_btn1 = (TextView) findViewById(R.id.tv_btn1);
        tv_btn2 = (TextView) findViewById(R.id.tv_btn2);

        Typeface bell_centennial = Typeface.createFromAsset(getAssets(),"fonts/bell_centennial.otf");
        tv1.setTypeface(bell_centennial);
        tv2.setTypeface(bell_centennial);
        tv3.setTypeface(bell_centennial);
        tv4.setTypeface(bell_centennial);
        tv5.setTypeface(bell_centennial);
        tv6.setTypeface(bell_centennial);
        tv7.setTypeface(bell_centennial);
        btn1.setTypeface(bell_centennial);
        btn2.setTypeface(bell_centennial);
        tv_btn1.setTypeface(bell_centennial);
        tv_btn2.setTypeface(bell_centennial);
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(ActivityRegister.this, ActivityInicio.class);
        startActivity(intent);
        finish();
        //Añade más funciones si fuese necesario

    }
}
