package com.application.aroohfeen.presenter;

import android.app.Activity;
import android.content.Context;

import com.application.aroohfeen.R;
import com.application.aroohfeen.adapter.SliderAdapter;
import com.application.aroohfeen.model.SliderItem;
import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

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

    public void getDefaultSlider() {
        SliderView sliderView = ((Activity) context).findViewById(R.id.imageSlider);
        SliderAdapter sliderAdapter = new SliderAdapter(context);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setScrollTimeInSec(3); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        ArrayList<SliderItem> list = new ArrayList<>();

        list.add(new SliderItem(
                R.drawable.image2,
                "getString(R.string.slider_title_1)",
                "getString(R.string.slider_message_1)"));
        list.add(new SliderItem(
                R.drawable.image1,
                "getString(R.string.slider_message_1)",
                "getString(R.string.slider_message_1)"));
        list.add(new SliderItem(
                R.drawable.image2,
                "getString(R.string.slider_message_1)",
                "getString(R.string.slider_message_1)"));
        list.add(new SliderItem(
                R.drawable.image1,
                "getString(R.string.slider_message_1)",
                "getString(R.string.slider_message_1)"));
        list.add(new SliderItem(
                R.drawable.image2,
                "getString(R.string.slider_message_1)",
                "getString(R.string.slider_message_1)"));
        list.add(new SliderItem(
                R.drawable.image1,
                "getString(R.string.slider_message_1)",
                "getString(R.string.slider_message_1)"));
        list.add(new SliderItem(
                R.drawable.image2,
                "getString(R.string.slider_message_1)",
                "getString(R.string.slider_message_1)"));
        list.add(new SliderItem(
                R.drawable.image1,
                "getString(R.string.slider_message_1)",
                "getString(R.string.slider_message_1)"));
        list.add(new SliderItem(
                R.drawable.image2,
                "getString(R.string.slider_message_1)",
                "getString(R.string.slider_message_1)"));
        list.add(new SliderItem(
                R.drawable.image1,
                "getString(R.string.slider_message_1)",
                "getString(R.string.slider_message_1)"));

        sliderAdapter.renewItems(list);
    }
}
