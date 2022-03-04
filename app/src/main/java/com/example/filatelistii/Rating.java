package com.example.filatelistii;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Rating extends AppCompatActivity {
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        ConstraintLayout constraintLayout=findViewById(R.id.mainMenuLayout2);
        AnimationDrawable animationDrawable= (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(3000);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        ratingBar=findViewById(R.id.ratingBar);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);


        LayerDrawable stars=(LayerDrawable)ratingBar.getProgressDrawable();


        stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
    }

    public void Call(View v)
    {

        TextView t = (TextView)findViewById(R.id.textView2);
        t.setText("Nota dumneavoastra :"+String.valueOf(ratingBar.getRating()));
    }

}