package com.haim;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by DELL e7440 on 15/05/2017.
 */
public class IO {

    private String name;

    public IO() {
    }

    public IO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static String generateName(String name){
        name = "Test";
        Random r = new Random();
        int rand = r.nextInt(9)+1;
        String date = new SimpleDateFormat("ddMMyyyyhhmm").format(new Date());
//        System.out.println(name+date+rand);

        String newName = name+date+rand;

        return newName;
    }

    @Override
    public String toString() {
        return name;
    }
}
