package com.myur.bmi;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    View v;
    ImageView imageView;
    TextView textViewBmi ,text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewBmi=findViewById(R.id.Bmi);
        text=findViewById(R.id.BmiLevel);
        String Gender=getIntent().getExtras().getString("G");
        String Bmilevel=getIntent().getExtras().getString("t");
        // textViewBmi.setText(Bmilevel);
        v=findViewById(R.id.relativeLayout);
        imageView=findViewById(R.id.Alt);


        if(Gender=="1"){
            imageView.setImageResource(R.drawable.man);

        }
        if (Gender=="0"){
            imageView.setImageResource(R.drawable.woman);
        }






        String[] separated = Bmilevel.split(":");
        String t1=separated[0]; // this will contain "Bmi"
        String t2=separated[1]; // this will contain " Bmi Level"

        textViewBmi.setText(t1);
       // int bmi=Integer.parseInt(separated[0]);
        text.setText(t2);




    }
}