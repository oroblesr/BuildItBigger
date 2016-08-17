package com.example.oroblesr.myapplication.jokesbackend;

import com.example.JavaJokes;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private JavaJokes javaJokes;

    MyBean(){
        javaJokes = new JavaJokes();
    }

    public String getRandJoke() {
        return javaJokes.getRandJoke();
    }

    public String getJoke(int selectedJoke) {
        return javaJokes.getJoke(selectedJoke);
    }
}