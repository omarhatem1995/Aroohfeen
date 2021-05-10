package com.application.aroohfeen.ui;

import androidx.appcompat.app.AppCompatActivity;

import com.application.aroohfeen.R;
import com.application.aroohfeen.presenter.LoginPresenter;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class LoginActivity extends AppCompatActivity {

    private LoginPresenter loginPresenter;

    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FacebookSdk.sdkInitialize(getApplicationContext());
        initViews();

        initPresenter();

    }

    private void initViews(){

    }

    private void initPresenter(){
        loginPresenter = new LoginPresenter(this,this);

        loginPresenter.initFacebookLogin();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        loginPresenter.activityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

}