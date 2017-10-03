package com.example.admin.noahsapp;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Admin on 10/3/2017.
 */

public class AnimalListAdapter extends ArrayAdapter<Animal> {

    public AnimalListAdapter(@NonNull Context context, @LayoutRes int resource, List<Animal> animalList) {
        super(context, resource, animalList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        //inflate the view with custom layout xml
        if( view == null )
            view = LayoutInflater.from( parent.getContext()).inflate( R.layout.custom_animal_list_item, null );

        //bind views

        TextView commonCameTextView = view.findViewById( R.id.tvAnimalCommonName ); //not extending AppCompatActivity
        TextView scientificNameTextView = view.findViewById( R.id.tvAnimalScientificName );
        TextView categoryTextView = view.findViewById( R.id.tvAnimalCategory );
        TextView concernTextiew = view.findViewById( R.id.tvAnimalConcern );

        //set values to the binded views
        Animal animal = getItem( position );
        commonCameTextView.setText( animal.getCommonName() );
        scientificNameTextView.setText( animal.getScientificName() );
        categoryTextView.setText( animal.getCategory() );
        concernTextiew.setText( animal.getConservationStatus() );

        return view;
    }
}
