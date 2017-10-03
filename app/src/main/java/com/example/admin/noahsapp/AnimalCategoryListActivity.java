package com.example.admin.noahsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class AnimalCategoryListActivity extends AppCompatActivity {

    private static final String TAG = "ANIMAL CATEGORY";
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_category);

        listView = findViewById( R.id.lvAnimalCategories );
        DatabaseHelper dbh = new DatabaseHelper( this );
        List<String> categories = dbh.getCategories();
        CategoryListAdapter adapter =
                new CategoryListAdapter( this, R.layout.custom_category_list_item, categories );
        listView.setAdapter( adapter );

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView category = view.findViewById( R.id.tvCategory );
                choose( category.getText().toString() );
                //Log.d(TAG, "onItemClick: " + category.getText().toString());
            }
        });
    }

    public void choose( String category ) {
        Intent intent = new Intent( this, AnimalListActivity.class );
        intent.putExtra( "category", category );
        startActivity( intent );
    }
}

//setOnItemClickListener

/*
2. Activity two: ListView with list of all the categories.
3. Activity three: ListView with a list of all the animals in that category
4. Activity four: Detail of that animal selected from the list. It should have the detail of that
   animal and play a sound of that animal.
5. Save the data in a database using SQLite, Use Cardviews
 */