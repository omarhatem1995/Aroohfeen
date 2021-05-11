package com.application.aroohfeen.ui;

import androidx.appcompat.app.AppCompatActivity;

import com.application.aroohfeen.R;
import com.application.aroohfeen.presenter.LoginPresenter;
import com.facebook.CallbackManager;
import com.google.android.gms.common.SignInButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private LoginPresenter loginPresenter;

    private CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        initPresenter();

    }

    private void initViews() {
// Set the dimensions of the sign-in button.
        SignInButton signInButton = findViewById(R.id.button_gmail_login);
        signInButton.setSize(SignInButton.SIZE_WIDE);

        TextView orRegister = findViewById(R.id.or_register);

        orRegister.setOnClickListener(this);
        signInButton.setOnClickListener(this);
    }

    private void initPresenter() {
        loginPresenter = new LoginPresenter(this, this);

        loginPresenter.initGoogleLogin();

        loginPresenter.initFacebookLogin();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        loginPresenter.activityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_gmail_login:
                loginPresenter.googleSignIn();
                break;
            case R.id.or_register:
                startActivity(new Intent(this, SignupActivity.class));
                break;
        }
    }
}