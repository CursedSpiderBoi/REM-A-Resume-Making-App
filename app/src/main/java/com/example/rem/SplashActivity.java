package com.example.rem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView logo = findViewById(R.id.logo);
        TextView appName = findViewById(R.id.appName);
        Animation moveUp = new TranslateAnimation(0, 0, 2000, 0);
        Animation fadeIn = new AlphaAnimation(0, 1);
        moveUp.setDuration(2000);
        fadeIn.setDuration(2000);
        moveUp.setFillAfter(true);
        fadeIn.setFillAfter(true);
        appName.startAnimation(moveUp);
        appName.startAnimation(fadeIn);
        logo.startAnimation(fadeIn);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 3000);
    }
}

