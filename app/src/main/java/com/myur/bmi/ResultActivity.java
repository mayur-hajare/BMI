package com.myur.bmi;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    android.widget.Button mcalculatebmi;
    TextView mBmiDisplay, mBmiCat, mGender;
    Intent intent;
    ImageView imageView;
    String mBmi;
    Float intBmi, intHeight, intWeight;
    String height, weight;
    RelativeLayout mBackground;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        getSupportActionBar().show();
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"><font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#E91E63"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);




    }
}