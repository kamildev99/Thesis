package com.example.thesis.service.respository;

import androidx.lifecycle.MutableLiveData;

import com.example.thesis.api.ApiClient;
import com.example.thesis.service.model.SubCategory;

import java.util.List;

public class SubCategoryRespository {

    private MutableLiveData<List<SubCategory>> mSubCategories;
    private ApiClient apiClient;

    public SubCategoryRespository(){
        this.apiClient = new ApiClient();
        mSubCategories = this.getAllSubCategories();

    }



    public MutableLiveData<List<SubCategory>> getAllSubCategories(){

        MutableLiveData<List<SubCategory>> mldSubCategory= new MutableLiveData<>();
        mldSubCategory = this.apiClient.getSubCategory();

        return mldSubCategory;
    }



    public MutableLiveData<List<SubCategory>> getAllSubCategoriesFromCategory(int idCategory){

        MutableLiveData<List<SubCategory>> mldSubCategory= new MutableLiveData<>();

        mldSubCategory = this.apiClient.getSubCategoriesSub(idCategory);

        return mldSubCategory;
    }







}
