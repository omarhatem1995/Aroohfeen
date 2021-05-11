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
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import androidx.annotation.NonNull;

public class LoginPresenter {

    private CallbackManager callbackManager;
    private Activity activity;
    private Context context;
    private GraphRequest request;

    public LoginPresenter(Activity activity, Context context) {
        this.activity = activity;
        this.context = context;
    }


    public void initFacebookLogin() {

        FacebookSdk.sdkInitialize(context.getApplicationContext());

/*        LoginManager.getInstance().logInWithReadPermissions(activity, Arrays.asList("public_profile",
                "email", "user_birthday"));*/

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

    private void handleFacebookToken(AccessToken accessToken) {
        Log.d("tokenFb", accessToken.getToken());
        Profile profile = Profile.getCurrentProfile();
        if (profile != null) {
            String facebook_id = profile.getId();
            String f_name = profile.getFirstName();
            String f_lastname = profile.getLastName();
            String f_profileImage = profile.getProfilePictureUri(300, 300).toString();
            Log.d("getfacebok", facebook_id + "  ," + f_lastname + "  ," + f_name + "  ," + f_profileImage);

        } else {
            Log.d("getFacebook", "profile is nulll");
        }
        request = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                Log.d("getFacebook", "graphRequest is called");
                if (response != null) {

                    try {
                        String profile_name = object.getString("name");
                        String email = object.getString("email");
                        long fb_id = object.getLong("id");

                        Log.d("getFacebook", email + " , " + "gender" + " , " + profile_name
                                + " , " + fb_id);
                    } catch (JSONException e) {
                        Log.d("getFacebook", " exception : " + e.getMessage());
                    }
                }

            }

        });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,email");
        request.setParameters(parameters);
        request.executeAsync();


    }
    int RC_SIGN_IN = 1223;
    public void activityResult(int requestCode, int resultCode, Intent data) {
        //right your code here .
        callbackManager.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }

//        activity.startActivity(new Intent(activity, MainActivity.class));
        Log.d("onActivityResult", " activity Result");
    }

GoogleSignInClient mGoogleSignInClient;

    public void initGoogleLogin() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(context, gso);

// Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(context);
//        updateUI(account);
        // Build a GoogleSignInClient with the options specified by gso.
//        mGoogleSignInClient = GoogleSignIn.getClient(context, gso);


    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            Log.w("TAGGoogle", "signInResult:Success code=" + account.getDisplayName() +
                    "e.getStatusCode()" + account.getEmail());
            account.getDisplayName();
            // Signed in successfully, show authenticated UI.
//            updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("TAGGoogle", "signInResult:failed code=" + e.getStatusCode());
//            updateUI(null);
        }
    }
    public void googleSignIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        activity.startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    public void googleSignOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(activity, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // ...
                    }
                });
    }
}
