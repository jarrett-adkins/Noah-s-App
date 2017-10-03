package com.example.admin.noahsapp;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Admin on 10/3/2017.
 */

public class CategoryListAdapter extends ArrayAdapter<String> {

    public CategoryListAdapter(@NonNull Context context, @LayoutRes int resource, List<String> categoryList) {
        super(context, resource, categoryList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        //inflate the view with custom layout xml
        if( view == null )
            view = LayoutInflater.from( parent.getContext()).inflate( R.layout.custom_category_list_item, null );

        //bind views

        //*
        TextView category = view.findViewById( R.id.tvCategory );

        //set values to the binded views
        String cat = getItem( position );
        category.setText( cat );
        //*/

        /*
        Button category = view.findViewById( R.id.btnCategoryButton );
        String cat = getItem( position );
        category.setText( cat );
        */

        return view;
    }


}