package com.example.filatelistii;


import android.os.Bundle;
import android.os.Handler;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.filatelistii.Necesar.Colectii;
import com.example.filatelistii.Necesar.ColectiiAdapter;
import com.example.filatelistii.Necesar.ColectiiJsonParser;
import com.example.filatelistii.Necesar.httpManager;

import java.util.ArrayList;
import java.util.List;

public class ColetiiTimbre extends AppCompatActivity {

    private ListView lvColectii;
    private final List<Colectii> listaColectii = new ArrayList<>();
    private final static String URL_COLECTII = "https://jsonkeeper.com/b/FDE2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coletii_timbre);
        initializareComponente();
        listaColectii.add(new Colectii("Colectii 2020","Flori de primavara",2020,
                "Romania"));
        listaColectii.add(new Colectii("Colectii 2020","Io",2020,
                "Romania"));
        incarcareStudentiHttp();

    }

    private void incarcareStudentiHttp() {
        Thread thread = new Thread(){
            @Override
            public void run() {
                httpManager manager=new httpManager(URL_COLECTII);
                String rezultat= manager.process();
                new Handler(getMainLooper()).post(() -> getStudentiFromHttpCallBack(rezultat));
            }
        };
        thread.start();
    }

    private void getStudentiFromHttpCallBack(String rezultat) {
        Toast.makeText(getApplicationContext(),rezultat,Toast.LENGTH_SHORT).show();
        listaColectii.addAll(ColectiiJsonParser.fromJson(rezultat));
        notificareAdapter();
    }

    private void notificareAdapter() {
        ColectiiAdapter adapter= (ColectiiAdapter) lvColectii.getAdapter();
        adapter.notifyDataSetChanged();
    }

    private void initializareComponente() {
        lvColectii = findViewById(R.id.main_lv_colectii);
        adaugareStudentAdapter();
    }

    private void adaugareStudentAdapter() {
        ColectiiAdapter adapter= new ColectiiAdapter(getApplicationContext(),R.layout.lv_inreg_views,
                listaColectii,getLayoutInflater());
        lvColectii.setAdapter(adapter);
    }
}