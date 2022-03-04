package com.example.filatelistii;

public class Timbre {

    private int id;
    private String name;
    private String price;
    private String an;

    public Timbre(int id, String name, String price, String an) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.an = an;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAn() {
        return an;
    }

    public void setAn(String an) {
        this.an = an;
    }
}
