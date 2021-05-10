package com.application.aroohfeen.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.application.aroohfeen.R;

public class SplashScreenActivity extends AppCompatActivity {

    private ImageView backgroundImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        initViews();

    }
    private void initViews(){
        backgroundImage = findViewById(R.id.image_splash);
        handleGif(LoginActivity.class,3000,null);
    }
    public void handleGif(Class activity, long delay, String extras){
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent intent = new Intent(this,activity);
            Bundle extra = new Bundle();
            extra.putString("activity", extras);
            intent.putExtras(extra);
            startActivity(intent);
            finish();
        },delay);
    }
}