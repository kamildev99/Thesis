package com.example.thesis.view.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.thesis.databinding.ActivitySubcategoryProductsBinding;
import com.example.thesis.service.model.SubCategory;
import com.example.thesis.view.Interfaces.OnSubCategoryListener;
import com.example.thesis.view.adapter.SubCategoryAdapter;
import com.example.thesis.viewmodel.SubCategoryViewModel;

import java.io.Serializable;

public class SubCategoryView extends AppCompatActivity implements OnSubCategoryListener, Serializable {


    private ActivitySubcategoryProductsBinding activitySubcategoryProductsBinding;
    private SubCategoryViewModel subCategoryViewModel;
    private SubCategoryAdapter subCategoryAdapterRecycler;
    private int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        activitySubcategoryProductsBinding = activitySubcategoryProductsBinding.inflate(getLayoutInflater());
        setContentView(activitySubcategoryProductsBinding.getRoot());

        subCategoryViewModel = ViewModelProviders.of(this).get(SubCategoryViewModel.class);

        if (getIntent().hasExtra("selected_category")) {

            id = getIntent().getIntExtra("selected_category", 0);
            System.out.println("Wartosc id w subCategory:"  + id);
        }


        initialization(id);
        getSubCategories(id);


    }


    public void initialization(int value) {
        activitySubcategoryProductsBinding.recyclerViewSubcategory.setHasFixedSize(true);
        subCategoryViewModel = ViewModelProviders.of(this).get(SubCategoryViewModel.class);
        getSubCategories(value);
        subCategoryAdapterRecycler = new SubCategoryAdapter(subCategoryViewModel.getAllSubCategoriesFromCategory(value).getValue(), this);
        activitySubcategoryProductsBinding.recyclerViewSubcategory.setAdapter(subCategoryAdapterRecycler);

    }

    public void getSubCategories(int value) {
        subCategoryViewModel.getAllSubCategoriesFromCategory(value).observe(this, subCategoryResponse -> {
            this.subCategoryAdapterRecycler.notifyDataSetChanged();
        });
    }


    @Override
    public void onSubCategoryClick(SubCategory subCategory) {
        Intent intent;
        intent = new Intent(getApplicationContext(), ProductsListFragment.class);
        intent.putExtra("selected_subcategory", subCategory.getSubCategoryId());
        startActivity(intent);
    }




}