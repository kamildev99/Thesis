package com.example.thesis.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.Observable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.thesis.service.model.ProductImages;
import com.example.thesis.service.respository.ProductImagesRespository;

import java.util.List;

public class ProductImagesViewModel extends AndroidViewModel implements Observable {

    private MutableLiveData<List<ProductImages>> mProductImages;
    private ProductImagesRespository productImagesRespository;


    public ProductImagesViewModel(@NonNull Application application) {
        super(application);

        productImagesRespository = new ProductImagesRespository(application);
        mProductImages = productImagesRespository.getAllProductImages();
    }

    public MutableLiveData<List<ProductImages>> getAllProductImages(){
        return mProductImages;
    }

    @Override
    public void addOnPropertyChangedCallback(Observable.OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(Observable.OnPropertyChangedCallback callback) {

    }

}
