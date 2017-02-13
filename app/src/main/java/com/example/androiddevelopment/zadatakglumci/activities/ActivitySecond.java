package com.example.androiddevelopment.zadatakglumci.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androiddevelopment.zadatakglumci.R;
import com.example.androiddevelopment.zadatakglumci.model.Film;
import com.example.androiddevelopment.zadatakglumci.model.Glumac;
import com.example.androiddevelopment.zadatakglumci.providers.FilmProvider;
import com.example.androiddevelopment.zadatakglumci.providers.GlumacProvider;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static com.example.androiddevelopment.zadatakglumci.R.id.toolbar;



/**
 * Created by androiddevelopment on 13.2.17..
 */

public class ActivitySecond extends AppCompatActivity {
    //drawerLayout
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private CharSequence drawerTitle;
    private ActionBarDrawerToggle drawerToggle;
    //private ArrayList<NavigationItem> drawerItems = new ArrayList<NavigationItem>();
    private String[] drawerTitles;
    /* The click listner for ListView in the navigation drawer */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItemFromDrawer(position);
        }
    }
    private void selectItemFromDrawer(int position) {
        if (position == 0) {

        }
        else if (position == 1) {
            Intent settings = new Intent(ActivitySecond.this,ActivityFirst.class);
            startActivity(settings);
        }

        drawerList.setItemChecked(position, true);
        setTitle(drawerTitles[position]);
        drawerLayout.closeDrawer(drawerList);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);


        final int position = getIntent().getIntExtra("position", 0);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_drawer);
            actionBar.setHomeButtonEnabled(true);
            actionBar.show();
        }
        drawerTitles = getResources().getStringArray(R.array.navDrawerTitles);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.navList);
        // Set the adapter for the list view
        drawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_item, drawerTitles));
        // Set the list's click listener
        drawerList.setOnItemClickListener(new DrawerItemClickListener());
        drawerTitle = getTitle();
        drawerToggle = new ActionBarDrawerToggle(
                this,                           /* host Activity */
                drawerLayout,                   /* DrawerLayout object */
                toolbar,                        /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,           /* "open drawer" description for accessibility */
                R.string.drawer_close           /* "close drawer" description for accessibility */

        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(drawerTitle);
                invalidateOptionsMenu();        // Creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(drawerTitle);
                invalidateOptionsMenu();        // Creates call to onPrepareOptionsMenu()
            }
        };

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

    // onOptionsIActivitytemSelected method is called whenever an item in the Toolbar is selected.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create:
                //Toast.makeText(this, "Action " + getString(R.string.fragment_master_action_create) + " executed.", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Action Dodaj executed.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_update:
                //Toast.makeText(this, "Action " + getString(R.string.fragment_detal_action_update) + " executed.", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Action Izmeni executed.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_delete:
                //Toast.makeText(this, "Action " + getString(R.string.fragment_detal_action_delete) + " executed.", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Action Brisi executed.", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    // onCreateOptionsMenu method initialize the contents of the Activity's Toolbar.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
