package com.application.aroohfeen.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.application.aroohfeen.R;
import com.application.aroohfeen.presenter.MainPresenter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private MainPresenter mainPresenter;
    private ImageView openNavigationImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresenter = new MainPresenter(this,this);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);
//        bottomNavigationView.getMenu().getItem(2).setEnabled(false);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        openNavigationImageView = findViewById(R.id.navigation_menu);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_framelayout_container,new HomeFragment()).commit();

        openNavigationImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.openSideMenu();
            }
        });
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.sections:
                            selectedFragment = new SectionsFragment();
                            break;
                        case R.id.offers:
                            selectedFragment = new SectionsFragment();
                            break;
                        case R.id.jobs:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.placeholder:
                            selectedFragment = new HomeFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_framelayout_container,selectedFragment).commit();
                    return true;
                }
            };
}