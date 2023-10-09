package com.example.thesis.utils;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatDelegate;

public class ThemeUtils {

    private static final String SHARED_PREFERENCES = "SharedPref";

    //Mode_Night_NO =1
    //MODE_NIGHT_YES = 2
    private static final int DARK_MODE_YES = 2;
    private static final int DARK_MODE_NO = 1;

    private static boolean themeMode = false;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;


    public static void setActualTheme(int theme, Context context){

        AppCompatDelegate.setDefaultNightMode(theme);
        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        themeMode = (theme-1 != 0);
        editor = sharedPreferences.edit();
        editor.putInt(SHARED_PREFERENCES, theme);
        themeMode = Boolean.parseBoolean(String.valueOf(theme-1));
        editor.apply();
    }

    public static void getActualTheme(Context context){

        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        int theme = sharedPreferences.getInt(SHARED_PREFERENCES, 1);
        themeMode = (theme-1 != 0);
        AppCompatDelegate.setDefaultNightMode(theme);

    }

    public static boolean isThemeMode() {
        return themeMode;
    }

    public static void setThemeMode(boolean themeMode) {
        ThemeUtils.themeMode = themeMode;
    }
}
