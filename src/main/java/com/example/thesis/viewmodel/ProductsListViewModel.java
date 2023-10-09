package com.example.thesis.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.Observable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.thesis.service.model.Products;
import com.example.thesis.service.respository.ProductsRespository;

import java.util.List;

public class ProductsListViewModel extends AndroidViewModel implements Observable {

    private ProductsRespository productsRespository;
    private MutableLiveData<List<Products>> mProducts;

    /*public LiveData<List<Products>> getProducts(){
        return mProducts;
    }*/

    public ProductsListViewModel(@NonNull Application application) {
        super(application);
        productsRespository = new ProductsRespository(application);
        mProducts = productsRespository.getAllProducts();

    }


    public MutableLiveData<List<Products>> getAllProductsFromSubCategory(int idSubCategory)
    {return productsRespository.getAllProductsFromSubCategory(idSubCategory);}

    public MutableLiveData<List<Products>> getAllProducts(){
        return mProducts;
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
}
