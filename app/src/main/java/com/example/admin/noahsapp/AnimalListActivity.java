package com.example.admin.noahsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class AnimalListActivity extends AppCompatActivity {

    private static final String TAG = "ANIMAL LIST";
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_list);

        listView = findViewById( R.id.lvAnimalList );

        Intent intent = getIntent();
        String category = intent.getStringExtra("category");

        DatabaseHelper dbh = new DatabaseHelper( this );
        List<Animal> animals = dbh.getAnimalByCategory( category );
        AnimalListAdapter adapter =
                new AnimalListAdapter( this, R.layout.custom_animal_list_item, animals );
        listView.setAdapter( adapter );

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Log.d(TAG, "onItemClick: " + category.getText().toString());
            }
        });
    }
}
