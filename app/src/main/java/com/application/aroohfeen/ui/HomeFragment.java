package com.application.aroohfeen.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.application.aroohfeen.R;
import com.application.aroohfeen.adapter.MainProductsAdapter;
import com.application.aroohfeen.adapter.SliderAdapter;
import com.application.aroohfeen.model.MainProductsItem;
import com.application.aroohfeen.model.SliderItem;
import com.application.aroohfeen.presenter.MainPresenter;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends Fragment {
    private MainActivity activity;
    private Context context;
    MainPresenter mainPresenter;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        mainPresenter = new MainPresenter(getActivity(),getContext());

        getDefaultSlider();

        mainRecyclerView();

        return view;

    }
    public void getDefaultSlider() {

        Log.d("getDefaultSlider", "is called");
        SliderView sliderView = view.findViewById(R.id.imageSlider_home);
        SliderAdapter sliderAdapter = new SliderAdapter(getContext());

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
        Toast.makeText(getContext(), "Tiast", Toast.LENGTH_SHORT).show();
        sliderAdapter.renewItems(list);
    }

    private RecyclerView recyclerView;
    private MainProductsAdapter mainProductsAdapter;
    private List<MainProductsItem> mainProductsList;
    private MainProductsItem mainProductsItem ;

    public void mainRecyclerView() {
        recyclerView = view.findViewById(R.id.recyclerview_main_products_home);
        setUpMyOrderList();

        mainProductsList = new ArrayList<>();

        for(int i = 0 ; i < 9 ; i++){
            mainProductsItem = new MainProductsItem();
            mainProductsItem.setProductName("item " + i);
            mainProductsItem.setProductImage(R.drawable.image1);
            mainProductsList.add(mainProductsItem);
        }

        mainProductsAdapter = new MainProductsAdapter(getContext().getApplicationContext()
                ,mainProductsList);
        recyclerView.setAdapter(mainProductsAdapter);
    }
    private void setUpMyOrderList() {
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);
    }
}
