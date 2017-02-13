package com.example.androiddevelopment.zadatakglumci.providers;

import com.example.androiddevelopment.zadatakglumci.model.Film;
import com.example.androiddevelopment.zadatakglumci.model.Glumac;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by androiddevelopment on 13.2.17..
 */

public class FilmProvider {
    public static List<String> getFilmoviNazivi(Glumac glumac) {

        List<String> nazivi = new ArrayList<>();
        for (Film film:glumac.getFilmovi()
                ) { nazivi.add(film.getNaziv());

        }

        return nazivi;
    }
}
