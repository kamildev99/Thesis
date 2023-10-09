package com.example.thesis.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.thesis.service.model.Category;
import com.example.thesis.service.respository.CategoryRespository;

import java.util.List;

public class CategoryViewModel extends ViewModel {

    private MutableLiveData<List<Category>> mCategory;
    private CategoryRespository categoryRespository;



    public CategoryViewModel(){
        categoryRespository = new CategoryRespository();
        mCategory = categoryRespository.getAllCategories();
    }



    public MutableLiveData<List<Category>> getAllCategories(){
        return mCategory;
    }


}
