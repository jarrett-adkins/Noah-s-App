package com.example.admin.noahsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

//auto increment
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DBHelper";
    private static final int DATABASE_VERSION = 8;

    public static final String DATABASE_NAME = "Animals.db";
    public static final String TABLE_NAME = "Animals";
    public static final String COLUMN_CATEGORY = "Category";
    public static final String COLUMN_COMMON_NAME = "CommonName";
    public static final String COLUMN_SCIENTIFIC_NAME = "ScientificName";
    public static final String COLUMN_CONSERVATION_STATUS = "ConservationStatus";
    public static final String COLUMN_IMAGE = "image";
    private static final String COLUMN_MP3 = "Mp3";

    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        Log.d(TAG, "constructor: ");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Called when the database is created for the first time

        //*
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "( Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CATEGORY + " TEXT, " + COLUMN_COMMON_NAME + " TEXT, " + COLUMN_SCIENTIFIC_NAME
                + " TEXT, " + COLUMN_CONSERVATION_STATUS + " TEXT, " + COLUMN_IMAGE + " BLOB" +
                ")";

        sqLiteDatabase.execSQL( CREATE_TABLE );

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.lion);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        byte[] data = outputStream.toByteArray();

        ContentValues contentValues = new ContentValues();
        contentValues.put( COLUMN_CATEGORY, "mammal" );
        contentValues.put( COLUMN_COMMON_NAME, "Lion" );
        contentValues.put( COLUMN_SCIENTIFIC_NAME, "Panthera leo" );
        contentValues.put( COLUMN_CONSERVATION_STATUS, "Vulnerable" );
        contentValues.put( COLUMN_IMAGE, data );
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

//        anteater
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.anteater);
        outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        data = outputStream.toByteArray();

        contentValues = new ContentValues();
        contentValues.put( COLUMN_CATEGORY, "mammal" );
        contentValues.put( COLUMN_COMMON_NAME, "Giant Anteater" );
        contentValues.put( COLUMN_SCIENTIFIC_NAME, "Myrmecophaga tridactyla" );
        contentValues.put( COLUMN_CONSERVATION_STATUS, "Vulnerable" );
        contentValues.put( COLUMN_IMAGE, data );
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

//        gorilla
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.gorilla);
        outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        data = outputStream.toByteArray();

        contentValues = new ContentValues();
        contentValues.put( COLUMN_CATEGORY, "mammal" );
        contentValues.put( COLUMN_COMMON_NAME, "Western Gorilla" );
        contentValues.put( COLUMN_SCIENTIFIC_NAME, "Gorilla gorilla" );
        contentValues.put( COLUMN_CONSERVATION_STATUS, "Vulnerable" );
        contentValues.put( COLUMN_IMAGE, data );
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

//        tortoise
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.tortoise);
        outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        data = outputStream.toByteArray();

        contentValues = new ContentValues();
        contentValues.put( COLUMN_CATEGORY, "reptile" );
        contentValues.put( COLUMN_COMMON_NAME, "Desert tortoise" );
        contentValues.put( COLUMN_SCIENTIFIC_NAME, "Gopherus morafkai" );
        contentValues.put( COLUMN_CONSERVATION_STATUS, "Vulnerable" );
        contentValues.put( COLUMN_IMAGE, data );
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

//        False gharia
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.gharial);
        outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        data = outputStream.toByteArray();

        contentValues = new ContentValues();
        contentValues.put( COLUMN_CATEGORY, "reptile" );
        contentValues.put( COLUMN_COMMON_NAME, "False gharial" );
        contentValues.put( COLUMN_SCIENTIFIC_NAME, "Tomistoma schlegelii" );
        contentValues.put( COLUMN_CONSERVATION_STATUS, "Vulnerable" );
        contentValues.put( COLUMN_IMAGE, data );
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

//        Triceratops
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.triceatops);
        outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        data = outputStream.toByteArray();

        contentValues = new ContentValues();
        contentValues.put( COLUMN_CATEGORY, "reptile" );
        contentValues.put( COLUMN_COMMON_NAME, "Triceratops" );
        contentValues.put( COLUMN_SCIENTIFIC_NAME, "Triceratops horridus" );
        contentValues.put( COLUMN_CONSERVATION_STATUS, "Extinct" );
        contentValues.put( COLUMN_IMAGE, data );
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

//        penguin
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.penguine);
        outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        data = outputStream.toByteArray();

        contentValues = new ContentValues();
        contentValues.put( COLUMN_CATEGORY, "bird" );
        contentValues.put( COLUMN_COMMON_NAME, "Gentoo penguin" );
        contentValues.put( COLUMN_SCIENTIFIC_NAME, "Pygoscelis papua" );
        contentValues.put( COLUMN_CONSERVATION_STATUS, "Least Concern" );
        contentValues.put( COLUMN_IMAGE, data );
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

//        albatross
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.albatross);
        outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        data = outputStream.toByteArray();

        contentValues = new ContentValues();
        contentValues.put( COLUMN_CATEGORY, "bird" );
        contentValues.put( COLUMN_COMMON_NAME, "Shy albatross" );
        contentValues.put( COLUMN_SCIENTIFIC_NAME, "Thalassarche cauta" );
        contentValues.put( COLUMN_CONSERVATION_STATUS, "Least Concern" );
        contentValues.put( COLUMN_IMAGE, data );
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

//        parakeet
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.parkeet);
        outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        data = outputStream.toByteArray();

        contentValues = new ContentValues();
        contentValues.put( COLUMN_CATEGORY, "bird" );
        contentValues.put( COLUMN_COMMON_NAME, "Red-masked parakeet" );
        contentValues.put( COLUMN_SCIENTIFIC_NAME, "Psittacara erythrogenys" );
        contentValues.put( COLUMN_CONSERVATION_STATUS, "Near Threatened" );
        contentValues.put( COLUMN_IMAGE, data );
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

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

    public List<Animal> getAnimalByCategory( String category ) {
        List<Animal> animalList = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE CATEGORY=?";
        Cursor cursor = db.rawQuery( query, new String[] {category} );
        Log.d(TAG, "getAnimalByCategory: " + cursor.getCount());

        //loop through cursor, create person objects, add to list
        if( cursor.moveToFirst() ) {
            do {
                try {
                    Animal a = new Animal(
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getString(4));

                    animalList.add(a);
                    Log.d(TAG, "getAnimalByCategory: Added animal " + a.getCommonName());
                } catch ( java.lang.IllegalStateException e ) {
                    Log.e(TAG, "getAnimalByCategory: ", e);
                }
            } while ( cursor.moveToNext() );
        }

        return animalList;
    }

    public Animal getAnimal( String name ){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_COMMON_NAME + "=?";
        Cursor cursor = db.rawQuery( query, new String[] {name} );

        Animal a = null;

        if( cursor.moveToFirst() ) {

            byte[] imgByte = cursor.getBlob( 5 );
            Bitmap bitmap = BitmapFactory.decodeByteArray(imgByte, 0, imgByte.length);

            a = new Animal(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    bitmap);
        }

        return a;
    }
}
