package com.example.filatelistii;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainMenu extends AppCompatActivity {
    private Button btnAdauga;
    private Button btnAdaugaEveniment, btnAdaugaImagine, btnviewTimbre, btnColectii;
    private FloatingActionButton fabRatingBar, fabNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        ConstraintLayout constraintLayout=findViewById(R.id.mainMenuLayout);
        AnimationDrawable animationDrawable= (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(3000);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        fabRatingBar=findViewById(R.id.fabRating);
        fabNote=findViewById(R.id.fabNotes);
        btnColectii=findViewById(R.id.btnColectii);
        btnAdauga=findViewById(R.id.btnAdaugaTimbru);
        btnviewTimbre=findViewById(R.id.btnViewTimbreFirebase);

        btnAdaugaImagine=findViewById(R.id.btnVizualizeazaImagini);
        btnAdauga.setOnClickListener(v -> {
            Intent intentAdauga=new Intent(getApplicationContext(), AdaugaTimbru.class);
            startActivity(intentAdauga);
        });

        btnAdaugaEveniment=findViewById((R.id.btnAdaugaEveniment));
        btnAdaugaEveniment.setOnClickListener(v -> {
            Intent intentEveniment=new Intent(getApplicationContext(), AdaugaEveniment.class);
            startActivity(intentEveniment);
        });

        fabRatingBar.setOnClickListener(v -> {
            Intent intentFeedbackMenu=new Intent(getApplicationContext(), Rating.class);
            startActivity(intentFeedbackMenu);
        });
        btnAdaugaImagine.setOnClickListener(v -> {
            Intent intentImagine=new Intent(getApplicationContext(), ImageByCameraGallery.class);
            startActivity(intentImagine);
        });
        btnviewTimbre.setOnClickListener(v -> {
            Intent intentTimbreFirebase=new Intent(getApplicationContext(), ArataTimbre.class);
            startActivity(intentTimbreFirebase);
        });
        btnColectii.setOnClickListener(v -> {
            Intent intentColectii=new Intent(getApplicationContext(), ColetiiTimbre.class);
            startActivity(intentColectii);
        });
        fabNote.setOnClickListener(v -> {
            Intent intentNote=new Intent(getApplicationContext(), Notes.class);
            startActivity(intentNote);
        });


    }
}