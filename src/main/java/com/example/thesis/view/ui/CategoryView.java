package com.example.thesis.view.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.thesis.service.model.Category;
import com.example.thesis.viewmodel.CategoryViewModel;
import com.example.thesis.view.Interfaces.OnCategoryListener;
import com.example.thesis.view.adapter.CategoryAdapter;
import com.example.thesis.databinding.ActivityCategoryProductsBinding;

import java.io.Serializable;

public class CategoryView extends AppCompatActivity implements OnCategoryListener, Serializable {


    private ActivityCategoryProductsBinding activityCategoryProductsBinding;

    private CategoryViewModel categoryViewModel;
    CategoryAdapter categoryAdapterRecycler;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        activityCategoryProductsBinding = activityCategoryProductsBinding.inflate(getLayoutInflater());
        setContentView(activityCategoryProductsBinding.getRoot());

        initialization();
        getCategories();

    }


    public void initialization() {
        activityCategoryProductsBinding.recyclerViewCategory.setHasFixedSize(true);
        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
        getCategories();
        categoryAdapterRecycler = new CategoryAdapter(categoryViewModel.getAllCategories().getValue(), this);
        activityCategoryProductsBinding.recyclerViewCategory.setAdapter(categoryAdapterRecycler);

    }

    public void getCategories() {
        categoryViewModel.getAllCategories().observe(this, categoryResponse -> {
            this.categoryAdapterRecycler.notifyDataSetChanged();
        });
    }

    @Override
    public void onCategoryClick(Category category) {
        Intent intent;
        intent = new Intent(getApplicationContext(), SubCategoryView.class);
        intent.putExtra("selected_category", category.getCategoryId());
        startActivity(intent);
    }



}
