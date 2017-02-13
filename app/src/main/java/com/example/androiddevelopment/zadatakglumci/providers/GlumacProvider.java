package com.example.androiddevelopment.zadatakglumci.providers;

import android.text.format.DateUtils;

import com.example.androiddevelopment.zadatakglumci.model.Film;
import com.example.androiddevelopment.zadatakglumci.model.Glumac;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by androiddevelopment on 13.2.17..
 */

public class GlumacProvider {
    public static List<String> getGlumciImena() {

        List<String> imena = new ArrayList<>();
        imena.add("Glumac 1");
        imena.add("Glumac 2");
        return imena;
    }

    public static Glumac getGlumacById(int id){
        Glumac rezultat;
        switch (id) {
            case 0: {
                //int id, String imePrezime, String biografija, String fotogafija, double ocena, Date datumRodjenja
                rezultat = new Glumac(0, "Ime i prezime 1", "Biografija glumca 1", "slika1.jpg", 3, new Date());
                rezultat.getFilmovi().add(new Film(0,"Film 1",rezultat));
                rezultat.getFilmovi().add(new Film(1,"Film 2",rezultat));
                break;
            }
            case 1:
                rezultat = new Glumac(1,"Ime i prezime 2","Biografija glumca 2","slika2.jpg",4, new Date());
                rezultat.getFilmovi().add(new Film(2,"Film 3",rezultat));
                rezultat.getFilmovi().add(new Film(3,"Film 4",rezultat));
                rezultat.getFilmovi().add(new Film(4,"Film 5",rezultat));
                break;
            default:
                rezultat = null;
        }
        return rezultat;
    }
}
