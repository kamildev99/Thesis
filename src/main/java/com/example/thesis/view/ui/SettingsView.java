package com.example.thesis.view.ui;

import android.content.Context;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thesis.R;
import com.example.thesis.utils.ThemeUtils;
import com.example.thesis.viewmodel.SettingsViewModel;

public class SettingsView extends AppCompatActivity {


    Switch switchThemeBtn;
    SettingsViewModel settingsViewModel;
    Context context;

    private static final int DARK_MODE_YES = 2;
    private static final int DARK_MODE_NO = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_layout);
        this.context = getApplicationContext();

        switchThemeBtn = (Switch) findViewById(R.id.settingsThemeBtn);
        //settingsViewModel = ViewModelProviders.of(this).get(SettingsViewModel.class);

        settingsViewModel = new SettingsViewModel(this);



        ThemeUtils.getActualTheme(context);
        switchThemeBtn.setChecked(ThemeUtils.isThemeMode());


        switchThemeBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               if(b){
                   //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                   ThemeUtils.setActualTheme(DARK_MODE_YES, context);


               } else{
                   //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                   ThemeUtils.setActualTheme(DARK_MODE_NO, context);
               }
            }
        });
    }





}
