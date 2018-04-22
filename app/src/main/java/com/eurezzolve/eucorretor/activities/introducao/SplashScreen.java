package com.eurezzolve.eucorretor.activities.introducao;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.eurezzolve.eucorretor.R;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 1500;
    private ProgressBar progressBar;

    //SplashScreen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        progressBar = findViewById(R.id.barradeProgresso);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.VISIBLE);
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
