package com.application.aroohfeen.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.application.aroohfeen.R;
import com.application.aroohfeen.utils.UtilsFunctions;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.util.Calendar;
import java.util.TimeZone;

public class SignupActivity extends AppCompatActivity {

    private ConstraintLayout constraintLayoutBirthDate ;
    private Button editTextBirthDate;
    FragmentManager mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editTextBirthDate = findViewById(R.id.calendar_et);
        mFragment = getSupportFragmentManager();
        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText("Select a date");
        final MaterialDatePicker materialDatePicker = builder.build();
        editTextBirthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("ButtonOK", " is called");
                    materialDatePicker.show(mFragment,
                            "DATE_PICKER");

            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
                calendar.setTimeInMillis((Long) selection);
              editTextBirthDate.setText(UtilsFunctions.convertToBirthDate((Long) selection) + "");
            }
        });

    }
}
