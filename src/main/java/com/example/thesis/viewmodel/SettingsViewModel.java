package com.example.thesis.viewmodel;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.ViewModel;

public class SettingsViewModel extends ViewModel {

    SharedPreferences sharedPreferences;

    public static final String PREFERENCES = "com.example.thesis";
    public static final String CUSTOM_THEME= "customTheme";
    public static final String LIGHT_THEME = "lightTheme";
    public static final String DARK_THEME = "darkTheme";

    private String customTheme;

    public SettingsViewModel(Context context){
        sharedPreferences = context.getSharedPreferences("filename", Context.MODE_PRIVATE);
    }


    public void setNightModeState(Boolean state){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("NightMode", state);
        editor.commit();
    }


    public Boolean loadNightModeState(){
        Boolean state = sharedPreferences.getBoolean("NightMode", false);
        return state;
    }

    public String getCustomTheme() {
        return customTheme;
    }

    public void setCustomTheme(String customTheme) {
        this.customTheme = customTheme;
    }

}
