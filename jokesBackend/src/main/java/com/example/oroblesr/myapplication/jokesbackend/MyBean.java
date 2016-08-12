package com.example.oroblesr.myapplication.jokesbackend;

import com.example.JavaJokes;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private JavaJokes javaJokes;
    private String myData;

    MyBean(){
        javaJokes = new JavaJokes();
    }

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }

    public String getJoke() {
        return javaJokes.getJoke();
    }
}