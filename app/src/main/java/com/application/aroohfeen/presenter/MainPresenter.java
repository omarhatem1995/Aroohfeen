package com.application.aroohfeen.presenter;

import android.app.Activity;
import android.content.Context;

import com.application.aroohfeen.R;
import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainPresenter {
    private  Activity activity;
    private Context context;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    public MainPresenter(Activity activity, Context context){
        this.activity = activity;
        this.context = context;
        drawerLayout = ((Activity) context).findViewById(R.id.drawerLayout);
        navigationView = ((Activity) context).findViewById(R.id.nav_view);

    }

    public void openSideMenu() {
        drawerLayout.openDrawer(GravityCompat.START);
    }
}
