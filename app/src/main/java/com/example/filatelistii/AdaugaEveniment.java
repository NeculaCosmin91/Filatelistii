package com.example.filatelistii;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class AdaugaEveniment extends AppCompatActivity {

    private EditText name, adresa;
    private Button btnEveniment, btnDisplay;
    private DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_eveniment);



        name = findViewById(R.id.eventName);
        adresa = findViewById(R.id.adresa);
        btnEveniment = findViewById(R.id.btnSaveEveniment);
        btnDisplay=findViewById(R.id.ShowEvents);
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdaugaEveniment.this, DisplayEvenimente.class);
                startActivity(i);
            }
        });


        dbHelper = new DbHelper(AdaugaEveniment.this);


        btnEveniment.setOnClickListener(v -> {


            String Eventname = name.getText().toString();
            String Eventadress = adresa.getText().toString();



            if (Eventname.isEmpty() && Eventadress.isEmpty() ) {
                Toast.makeText(AdaugaEveniment.this, "Completati toate datele..", Toast.LENGTH_SHORT).show();
                return;
            }


            dbHelper.addNewEvent(Eventname, Eventadress);


            Toast.makeText(AdaugaEveniment.this, "Evenimentul a fost adaugat.", Toast.LENGTH_SHORT).show();
            name.setText("");
            adresa.setText("");

        });
    }
}