package com.example.admin.noahsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 10/2/2017.
 */

//auto increment
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DBHelper";
    private static final int DATABASE_VERSION = 3;

    public static final String DATABASE_NAME = "Animals.db";
    public static final String TABLE_NAME = "Animals";
    public static final String COLUMN_CATEGORY = "Category";
    public static final String COLUMN_COMMON_NAME = "CommonName";
    public static final String COLUMN_SCIENTIFIC_NAME = "ScientificName";
    public static final String COLUMN_CONSERVATION_STATUS = "ConservationStatus";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        Log.d(TAG, "constructor: ");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Called when the database is created for the first time

        //*
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "( Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CATEGORY + " TEXT, " + COLUMN_COMMON_NAME + " TEXT, " + COLUMN_SCIENTIFIC_NAME
                + " TEXT, " + COLUMN_CONSERVATION_STATUS + " TEXT)";

        String ADD_LION = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_CATEGORY + ", " + COLUMN_COMMON_NAME
                + ", " + COLUMN_SCIENTIFIC_NAME + ", " + COLUMN_CONSERVATION_STATUS + ") " +
                "VALUES ('mammal', 'Lion', 'Panthera leo', 'Vulnerable')";

        String ADD_ANTEATER = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_CATEGORY + ", " + COLUMN_COMMON_NAME
                + ", " + COLUMN_SCIENTIFIC_NAME + ", " + COLUMN_CONSERVATION_STATUS + ") " +
                "VALUES ('mammal', 'Giant Anteater', 'Myrmecophaga tridactyla', 'Vulnerable')";

        String ADD_GORILLA = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_CATEGORY + ", " + COLUMN_COMMON_NAME
                + ", " + COLUMN_SCIENTIFIC_NAME + ", " + COLUMN_CONSERVATION_STATUS + ") " +
                "VALUES ('mammal', 'Western Gorilla', 'Gorilla gorilla', 'Vulnerable')";

        String ADD_TORTOISE = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_CATEGORY + ", " + COLUMN_COMMON_NAME
                + ", " + COLUMN_SCIENTIFIC_NAME + ", " + COLUMN_CONSERVATION_STATUS + ") " +
                "VALUES ('reptile', 'Desert tortoise', 'Gopherus morafkai', 'Vulnerable')";

        String ADD_CROC = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_CATEGORY + ", " + COLUMN_COMMON_NAME
                + ", " + COLUMN_SCIENTIFIC_NAME + ", " + COLUMN_CONSERVATION_STATUS + ") " +
                "VALUES ('reptile', 'False gharial', 'Tomistoma schlegelii' , 'Vulnerable')";

        sqLiteDatabase.execSQL( CREATE_TABLE );
        sqLiteDatabase.execSQL( ADD_LION );
        sqLiteDatabase.execSQL( ADD_ANTEATER );
        sqLiteDatabase.execSQL( ADD_GORILLA );
        sqLiteDatabase.execSQL( ADD_TORTOISE );
        sqLiteDatabase.execSQL( ADD_CROC );
                //*/

        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //called when version number is changed. Like if you edit the class to have a diff schema,
        //change version num to 2.

        sqLiteDatabase.execSQL( "DROP TABLE IF EXISTS " + TABLE_NAME );
        onCreate( sqLiteDatabase );
    }

    public long addAnimal( Animal a ) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues ct = new ContentValues();
        ct.put( COLUMN_CATEGORY, a.getCategory() );
        ct.put( COLUMN_COMMON_NAME, a.getCommonName() );
        ct.put( COLUMN_SCIENTIFIC_NAME, a.getScientificName() );
        ct.put( COLUMN_CONSERVATION_STATUS, a.getConservationStatus() );

        return database.insert( TABLE_NAME, null, ct );
    }

    public List<String> getCategories() {
        List<String> values = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT DISTINCT " + COLUMN_CATEGORY + " FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery( query, null );

        if( cursor.moveToFirst() ) {
            do
                values.add( cursor.getString(0) );
            while ( cursor.moveToNext() );
        }

        return values;
    }

    public List<Animal> getAnimalbyCategory( String category ) {
        List<Animal> animalList = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE CATEGORY=?";
        Cursor cursor = db.rawQuery( query, new String[] {category} );

        //loop through cursor, create person objects, add to list
        if( cursor.moveToFirst() ) {
            do {
                Animal a = new Animal(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3));

                animalList.add( a );
            } while ( cursor.moveToNext() );
        }

        return animalList;
    }
}
