package com.example;

public class JavaJokes {
    final String joke[] = { "first",
            "second", "third"
    };

    public String getRandJoke(){
        int selectedJoke = (int) Math.floor(Math.random() * joke.length);
        return getJoke(selectedJoke) ;
    }

    public String getJoke(int selectedJoke){
        return joke[selectedJoke];
    }
}
