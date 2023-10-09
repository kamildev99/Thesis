package com.example.thesis.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.thesis.service.model.SubCategory;
import com.example.thesis.service.respository.SubCategoryRespository;

import java.util.List;

public class SubCategoryViewModel extends ViewModel {

    private MutableLiveData<List<SubCategory>> subCategories = new MutableLiveData<>();
    private SubCategoryRespository subCategoryRespository;

    public SubCategoryViewModel() {
        subCategoryRespository = new SubCategoryRespository();
        subCategories = subCategoryRespository.getAllSubCategories();
    }

    public MutableLiveData<List<SubCategory>> getAllSubCategories()
    {return subCategories;}


    public MutableLiveData<List<SubCategory>> getAllSubCategoriesFromCategory(int idCategory)
    {return subCategoryRespository.getAllSubCategoriesFromCategory(idCategory);}


}
