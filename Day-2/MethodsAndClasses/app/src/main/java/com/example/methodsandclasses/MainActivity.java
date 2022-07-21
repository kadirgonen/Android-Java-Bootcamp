package com.example.methodsandclasses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    String username = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("on create called");

        testMethod();

        System.out.println(math(3,5));

        System.out.println(newMethod("Faik"));

        //username = "";

        makeEmployess();

        makeTeachers();
    }

    public void makeTeachers(){
        //instance

        Teachers t1 = new Teachers("Faik","Software",43);
        System.out.println(t1.branch);
    }

    public void makeEmployess(){
        Employees empl1 = new Employees("Seda", 24, "Software");
        System.out.println(empl1.getName());
        empl1.setName("Seda Güler");
        System.out.println(empl1.getName());
    }

    public String newMethod(String string){
        username = "Recep";
        return string + "new Method";
    }

    public int math(int a, int b){
        username ="Filiz";
        int x = 11;
        System.out.println("value of x in math:" +x);
        return a + b;
    }

    public void testMethod(){
        username ="Faik";
        int x = 4 + 4;
        x = 9;
        System.out.println("value of x: " + x);
    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("on resume called");
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("on stop called");
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("on pause called");
    }
}