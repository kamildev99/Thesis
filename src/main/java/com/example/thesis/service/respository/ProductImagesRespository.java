package com.example.thesis.service.respository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.thesis.api.ApiClient;
import com.example.thesis.service.model.ProductImages;
import com.example.thesis.service.model.Tools;

import java.util.List;

public class ProductImagesRespository {

    private Application application;
    private ApiClient apiClient;
    private MutableLiveData<List<Tools>> mTools;


    public ProductImagesRespository(Application application){
        this.application = application;
        this.apiClient = new ApiClient();

    }



    public MutableLiveData<List<ProductImages>> getAllProductImages(){

        MutableLiveData<List<ProductImages>> mldProductImages= new MutableLiveData<>();

        mldProductImages = this.apiClient.getImagesProduct();

        return mldProductImages;
    }


    public MutableLiveData<List<ProductImages>> getProductImages(int productId){

        MutableLiveData<List<ProductImages>> mldProductImages= new MutableLiveData<>();

        mldProductImages = this.apiClient.getSubProductImages(productId);

        return mldProductImages;
    }



}
