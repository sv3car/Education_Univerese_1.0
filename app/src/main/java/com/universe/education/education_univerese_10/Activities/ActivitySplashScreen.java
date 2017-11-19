package com.universe.education.education_univerese_10.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import com.universe.education.education_univerese_10.R;

public class ActivitySplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Código para llamar el ActivityInicio
        new Handler().postDelayed
                (new Runnable() {
            @Override
            public void run()
            {
                Intent intent = new Intent(ActivitySplashScreen.this,ActivityInicio.class);
                startActivity(intent);
                finish();
            }
        },
                //Segundos de duración del SplashScream
                2500);

    }
}
