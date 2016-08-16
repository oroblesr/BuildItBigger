package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;



/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private ProgressBar spinner;
    private Button buttonTellJoke;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        spinner = (ProgressBar) root.findViewById(R.id.progressBar);
        spinner.setVisibility(View.GONE);

        buttonTellJoke = (Button) root.findViewById(R.id.buttonTellJoke);
        buttonTellJoke.setOnClickListener(tellJokeListener);

        return root;
    }

    @Override
    public void onPause(){
        super.onPause();
        spinner.setVisibility(View.GONE);
    }

    private View.OnClickListener tellJokeListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            spinner.setVisibility(View.VISIBLE);

            new JokeEndpointsAsyncTask().execute(new Pair<Context, String>(getContext(), "Paid"));

        }
    };


}
