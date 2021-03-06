package com.example.admin.noahsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper dbh = new DatabaseHelper( this );
    }

    public void goToCategories(View view) {
        Intent intent = new Intent( this, AnimalCategoryListActivity.class );
        startActivity( intent );
    }
}
// MainActivity > Animal Category > Animal List

/*
X 1. Activity one: Make a homepage for zoo information
X 2. Activity two: ListView with list of all the categories.
X 3. Activity three: ListView with a list of all the animals in that category
4. Activity four: Detail of that animal selected from the list. It should have the detail of that
     animal and play a sound of that animal.
X 5. Save the data in a database using SQLite
X 6. Use Cardviews

for images
https://github.com/hiteshbpatel/Android_Blog_Projects/tree/master/Android-SQLite-master/src/com/expr/sample/db
 */