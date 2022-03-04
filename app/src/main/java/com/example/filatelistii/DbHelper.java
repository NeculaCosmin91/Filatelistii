package com.example.filatelistii;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Evenimente";


    private static final int DB_VERSION = 1;


    private static final String TABLE_NAME = "Eveniment";


    private static final String ID_COL = "id";


    private static final String NAME_COL = "name";


    private static final String ADRESA_COL = "adresa";


    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + ADRESA_COL + " TEXT)";

        db.execSQL(query);
    }


    public void addNewEvent(String name, String adresa) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NAME_COL, name);
        values.put(ADRESA_COL, adresa);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }
    public ArrayList<EventModalClass> readCourses() {

        SQLiteDatabase db = this.getReadableDatabase();


        Cursor event = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);


        ArrayList<EventModalClass> eventModalArrayList = new ArrayList<>();


        if (event.moveToFirst()) {
            do {

                eventModalArrayList.add(new EventModalClass(event.getString(1),
                        event.getString(2)
 ));
            } while (event.moveToNext());

        }

        event.close();
        return eventModalArrayList;
    }
    public void updateCourse(String originalEventName, String name, String adresa) {


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(NAME_COL, name);
        values.put(ADRESA_COL, adresa);



        db.update(TABLE_NAME, values, "name=?", new String[]{originalEventName});
        db.close();
    }
    public void deleteCourse(String courseName) {


        SQLiteDatabase db = this.getWritableDatabase();


        db.delete(TABLE_NAME, "name=?", new String[]{courseName});
        db.close();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}