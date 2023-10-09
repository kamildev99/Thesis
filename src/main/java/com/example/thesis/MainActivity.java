package com.example.thesis;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.thesis.service.Database.AppBackendless;
import com.example.thesis.utils.ThemeUtils;
import com.example.thesis.view.ui.CalculatorView;
import com.example.thesis.view.ui.CategoryView;
import com.example.thesis.view.ui.SettingsView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    //Variables
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    private static final String TAG = "mytag";
    CardView productCard, cooperationCard, settingsCard, calculatorCard;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.layout_product_view);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true); //pozwala na sklaowanie w konsekwencji na wyswietlenie obrazka wektorowego - image vector

        /*------------------------------------Hooks-----------------------*/
        drawerLayout = findViewById(R.id.drawer_layout);
        //navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(null);

        /*----------------------------------- Card View -------------------------*/
         productCard = (CardView) findViewById(R.id.products_card);
         cooperationCard = (CardView) findViewById(R.id.coopeartion_card);
         calculatorCard = (CardView) findViewById(R.id.calculator_card);
         settingsCard = (CardView) findViewById(R.id.settings_card);

        /*-----------------------------------Tool Bar-----------------------*/
        setSupportActionBar(toolbar);

        /*------------------------------------Hooks-----------------------*/
        //navigationView.bringToFront();
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();



        /*####################################  CARD VIEW PRODUCT LIST LISTENER ################################ */

        productCard.setOnClickListener(this);
        settingsCard.setOnClickListener(this);
        calculatorCard.setOnClickListener(this);

        ThemeUtils.getActualTheme(this);

        AppBackendless appBackendless = new AppBackendless(getApplicationContext());


    }



    // Definicja dla cardview oraz innych activity

    @Override
    public void onClick(View view) {
        Intent i;

        if(view.getId() == R.id.settings_card){

            System.out.println("Klik w settings");
            i = new Intent(this, SettingsView.class);
            startActivity(i);



        }

        else if(view.getId() == R.id.products_card){
            System.out.println("Klik w Products");
            System.out.println("Wersja: " + Build.VERSION.SDK_INT);
            i = new Intent(this, CategoryView.class);
            startActivity(i);

        } else if(view.getId() == R.id.coopeartion_card){
            System.out.println("Klik w zalaczniki");

        } else if(view.getId() == R.id.calculator_card){
            System.out.println("Klik w calculator");
            i = new Intent(this, CalculatorView.class);
            startActivity(i);
        }

    }


    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }

        super.onBackPressed();
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        return false;
    }




}