package com.example.thesis.service.respository;

import androidx.lifecycle.MutableLiveData;

import com.example.thesis.api.ApiClient;
import com.example.thesis.service.model.Category;

import java.util.List;

public class CategoryRespository {




    private static CategoryRespository instance;
    private ApiClient apiClient;



    public CategoryRespository(){

        this.apiClient = new ApiClient();
    }




    public static CategoryRespository getInstance(){
        if(instance == null){
            instance = new CategoryRespository();
        }
        return instance;
    }




    public MutableLiveData<List<Category>> getAllCategories(){

        MutableLiveData<List<Category>> category = new MutableLiveData<>();

        try {
            category = apiClient.getCategories();

            return category;
        } catch(Exception e) {
            System.out.println("cos poszlo nie tak");
        }
        return null;

    }







}
