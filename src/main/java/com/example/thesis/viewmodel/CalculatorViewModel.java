package com.example.thesis.viewmodel;

import android.app.Application;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;


public class CalculatorViewModel extends AndroidViewModel {

    public MutableLiveData<String> radius = new MutableLiveData<>();
    public MutableLiveData<String> pressure = new MutableLiveData<>();
    public MutableLiveData<String> velocity = new MutableLiveData<>();


    public MutableLiveData<String> cofficient = new MutableLiveData<>();
    public MutableLiveData<String> diameter = new MutableLiveData<>();
    public MutableLiveData<String> energy = new MutableLiveData<>();

    public MutableLiveData<List<Double>> mValues = new MutableLiveData<>();

    Application application;
    public CalculatorViewModel(@NonNull Application application){
        super(application);
        this.application = application;
    }





    public double getRadius(double diameter){
        return diameter/2.0;
    }



    public double hazenWilliams(double C, double R, double S){

        double speedWater = 0;
        double k = 0.849;

        speedWater = k * C * Math.pow(R, 0.63) * Math.pow(S, 0.54);
        speedWater = Math.pow(speedWater, 1.85);

        return speedWater;
    }

    public double hazenWilliamsP(double C, double R, double S){
        double p = 0;
        double k = 0.849;
        double d = R/4.0;
        double Q =Math.pow(hazenWilliams(C, R ,S), 1.85) * (Math.PI*Math.pow(d, 2)/4.0);

        p = (7.916/Math.pow(k, 1.85))*(Math.pow(Q, 1.85)/(Math.pow(C, 1.85)* Math.pow(d, 4.87)));

        return p;
    }


    public void onClickCalcualate(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                List<Double> tmp = new ArrayList<>();

                if( diameter.getValue() != null || !diameter.getValue().isEmpty()
                        && cofficient.getValue() != null || !cofficient.getValue().isEmpty()
                        && energy.getValue() != null || !energy.getValue().isEmpty()) {


                    tmp.add(getRadius(Math.round(Double.parseDouble(diameter.getValue())*100000))/100000.0);

                    tmp.add(Math.round(hazenWilliams(Double.parseDouble(cofficient.getValue()),
                            getRadius(Double.parseDouble(diameter.getValue())),
                            Double.parseDouble(energy.getValue()))*100000)/100000.0);

                    tmp.add(Math.round(hazenWilliamsP(Double.parseDouble(cofficient.getValue()),
                            getRadius(Double.parseDouble(diameter.getValue())),
                            Double.parseDouble(energy.getValue())))*100000/100000.0);

                    radius.setValue(String.valueOf(tmp.get(0)));
                    pressure.setValue(String.valueOf(tmp.get(1)));
                    velocity.setValue(String.valueOf(tmp.get(2)));

                    mValues.setValue(tmp);

                } else{
                    Toast.makeText(application.getApplicationContext(), "Proszę wypełnić wszystkie pola.", Toast.LENGTH_LONG).show();
                }

            }
        }, 1000);

    }



}
