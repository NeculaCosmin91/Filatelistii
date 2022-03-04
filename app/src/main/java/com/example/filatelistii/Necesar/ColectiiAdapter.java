package com.example.filatelistii.Necesar;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.filatelistii.R;

import java.util.List;




public class ColectiiAdapter extends ArrayAdapter<Colectii> {

    private Context context;
    private int resource;
    private List<Colectii> listaColectii;
    private LayoutInflater inflater;


    public ColectiiAdapter(@NonNull Context context, int resource, @NonNull List<Colectii> listaColectii,
                          LayoutInflater inflater) {
        super(context, resource, listaColectii);
        this.context = context;
        this.inflater = inflater;
        this.listaColectii = listaColectii;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(resource, parent, false);
        Colectii colectii = listaColectii.get(position);
        if (colectii == null) {
            return view;
        }
        adaugaCategorieColectie(view, colectii.getCategorieColectie());
        adaugaNumeColectie(view, colectii.getNumeColectie());
        adaugaAnColectie(view, colectii.getAnColectie());
        adaugaTaraColectie(view, colectii.getNumeTara());

        return view;
   }

    private void adaugaCategorieColectie(View view, String categorieColectie) {
        TextView textView = view.findViewById(R.id.categorieColectii);
        populareContinutTextView(textView, categorieColectie);
    }

    private void adaugaNumeColectie(View view, String numeColectie) {
        TextView textView = view.findViewById(R.id.numeColectii);
        populareContinutTextView(textView, numeColectie);
    }

    private void adaugaAnColectie(View view, int an) {
        TextView textView = view.findViewById(R.id.anColectii);
        populareContinutTextView(textView,String.valueOf(an));
    }

    private void adaugaTaraColectie(View view, String tara) {
        TextView textView = view.findViewById(R.id.taraColectii);
        populareContinutTextView(textView, tara);
    }

    private void populareContinutTextView(TextView textView, String valoare) {
        if (valoare != null && !valoare.trim().isEmpty()) {
            textView.setText(valoare);
        } else {
            textView.setText(R.string.valoare_default_row_view);
        }
        
    }
}
