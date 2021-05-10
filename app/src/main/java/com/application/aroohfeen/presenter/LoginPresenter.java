package com.application.aroohfeen.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;

import com.application.aroohfeen.ui.MainActivity;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class LoginPresenter {

    private CallbackManager callbackManager;
    private Activity activity;
    private Context context;

    public LoginPresenter(Activity activity, Context context){
        this.activity = activity;
        this.context = context;
    }


    public void initFacebookLogin() {


        LoginManager.getInstance().logInWithReadPermissions(activity, Arrays.asList("public_profile",
                "email","user_birthday"));

        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        handleFacebookToken(loginResult.getAccessToken());
                    }



                    @Override
                    public void onCancel() {
                        // App code
                        Log.d("loginResult", "loginResult.getAccessToken().is Canceled");

                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                        Log.d("loginResult", exception.toString());

                    }
                });
    }
    GraphRequest request;
    private void handleFacebookToken(AccessToken accessToken) {
        Log.d("tokenFb", accessToken.getToken());
        Profile profile = Profile.getCurrentProfile();
        if(profile != null){
            String facebook_id  = profile.getId();
            String f_name = profile.getFirstName();
            String f_lastname = profile.getLastName();
            String f_profileImage = profile.getProfilePictureUri(300,300).toString();


            request = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
                @Override
                public void onCompleted(JSONObject object, GraphResponse response) {
                    Log.d("getFacebook", "graphRequest is called");
                    if (response != null) {

                        try {
                            String profile_name = object.getString("name");
                            String email = object.getString("email");
//                            String gender = object.getString("gender");

                            long fb_id = object.getLong("id");
                            Log.d("getFacebook", email + " , " + "gender" + " , " + profile_name
                                    + " , " + fb_id);
                    }catch (JSONException e){
                        Log.d("getFacebook" , " exception : "+ e.getMessage());
                    }
                    }

                }

            });
            Bundle parameters = new Bundle();
            parameters.putString("fields", "id,name,email");
            request.setParameters(parameters);
            request.executeAsync();

            Log.d("getfacebok", facebook_id + "  ,"+ f_lastname + "  ,"+ f_name + "  ,"+ f_profileImage);
        }
    }
    public void activityResult(int requestCode, int resultCode, Intent data){
        //right your code here .
        callbackManager.onActivityResult(requestCode, resultCode, data);

   /*     AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();*/


//        activity.startActivity(new Intent(activity, MainActivity.class));
        Log.d("onActivityResult", " activity Result");
    }
}
