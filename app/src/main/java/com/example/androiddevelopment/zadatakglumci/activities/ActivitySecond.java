package com.example.androiddevelopment.zadatakglumci.activities;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.androiddevelopment.zadatakglumci.R;
import com.example.androiddevelopment.zadatakglumci.model.Film;
import com.example.androiddevelopment.zadatakglumci.model.Glumac;
import com.example.androiddevelopment.zadatakglumci.providers.FilmProvider;
import com.example.androiddevelopment.zadatakglumci.providers.GlumacProvider;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by androiddevelopment on 13.2.17..
 */

public class ActivitySecond extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);


        final int position = getIntent().getIntExtra("position", 0);


        TextView tvImePrezime = (TextView) findViewById(R.id.tv_imeprezime);
        tvImePrezime.setText(GlumacProvider.getGlumacById(position).getImePrezime());

        ImageView ivSlika = (ImageView) findViewById(R.id.iv_slika);
        InputStream is = null;
        try {
            is = getAssets().open(GlumacProvider.getGlumacById(position).getFotogafija());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivSlika.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView tvBiografija = (TextView) findViewById(R.id.tv_biografija);
        tvBiografija.setText(GlumacProvider.getGlumacById(position).getBiografija());

        TextView tvDatumRodjenja = (TextView) findViewById(R.id.tv_datumrodjenja);
        tvDatumRodjenja.setText(GlumacProvider.getGlumacById(position).getDatumRodjenja().toString());

        TextView tvDatumSmrti = (TextView) findViewById(R.id.tv_datumsmrti);

        String datumString;
        if (GlumacProvider.getGlumacById(position).getDatumSmrti()==null) {
            datumString = "";
        }
        else {
            datumString=GlumacProvider.getGlumacById(position).getDatumSmrti().toString();
        }
        tvDatumSmrti.setText(datumString);

        RatingBar rbRating = (RatingBar) findViewById(R.id.rb_ocena);
        rbRating.setRating((float) GlumacProvider.getGlumacById(position).getOcena());



        final List<String> sastojciNazivi = FilmProvider.getFilmoviNazivi(GlumacProvider.getGlumacById(position));
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.list_item, sastojciNazivi);

        ListView listView = (ListView) findViewById(R.id.listaFilmovi);

        listView.setAdapter(dataAdapter);
    }
}
