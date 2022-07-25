package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Context
     /*   “Context, uygulamanın herhangi bir zamandaki durumunu tutan bir objedir.”
        “Uygulamanin kaynaklarına erişmeyi sağlayan
        Android İşletim sistemi tarafından implement edilmiş bir Interface'dir.
        Sıklıkla uygulamanın /res klasörunde bulunan kaynaklara
        (stringler, resim dosyaları vs.) erişimi sağlamak icin kullanılır.*/

        //Activity Context

        //App Context

        //getApplicationContext()

        Toast.makeText(this, "Toast Message", Toast.LENGTH_LONG).show();
    }

    public void save(View view){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Save");
        alert.setMessage("Are you sure?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                //save
                Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_LONG).show();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(MainActivity.this, "Not Saved",Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this, "Not Saved", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();
    }
}