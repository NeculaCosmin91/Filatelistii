package com.example.filatelistii.Necesar;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Colectii implements Serializable {
    private String categorieColectie;
    private String numeColectie;
    private int anColectie;
    private String numeTara;


    public Colectii(String categorieColectie, String numeColectie, int anColectie, String numeTara) {
        this.categorieColectie = categorieColectie;
        this.numeColectie = numeColectie;
        this.anColectie = anColectie;
        this.numeTara = numeTara;

    }

    public String getCategorieColectie() {
        return categorieColectie;
    }

    public void setCategorieColectie(String categorieColectie) {
        this.categorieColectie = categorieColectie;
    }

    public String getNumeColectie() {
        return numeColectie;
    }

    public void setNumeColectie(String numeColectie) {
        this.numeColectie = numeColectie;
    }

    public int getAnColectie() {
        return anColectie;
    }

    public void setAnColectie(int anColectie) {
        this.anColectie = anColectie;
    }

    public String getNumeTara() {
        return numeTara;
    }

    public void setNumeTara(String numeTara) {
        this.numeTara = numeTara;
    }


    @NonNull
    @Override
    public String toString() {
        return "Colectie{" +
                "categorie='" + categorieColectie + '\'' +
                ", nume=" + numeColectie +
                ", an=" + anColectie +
                ", tara='" + numeTara + '\'' +
                '}';
    }
}
