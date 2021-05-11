package com.application.aroohfeen.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.application.aroohfeen.R;
import com.application.aroohfeen.model.SliderItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private SliderView sliderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        sliderView = findViewById(R.id.imageSlider);

        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);
        getDefaultSlider();

    }
    public void getDefaultSlider() {
        SliderView sliderView = findViewById(R.id.imageSlider);
        SliderAdapter sliderAdapter = new SliderAdapter(this);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setScrollTimeInSec(3); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        ArrayList<SliderItem> list = new ArrayList<>();

        list.add(new SliderItem(
                R.drawable.com_facebook_button_background,
                "getString(R.string.slider_title_1)",
                "getString(R.string.slider_message_1)"));
        list.add(new SliderItem(
                R.drawable.com_facebook_auth_dialog_header_background,
                "getString(R.string.slider_message_1)",
                "getString(R.string.slider_message_1)"));
        list.add(new SliderItem(
                R.drawable.com_facebook_auth_dialog_header_background,
                "getString(R.string.slider_message_1)",
                "getString(R.string.slider_message_1)"));
        list.add(new SliderItem(
                R.drawable.com_facebook_auth_dialog_header_background,
                "getString(R.string.slider_message_1)",
                "getString(R.string.slider_message_1)"));
        list.add(new SliderItem(
                R.drawable.com_facebook_auth_dialog_header_background,
                "getString(R.string.slider_message_1)",
                "getString(R.string.slider_message_1)"));
        list.add(new SliderItem(
                R.drawable.com_facebook_auth_dialog_header_background,
                "getString(R.string.slider_message_1)",
                "getString(R.string.slider_message_1)"));
        list.add(new SliderItem(
                R.drawable.com_facebook_auth_dialog_header_background,
                "getString(R.string.slider_message_1)",
                "getString(R.string.slider_message_1)"));
        list.add(new SliderItem(
                R.drawable.com_facebook_auth_dialog_header_background,
                "getString(R.string.slider_message_1)",
                "getString(R.string.slider_message_1)"));
        list.add(new SliderItem(
                R.drawable.com_facebook_auth_dialog_header_background,
                "getString(R.string.slider_message_1)",
                "getString(R.string.slider_message_1)"));
        list.add(new SliderItem(
                R.drawable.com_facebook_auth_dialog_header_background,
                "getString(R.string.slider_message_1)",
                "getString(R.string.slider_message_1)"));

        sliderAdapter.renewItems(list);
    }
}