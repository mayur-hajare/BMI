package com.myur.bmi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    com.airbnb.lottie.LottieAnimationView animationView;
    android.widget.Button mCalculateBmi;
    TextView mBmiDisplay, mBmiCat, mGender;
    Intent intent;
    ImageView mImageView;
    String mBmi;
    Float intBmi, intHeight, intWeight;
    String height, weight;
    RelativeLayout mBackground;


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        /*getSupportActionBar().show();
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"><font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#E91E63"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);*/

        intent = getIntent();

        mBmiDisplay = findViewById(R.id.bmidisplay);
        mBmiCat = findViewById(R.id.bmicat);
        mGender = findViewById(R.id.genderdisplay);
        mBackground = findViewById(R.id.relativeLayout);
        //mImageView = findViewById(R.id.Alt);
        mCalculateBmi = findViewById(R.id.reCal);
        animationView = findViewById(R.id.animation_view);

        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");

        intHeight = Float.parseFloat(height);
        intWeight = Float.parseFloat(weight);

        intHeight = intHeight / 100;

        intBmi = intWeight / (intHeight * intHeight);

        mBmi = Float.toString(intBmi);

        if (intBmi > 40) {

            mBmiCat.setText("Severe Thinnes");
            // mImageView.setImageResource(R.drawable.man);


        }
        if (intBmi < 16.9 && intBmi > 16) {
            mBmiCat.setText("Moderate Thinnes");
            //mImageView.setImageResource(R.drawable.man);
        }
        if (intBmi < 18.4 && intBmi > 17) {
            mBmiCat.setText("Mild Thinnes");
            // mImageView.setImageResource(R.drawable.man);
        }
        if (intBmi < 25 && intBmi > 18.4) {
            mBmiCat.setText("Normal");
            //mImageView.setImageResource(R.drawable.man);
        }
        if (intBmi < 29.4 && intBmi > 25) {
            mBmiCat.setText("Over Weight");
            // mImageView.setImageResource(R.drawable.man);
        }
        if (intBmi < 16) {
            mBmiCat.setText("Obese Class");
            //mImageView.setImageResource(R.drawable.man);
        }
        mGender.setText(intent.getStringExtra("gender"));
        mBmiDisplay.setText(mBmi);

        mCalculateBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


}
