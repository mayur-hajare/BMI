package com.myur.bmi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    android.widget.Button mcalculatebmi;
    SeekBar mSeekBarForHeight;
    RelativeLayout mMale, mFemale;
    TextView mCurrentHeight, mCurrentWeight, mCurrentAge;
    ImageView mCurrentDecAge, mCurrentIncAge, mCurrentDecWeight, mCurrentIncWeight;
    int intWeight = 55, intAge = 22, currentProgress;
    String mintProgress = "170", typeofUser = "0", weight2 = "55", age2 = "22";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mcalculatebmi = findViewById(R.id.caculatebmi);
        mCurrentAge = findViewById(R.id.age);
        mCurrentHeight = findViewById(R.id.currentheight);
        mCurrentWeight = findViewById(R.id.weight);
        mCurrentIncAge = findViewById(R.id.addage);
        mCurrentDecAge = findViewById(R.id.subage);
        mCurrentIncWeight = findViewById(R.id.addweight);
        mCurrentDecWeight = findViewById(R.id.subweight);
        mSeekBarForHeight = findViewById(R.id.seekbar);
        mMale = findViewById(R.id.male);
        mFemale = findViewById(R.id.female);

        mMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.focusegenderbackground));
                mFemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.genderbackground));
                typeofUser = "Male";
            }
        });

        mFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.focusegenderbackground));
                mMale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.genderbackground));
                typeofUser = "Female";
            }
        });

        mSeekBarForHeight.setMax(300);
        mSeekBarForHeight.setProgress(170);
        mSeekBarForHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                currentProgress = progress;
                mintProgress = String.valueOf(currentProgress);
                mCurrentHeight.setText(mintProgress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mCurrentIncAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intAge = intAge + 1;
                age2 = String.valueOf(intAge);
                mCurrentAge.setText(age2);

            }
        });
        mCurrentIncWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intWeight = intWeight + 1;
                weight2 = String.valueOf(intWeight);
                mCurrentWeight.setText(weight2);

            }
        });
        mCurrentDecAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intAge = intAge - 1;
                age2 = String.valueOf(intAge);
                mCurrentAge.setText(age2);

            }
        });
        mCurrentDecWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intWeight = intWeight - 1;
                weight2 = String.valueOf(intWeight);
                mCurrentWeight.setText(weight2);

            }
        });

        mcalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (typeofUser.equals("0")) {
                    Toast.makeText(getApplicationContext(), "Select Your Gender First", Toast.LENGTH_SHORT).show();
                } else if (mintProgress.equals("0")) {
                    Toast.makeText(getApplicationContext(), "Select Your Height First", Toast.LENGTH_SHORT).show();
                } else if (intAge == 0 || intAge < 0) {
                    Toast.makeText(getApplicationContext(), "Age Is Incorrect", Toast.LENGTH_SHORT).show();
                } else if (intWeight == 0 || intWeight < 0) {
                    Toast.makeText(getApplicationContext(), "Weight Is Incorrect", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);

                    intent.putExtra("gender", typeofUser);
                    intent.putExtra("height", mintProgress);
                    intent.putExtra("weight", weight2);
                    intent.putExtra("age", age2);

                    startActivity(intent);


                }

            }
        });
    }
}
