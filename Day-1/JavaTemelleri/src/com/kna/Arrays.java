package com.kna;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Arrays {

    public static void main(String[] args) {

        //Array

        String[] myStringArray = new String[4];

        myStringArray[0] = "Ali";
        myStringArray[1] = "Veli";
        myStringArray[2] = "Ayşe";
        myStringArray[3] = "Fatma";

        System.out.println(myStringArray[1]);

        int[] myIntegerArray = new int[4];

        myIntegerArray[0] = 50;
        myIntegerArray[1] = 60;
        myIntegerArray[2] = 70;
        myIntegerArray[3] = 80;

        System.out.println(myIntegerArray[1]);

        int[] myNumberArray = {1,2,3,4,5,6,7,8};
        System.out.println(myNumberArray[1]);

        //Lists

        ArrayList<String> myTeacher = new ArrayList<String>();

        myTeacher.add("Ali");
        myTeacher.add("Veli");
        myTeacher.add("Ayşe");
        myTeacher.add("Fatma");
        myTeacher.add("Hasan");

        System.out.println(myTeacher.get(0));
        System.out.println(myTeacher.get(1));
        System.out.println(myTeacher.get(2));
        System.out.println(myTeacher.get(3));
        System.out.println(myTeacher.get(4));

        System.out.println(myTeacher.size());

        //Set

        HashSet<String> mySet = new HashSet<String>();

        mySet.add("Faik");
        mySet.add("Gökhan");

        System.out.println(mySet.size());

        //HashMap

        HashMap<String, String> myHashMap = new HashMap<String, String>();

        myHashMap.put("name", "Fatih");
        myHashMap.put("section", "Bilişim");

        System.out.println(myHashMap.get("name"));
        System.out.println(myHashMap.get("section"));


        HashMap<String, Integer>  mysecondMap= new HashMap<String, Integer>();

        mysecondMap.put("run",100);
        mysecondMap.put("basketball",200);

        System.out.println(mysecondMap.get("run"));
        System.out.println(mysecondMap.get("basketball"));


    }
}
