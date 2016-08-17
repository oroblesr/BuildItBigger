package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.widget.Toast;

import com.example.oroblesr.myapplication.jokesbackend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.oroblesr.displayjokeslibrary.DisplayActivity;

import java.io.IOException;

/**
 * Created by Oscar on 11/08/2016.
 * Snippet by https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
 */

class JokeEndpointsAsyncTask extends AsyncTask<Pair<Context, Integer>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private int operation;
    private String intentKey = "joke";

    @Override
    protected String doInBackground(Pair<Context, Integer>... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0].first;
        operation = params[0].second;

        try {
            return myApiService.jokeEndpoint().execute().getRandJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {

        if (result != null){
            if (result.equals(context.getString(R.string.timeout))) {
                Toast.makeText(context, R.string.unable_to_contact_server, Toast.LENGTH_LONG).show();
            }
            else{
                Intent intent = new Intent(context, DisplayActivity.class);
                intent.putExtra(intentKey, result);
                context.startActivity(intent);
            }
        }

    }
}