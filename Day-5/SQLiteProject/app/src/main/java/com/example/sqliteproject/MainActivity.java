package com.example.sqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase database = this.openOrCreateDatabase("Theachers",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS teachers" +
                    "(id INTEGER PRIMARY KEY, name VARCHAR, age INT )");


            //database.execSQL("INSERT INTO teachers(name, age) VALUES ('Faik Turan',43)");
            //database.execSQL("INSERT INTO teachers(name, age) VALUES ('Ayşe Gel',35)");
            //database.execSQL("INSERT INTO teachers(name, age) VALUES ('Davut Kaç',28)");

            //database.execSQL("UPDATE teachers SET age = 35 WHERE name = 'Faik Turan'");
            //database.execSQL("UPDATE teachers SET name = 'Zeynep Türk' WHERE id = 3");

            //database.execSQL("DELETE FROM teachers WHERE id =5");

            //Cursor cursor = database.rawQuery("SELECT * FROM teachers WHERE name='Faik Turan'", null);
            Cursor cursor = database.rawQuery("SELECT * FROM teachers WHERE name LIKE 'Z%'", null);

            //Cursor cursor = database.rawQuery("SELECT * FROM teachers", null);

            int nameIx = cursor.getColumnIndex("name");
            int ageIx = cursor.getColumnIndex("age");
            int idIx = cursor.getColumnIndex("id");

            while (cursor.moveToNext()){
                System.out.println("Name: " +cursor.getString(nameIx));
                System.out.println("Age: " +cursor.getString(ageIx));
                System.out.println("Id: " +cursor.getString(idIx));
            }

            cursor.close();

        }catch(Exception e){
            e.printStackTrace();
        }


    }
}