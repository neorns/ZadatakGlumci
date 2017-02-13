package com.example.androiddevelopment.zadatakglumci.model;

/**
 * Created by androiddevelopment on 13.2.17..
 */

public class Film {
    private int id;
    private String Naziv;
    private Glumac glumac;

    public Film() {
    }

    public Film(int id, String naziv, Glumac glumac) {
        this.id = id;
        Naziv = naziv;
        this.glumac = glumac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String naziv) {
        Naziv = naziv;
    }

    public Glumac getGlumac() {
        return glumac;
    }

    public void setGlumac(Glumac glumac) {
        this.glumac = glumac;
    }
}
