package com.myur.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.accessibilityservice.AccessibilityGestureEvent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;

    String Gender;
    EditText Weight,Age;
    TextView seekBarValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar)findViewById(R.id.seekbar);
        seekBarValue = (TextView)findViewById(R.id.seekbarvalue);
        Weight=findViewById(R.id.weight);
        Age=findViewById(R.id.age);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                seekBarValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });
    }

    public void getGenderMale(View view) {
        Gender="1";
      //  Toast.makeText(MainActivity.this,"Gender : "+Gender, Toast.LENGTH_LONG).show();
    }

    public void getGenderFemale(View view) {
        Gender="0";
      //  Toast.makeText(MainActivity.this,"Gender : "+ Gender,Toast.LENGTH_LONG).show();
    }

    public void CalculateBMI(View view) {



        int age = Integer.valueOf(Age.getText().toString());
        float W=Integer.valueOf(Weight.getText().toString());
        float h=Integer.valueOf(seekBarValue.getText().toString());

    float H=h/100;
    float bmi=(W*W/(H));
    bmi=bmi/100;
        String bmiLabel = "";

        if (Float.compare(bmi, 15f) <= 0 ) {
            bmiLabel = getString(R.string.very_severely_underweight);
        } else if (Float.compare(bmi, 15f) > 0  &&  Float.compare(bmi, 16f) <= 0 ) {
            bmiLabel = getString(R.string.severely_underweight);
        } else if (Float.compare(bmi, 16f) > 0  &&  Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = getString(R.string.underweight);
        } else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 25f) <= 0) {
            bmiLabel = getString(R.string.normal);
        } else if (Float.compare(bmi, 25f) > 0  &&  Float.compare(bmi, 30f) <= 0) {
            bmiLabel = getString(R.string.overweight);
        } else if (Float.compare(bmi, 30f) > 0  &&  Float.compare(bmi, 35f) <= 0) {
            bmiLabel = getString(R.string.obese_class_i);
        } else if (Float.compare(bmi, 35f) > 0  &&  Float.compare(bmi, 40f) <= 0) {
            bmiLabel = getString(R.string.obese_class_ii);
        } else {
            bmiLabel = getString(R.string.obese_class_iii);
        }
        bmiLabel = bmi + ":" + bmiLabel;




        Intent intent=new Intent(this,ResultActivity.class);
        startActivity(intent);

        Intent intent1=new Intent(this,ResultActivity.class);
        intent1.putExtra("G",Gender);
        startActivity(intent1);

        Intent i=new Intent(this,ResultActivity.class);
        i.putExtra("t",bmiLabel);
        startActivity(i);
    Toast.makeText(MainActivity.this,"BMI :"+bmi+bmiLabel,Toast.LENGTH_LONG).show();
        //Toast.makeText(MainActivity.this,"Age : "+age +"  weight : "+W+"  Height :"+H+"  Gender :"+Gender,Toast.LENGTH_SHORT).show();
    }
}
