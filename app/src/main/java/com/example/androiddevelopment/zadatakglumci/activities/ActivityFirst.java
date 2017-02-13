package com.example.androiddevelopment.zadatakglumci.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.androiddevelopment.zadatakglumci.R;
import com.example.androiddevelopment.zadatakglumci.providers.GlumacProvider;

import java.util.List;

/**
 * Created by androiddevelopment on 13.2.17..
 */

public class ActivityFirst extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_first);

		final List<String> glumciImena = GlumacProvider.getGlumciImena();
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.list_item, glumciImena);
		ListView listView = (ListView) findViewById(R.id.listaGlumci);

		listView.setAdapter(dataAdapter);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(ActivityFirst.this, ActivitySecond.class);
				intent.putExtra("position", position);
				startActivity(intent);
			}
		});

    }
}
