package com.example.thesis.view.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.thesis.databinding.CalculatorLayoutBinding;
import com.example.thesis.viewmodel.CalculatorViewModel;

import java.util.List;

public class CalculatorView extends AppCompatActivity {


    private CalculatorViewModel calculatorViewModel;
    CalculatorLayoutBinding calculatorLayoutBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        calculatorLayoutBinding =calculatorLayoutBinding.inflate(getLayoutInflater());
        setContentView(calculatorLayoutBinding.getRoot());

        calculatorViewModel = ViewModelProviders.of(this).get(CalculatorViewModel.class);
        calculatorLayoutBinding.setCalculatorViewModel(calculatorViewModel);
        calculatorLayoutBinding.setLifecycleOwner(this);

        calculatorViewModel.mValues.observe(this, new Observer<List<Double>>() {
            @Override
            public void onChanged(List<Double> doubles) {
                Log.d("calcResult", doubles.toString());
            }
        });

    }

}
