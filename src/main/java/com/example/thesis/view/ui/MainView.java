package com.example.thesis.view.ui;

import android.content.Intent;
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

import com.example.thesis.R;
import com.google.android.material.navigation.NavigationView;

public class MainView extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    //Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    private static final String TAG = "mytag";
    /*############# CARD VIEW  ########################*/
    CardView productCard, cooperationCard, settingsCard, contactCard;


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
        settingsCard = (CardView) findViewById(R.id.settings_card);
        contactCard = (CardView) findViewById(R.id.settings_card);

        /*-----------------------------------Tool Bar-----------------------*/
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayShowTitleEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setIcon(R.drawable.ic_baseline_login_24);

        /*------------------------------------Hooks-----------------------*/
        //navigationView.bringToFront();
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();
        //navigationView.setNavigationItemSelectedListener(this);


        /*####################################  CARD VIEW PRODUCT LIST LISTENER ################################ */

        productCard.setOnClickListener(this);

        /*####################################  View Models ##############################*/
        //categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
        //productsViewModel = ViewModelProviders.of(this).get(ProductsListViewModel.class);

    }


    @Override
    public void onClick(View view) {
        Intent i;

        if(view.getId() == R.id.products_card){
            i = new Intent(this, CategoryView.class);
            startActivity(i);
        }
        else if(view.getId() == R.id.calculator_card){

        }

        else if(view.getId() == R.id.settings_card){
            i = new Intent(this, SettingsView.class);
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
