package com.example.listviewcrud;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.listviewcrud.mDataBase.DBAdapter;
import com.example.listviewcrud.mDataObject.Spacecraft;
import com.example.listviewcrud.mListView.CustomAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    EditText nameEditText;
    Button saveBtn,retrieveBtn;
    ArrayList<Spacecraft> spacecrafts=new ArrayList<>();
    CustomAdapter adapter;
    final Boolean forUpdate=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lv= (ListView) findViewById(R.id.lv);
        adapter=new CustomAdapter(this,spacecrafts);

        //this.getSpacecrafts();
        // lv.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayDialog(false);
            }
        });
    }

    private void displayDialog(Boolean forUpdate)
    {
        Dialog d=new Dialog(this);
        d.setTitle("SQLITE DATA");
        d.setContentView(R.layout.dialog_layout);

        nameEditText= (EditText) d.findViewById(R.id.nameEditText);
        saveBtn= (Button) d.findViewById(R.id.saveBtn);
        retrieveBtn= (Button) d.findViewById(R.id.retrieveBtn);

        if(!forUpdate)
        {
            saveBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    save(nameEditText.getText().toString());
                }
            });
            retrieveBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getSpacecrafts();
                }
            });
        }else {

            //SET SELECTED TEXT
            nameEditText.setText(adapter.getSelectedItemName());

            saveBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    update(nameEditText.getText().toString());
                }
            });
            retrieveBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getSpacecrafts();
                }
            });
        }

        d.show();

    }

    //SAVE
    private void save(String name)
    {
        DBAdapter db=new DBAdapter(this);
        db.openDB();
        boolean saved=db.add(name);

        if(saved)
        {
            nameEditText.setText("");
            getSpacecrafts();
        }else {
            Toast.makeText(this,"Unable To Save",Toast.LENGTH_SHORT).show();
        }
    }

    //RETRIEVE OR GETSPACECRAFTS
    private void getSpacecrafts()
    {
        spacecrafts.clear();
        DBAdapter db=new DBAdapter(this);
        db.openDB();
        Cursor c=db.retrieve();
        Spacecraft spacecraft=null;

        while (c.moveToNext())
        {
            int id=c.getInt(0);
            String name=c.getString(1);

            spacecraft=new Spacecraft();
            spacecraft.setId(id);
            spacecraft.setName(name);

            spacecrafts.add(spacecraft);
        }

        db.closeDB();
        lv.setAdapter(adapter);
    }

    //UPDATE OR EDIT
    private void update(String newName)
    {
        //GET ID OF SPACECRAFT
        int id=adapter.getSelectedItemID();

        //UPDATE IN DB
        DBAdapter db=new DBAdapter(this);
        db.openDB();
        boolean updated=db.update(newName,id);
        db.closeDB();

        if(updated)
        {
            nameEditText.setText(newName);
            getSpacecrafts();
        }else {
            Toast.makeText(this,"Unable To Update",Toast.LENGTH_SHORT).show();
        }

    }

    private void delete()
    {
        //GET ID
        int id=adapter.getSelectedItemID();

        //DELETE FROM DB
        DBAdapter db=new DBAdapter(this);
        db.openDB();
        boolean deleted=db.delete(id);
        db.closeDB();

        if(deleted)
        {
            getSpacecrafts();
        }else {
            Toast.makeText(this,"Unable To Delete",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        CharSequence title=item.getTitle();
        if(title=="NEW")
        {
            displayDialog(!forUpdate);

        }else  if(title=="EDIT")
        {
            displayDialog(forUpdate);

        }else  if(title=="DELETE")
        {
            delete();
        }

        return super.onContextItemSelected(item);
    }
}