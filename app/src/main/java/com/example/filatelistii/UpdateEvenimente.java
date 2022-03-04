package com.example.filatelistii;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateEvenimente extends AppCompatActivity {

    private EditText eventNameEdt, adressEdt;
    private Button updateEventBtn, deleteCoursebtn;
    private DbHelper dbHelper;
    String name, adresa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_evenimente);

        eventNameEdt = findViewById(R.id.idEdtEventName);
        adressEdt = findViewById(R.id.idEdtEventAdress);
        updateEventBtn = findViewById(R.id.idBtnUpdateEvent);
        deleteCoursebtn=findViewById(R.id.idBtnDeleteEvent);


        dbHelper = new DbHelper(UpdateEvenimente.this);


        name = getIntent().getStringExtra("name");
        adresa = getIntent().getStringExtra("adresa");



        eventNameEdt.setText(name);
        adressEdt.setText(adresa);



        updateEventBtn.setOnClickListener(v -> {


            dbHelper.updateCourse(name, eventNameEdt.getText().toString(), adressEdt.getText().toString());


            Toast.makeText(UpdateEvenimente.this, "Eveniment Actualizat..", Toast.LENGTH_SHORT).show();


            Intent i = new Intent(UpdateEvenimente.this, AdaugaEveniment.class);
            startActivity(i);
        });
        deleteCoursebtn.setOnClickListener(v -> {

            dbHelper.deleteCourse(name);
            Toast.makeText(UpdateEvenimente.this, "Eveniment sters", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(UpdateEvenimente.this, AdaugaEveniment.class);
            startActivity(i);
        });
    }
}