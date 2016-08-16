package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Oscar on 16/08/2016.
 */
@RunWith(AndroidJUnit4.class)
public class JokeFetchTest  {


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void buttonRetrievesJoke(){
        onView(withId(R.id.buttonTellJoke)).perform(click());
        onView(withId(R.id.jokeDisplayText)).check(matches(withText("Hello From Java Lib")));
    }




}
