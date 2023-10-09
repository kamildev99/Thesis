package com.example.thesis.service.respository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.thesis.api.ApiClient;
import com.example.thesis.service.model.Products;

import java.util.ArrayList;
import java.util.List;

public class ProductsRespository {

    private Application application;
    private MutableLiveData<List<Products>> mProducts;

    private ApiClient apiClient;

    public ProductsRespository(Application application){
        this.application = application;
        this.apiClient = new ApiClient();

    }



    public List<Products> getProducts(int idSubCategory){
        List<Products> products = new ArrayList<>();

        for(int i=0; i< mProducts.getValue().size(); i++){
            if(mProducts.getValue().get(i).getSubCategoryId() == idSubCategory){
                products.add(mProducts.getValue().get(i));
            }
        }
        return products;
    }


    public MutableLiveData<List<Products>> getAllProductsFromSubCategory(int idSubCategory){
        List<Products> mProducts = new ArrayList<>();
        MutableLiveData<List<Products>> mLDproducts = new MutableLiveData<>();

        mLDproducts = apiClient.getSubProducts(idSubCategory);

        return mLDproducts;
    }






    public Products getProduct(int idProduct){
        List<Products> mProducts = new ArrayList<>();
        MutableLiveData<List<Products>> mLDproducts = new MutableLiveData<>();

        for(Products tmpProducts : getAllProducts().getValue()){
            if(tmpProducts.getProductId() == idProduct){
                return tmpProducts;
            }
        }


        return null;
    }



    public MutableLiveData<List<Products>> getAllProducts(){
        MutableLiveData<List<Products>> mldProducts= new MutableLiveData<>();

        mldProducts = this.apiClient.getProducts();
        return mldProducts;
    }











}
