package com.universe.education.education_univerese_10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Main3Activity extends AppCompatActivity {

    Button btn, btnn;
    RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btn = (Button) findViewById(R.id.btn);
        btnn = (Button) findViewById(R.id.btnn);

        rl = (RelativeLayout) findViewById(R.id.rl);

        rl.setVisibility(View.GONE);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                btn.setEnabled(false);
                btnn.setEnabled(true);
                rl.setVisibility(View.VISIBLE);

                ImageView image = (ImageView) findViewById(R.id.imv1);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.together);
                image.startAnimation(animation);

            }
        });

        btnn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                btn.setEnabled(true);
                btnn.setEnabled(false);
                rl.setVisibility(View.GONE);


            }
        });

    }
}



