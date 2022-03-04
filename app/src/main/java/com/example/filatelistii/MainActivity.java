package com.example.filatelistii;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initializare buton
        Button btnMeniu = findViewById(R.id.butonMeniu);
        //adaugare eveniment
        btnMeniu.setOnClickListener(v -> {
            //deschidere activitate Meniu
            Intent intent= new Intent(getApplicationContext(), MainMenu.class);
            startActivity(intent);

        });
    }
}