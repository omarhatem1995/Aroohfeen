package com.application.aroohfeen.presenter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.application.aroohfeen.R;
import com.application.aroohfeen.adapter.MainProductsAdapter;
import com.application.aroohfeen.adapter.SliderAdapter;
import com.application.aroohfeen.model.MainProductsItem;
import com.application.aroohfeen.model.SliderItem;
import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MainPresenter {
    private Activity activity;
    private Context context;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    public MainPresenter(Activity activity, Context context) {
        this.activity = activity;
        this.context = context;
        drawerLayout = ((Activity) context).findViewById(R.id.drawerLayout);
        navigationView = ((Activity) context).findViewById(R.id.nav_view);

    }

    public void openSideMenu() {
        drawerLayout.openDrawer(GravityCompat.START);
    }


}
