package com.example.thesis.service.Database;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;

import com.backendless.Backendless;

public class AppBackendless extends Activity {


    public AppBackendless(Context context){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Backendless.setUrl( Defaults.SERVER_URL );

        Backendless.initApp( context,
                Defaults.APPLICATION_ID,
                Defaults.API_KEY );
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }


}
