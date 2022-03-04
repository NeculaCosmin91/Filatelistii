package com.example.filatelistii;

public class EventModalClass {
    private String name;
    private String adresa;
    private int id;

    public EventModalClass(String name, String adresa) {
        this.name = name;
        this.adresa = adresa;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
