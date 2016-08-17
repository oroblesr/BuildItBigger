package com.example;

public class JavaJokes {
    final String joke[] = {
            "Knock, knock. \n" +
            "Who's there? \n" +
            "Very long pause... \n" +
            "Java.",

            "Q: \"Whats the object-oriented way to become wealthy?\"\n" +
                    "A: Inheritance\n",

            "Q: \"What do computers and air conditioners have in common?\"\n" +
                    "A: They both become useless when you open windows",

            "Knock knock.\n" +
                    "Race condition.\n" +
                    "Who's there?"
    };

    public String getRandJoke(){
        int selectedJoke = (int) Math.floor(Math.random() * joke.length);
        return getJoke(selectedJoke) ;
    }

    public String getJoke(int selectedJoke){
        return joke[selectedJoke];
    }
}
