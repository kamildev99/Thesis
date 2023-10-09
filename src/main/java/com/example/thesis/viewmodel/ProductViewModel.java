package com.example.thesis.viewmodel;

import android.app.Application;
import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.databinding.Observable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.thesis.service.model.InstructionFiles;
import com.example.thesis.service.model.Instructions;
import com.example.thesis.service.model.ProductImages;
import com.example.thesis.service.model.Products;
import com.example.thesis.service.model.Tools;
import com.example.thesis.service.respository.InstructionFilesRespository;
import com.example.thesis.service.respository.InstructionRespository;
import com.example.thesis.service.respository.ProductImagesRespository;
import com.example.thesis.service.respository.ProductsRespository;
import com.example.thesis.service.respository.ToolsRespository;
import com.example.thesis.utils.DownlaodUtils;
import com.example.thesis.utils.ViewPdfUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductViewModel extends AndroidViewModel implements Observable {

    ProductsRespository productsRespository;
    ToolsRespository toolsRespository;
    ProductImagesRespository productImagesRespository;
    InstructionRespository instructionRespository;
    InstructionFilesRespository instructionFilesRespository;
    Products products;
    Context context;

    public ProductViewModel(@NonNull Application application) {
        super(application);
        productsRespository = new ProductsRespository(application);
        toolsRespository = new ToolsRespository(application);
        productImagesRespository = new ProductImagesRespository(application);
        instructionRespository = new InstructionRespository(application);
        instructionFilesRespository = new InstructionFilesRespository();
        //products = productsRespository.getProduct();
    }


    public Products getProduct(int id){
        return productsRespository.getProduct(id);
    }


    public List<ProductImages> getProductImages(int productId){
        List<ProductImages> productImages = new ArrayList<>();

        productImages = productImagesRespository.getProductImages(productId).getValue();

        return productImages;
    }



    public List<ProductImages> getAllProductImages(){
        return productImagesRespository.getAllProductImages().getValue();
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Tools> getToolsProduct(int productId){

        List<Tools> tools = new ArrayList<>();

        tools = toolsRespository.getTools(productId);

        return tools;
    }


    public Instructions getInstructionProduct(int productInstructionId){
        return instructionRespository.getInstruction(productInstructionId);
    }


    public void clickDownloadPdf(String imageUrl){
        DownlaodUtils.downloadFile(this.getApplication(), imageUrl);
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    public void downloadFilePdf(Context context, int value){
        MutableLiveData<InstructionFiles> instructionFile = new MutableLiveData<>();
        instructionFile = instructionFilesRespository.instructionFilesProductResultAssigned(value);
        DownlaodUtils.downloadFile(context, instructionFile.getValue().getFileDestination());
    }

    public void viewFilePdf(Context context, int value){
        MutableLiveData<InstructionFiles> instructionFile = new MutableLiveData<>();
        instructionFile = instructionFilesRespository.instructionFilesProductResultAssigned(value);
        ViewPdfUtils.viewPdf(context, instructionFile.getValue().getFileDestination());
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
}
