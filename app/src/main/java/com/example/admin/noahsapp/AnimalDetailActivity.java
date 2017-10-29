package com.example.admin.noahsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalDetailActivity extends AppCompatActivity {

    private static final String TAG = "AnimalDetail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);

        ImageView image = findViewById( R.id.ivImage );
        TextView commonName = findViewById( R.id.tvDetailName );
        TextView category = findViewById( R.id.tvDetailCategory );
        TextView sci = findViewById( R.id.tvDetailScientificName );
        TextView status = findViewById( R.id.tvDetailConservationStatus );

        Intent intent = getIntent();
        String s = intent.getStringExtra("animal");
        DatabaseHelper dbh = new DatabaseHelper( this );
        Animal animal = dbh.getAnimal( s );

        image.setImageBitmap( animal.getImage() );
        commonName.setText( animal.getCommonName() );
        category.setText( animal.getCategory() );
        sci.setText( animal.getScientificName() );
        status.setText( animal.getConservationStatus() );
    }
}
