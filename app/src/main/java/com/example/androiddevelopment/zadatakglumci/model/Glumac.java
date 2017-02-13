package com.example.androiddevelopment.zadatakglumci.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by androiddevelopment on 13.2.17..
 */

public class Glumac {
    private int id;
    private String imePrezime;
    private String biografija;
    private String fotogafija;
    private double ocena;
    private Date datumRodjenja;
    private Date datumSmrti;

    private List<Film> filmovi;



    public Glumac() {
        this.filmovi = new ArrayList<>();
    }

    public Glumac(int id, String imePrezime, String biografija, String fotogafija, double ocena, Date datumRodjenja) {
        this.id = id;
        this.imePrezime = imePrezime;
        this.biografija = biografija;
        this.fotogafija = fotogafija;
        this.ocena = ocena;
        this.datumRodjenja = datumRodjenja;
        this.filmovi = new ArrayList<>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getBiografija() {
        return biografija;
    }

    public void setBiografija(String biografija) {
        this.biografija = biografija;
    }

    public String getFotogafija() {
        return fotogafija;
    }

    public void setFotogafija(String fotogafija) {
        this.fotogafija = fotogafija;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Date getDatumSmrti() {
        return datumSmrti;
    }

    public void setDatumSmrti(Date datumSmrti) {
        this.datumSmrti = datumSmrti;
    }

    public List<Film> getFilmovi() {
        return filmovi;
    }

    public void setFilmovi(List<Film> filmovi) {
        this.filmovi = filmovi;
    }
}
