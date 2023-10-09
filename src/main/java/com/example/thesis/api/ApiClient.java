package com.example.thesis.api;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.backendless.Backendless;
import com.backendless.exceptions.BackendlessException;
import com.backendless.persistence.DataQueryBuilder;
import com.example.thesis.service.model.Category;
import com.example.thesis.service.model.Instructions;
import com.example.thesis.service.model.InstructionFiles;
import com.example.thesis.service.model.ProductImages;
import com.example.thesis.service.model.Products;
import com.example.thesis.service.model.SubCategory;
import com.example.thesis.service.model.Tools;

import java.util.ArrayList;
import java.util.List;

public class ApiClient implements ApiService {






    @Override
    public MutableLiveData<List<Category>> getCategories() {
        MutableLiveData<List<Category>> category = new MutableLiveData<>();
        List<Category> result = new ArrayList<>();

        try {
            result = Backendless.Data.of(Category.class).find();
            category.setValue(result);
        }
        catch(BackendlessException e){
            Log.d("BackException", e.getMessage());
        }

        return category;
    }



    @Override
    public MutableLiveData<List<SubCategory>> getSubCategoriesSub(int value) {
        MutableLiveData<List<SubCategory>> subCategory = new MutableLiveData<>();
        List<SubCategory> result = new ArrayList<>();

        try {
            String whereClause = "subCategoryId in(SubCategory[categoryId.categoryId ="+ value + " ].subCategoryId)";
            DataQueryBuilder queryBuilder = DataQueryBuilder.create();
            queryBuilder.setWhereClause(whereClause);
            result = Backendless.Data.of(SubCategory.class).find(queryBuilder);
            subCategory.setValue(result);

        }
        catch(BackendlessException e) {
            subCategory.setValue(result);
            Log.d("BackException",e.getMessage());
        }

        return subCategory;
    }

    @Override
    public MutableLiveData<List<Products>> getSubProducts(int value) {
        MutableLiveData<List<Products>> products = new MutableLiveData<>();

        try {

            String whereClause = "productId in(Products[subCategoryId.subCategoryId ="+ value + " ].productId)";
            DataQueryBuilder queryBuilder = DataQueryBuilder.create();
            queryBuilder.setWhereClause(whereClause);
            List<Products> result = Backendless.Data.of(Products.class).find(queryBuilder);
            products.setValue(result);

        }
        catch(Exception e){
            System.out.println("blad " + e);
        }

        return products;
    }

    @Override
    public MutableLiveData<List<Tools>> getSubTools(int value) {

        MutableLiveData<List<Tools>> tools = new MutableLiveData<>();

        try {

            String whereClause = "toolsId in(Tools[productId.productId="+value +"].toolsId)";
            DataQueryBuilder queryBuilder = DataQueryBuilder.create();
            queryBuilder.setWhereClause(whereClause);
            List<Tools> result = Backendless.Data.of(Tools.class).find(queryBuilder);
            tools.setValue(result);
            System.out.println(result);

        }
        catch(Exception e){
            System.out.println("blad " + e);
        }
        return tools;

    }



    @Override
    public MutableLiveData<Instructions> getSubInstruction(int value) {

        MutableLiveData<Instructions> instructions = new MutableLiveData<>();

        try {

            String whereClause = "instructionId in(Instructions[productId.productId="+value +"].instructionId)";
            //String whereClause = "instructionId in(Products[productId = " + value +"].instructionId)";
            DataQueryBuilder queryBuilder = DataQueryBuilder.create();
            queryBuilder.setWhereClause(whereClause);
            List<Instructions> result = Backendless.Data.of(Instructions.class).find(queryBuilder);
            instructions.setValue(result.get(0));
            System.out.println("Opis instrukcji: " + result);

        }
        catch(Exception e){
            System.out.println("blad " + e);
        }

        return instructions;
    }




    @Override
    public MutableLiveData<List<ProductImages>> getSubProductImages(int value) {
        MutableLiveData<List<ProductImages>> productImages = new MutableLiveData<>();

        try {

            String whereClause = "productImagesId in(ProductImages[productId.productId="+value +"].productImagesId)";
            DataQueryBuilder queryBuilder = DataQueryBuilder.create();
            queryBuilder.setWhereClause(whereClause);
            List<ProductImages> result = Backendless.Data.of(ProductImages.class).find(queryBuilder);
            productImages.setValue(result);
            System.out.println(result);

        }
        catch(Exception e){
            System.out.println("blad " + e);
        }

        return productImages;
    }


    @Override
    public MutableLiveData<InstructionFiles> getSubInstructionFiles(int value) {
        MutableLiveData<InstructionFiles> instructionfiles = new MutableLiveData<>();

        try {
            //String whereClause = "instructionFileId in(Products[productId.productId ="+ value + " ].instructionFileId)";
            String whereClause = "instructionFileId in(InstructionFiles[productId.productId=" + value + "].instructionFileId)";
            DataQueryBuilder queryBuilder = DataQueryBuilder.create();
            queryBuilder.setWhereClause(whereClause);
            List<InstructionFiles> result = Backendless.Data.of(InstructionFiles.class).find(queryBuilder);
            System.out.print("Przed wywolaniem pobrania instrukcji");
            System.out.print("Pliki: " + result.toString());
            instructionfiles.setValue(result.get(0));
            System.out.println(result);

        }
        catch(Exception e){
            System.out.println("blad " + e);
        }

        return instructionfiles;
    }










    @Override
    public MutableLiveData<List<SubCategory>> getSubCategory() {
        MutableLiveData<List<SubCategory>> subCategory = new MutableLiveData<>();

        List<SubCategory> result = Backendless.Data.of(SubCategory.class).find();
        subCategory.setValue(result);

        return subCategory;
    }


    @Override
    public MutableLiveData<List<Products>> getProducts() {
        MutableLiveData<List<Products>> products = new MutableLiveData<>();

        List<Products> results = Backendless.Data.of(Products.class).find();
        System.out.println("Jestem w produktach " + results);
        products.setValue(results);

        return products;
    }


    @Override
    public MutableLiveData<List<Instructions>> getInstructions() {
        MutableLiveData<List<Instructions>> instructions = new MutableLiveData<>();

        List<Instructions> results = Backendless.Data.of(Instructions.class).find();
        System.out.println("Jestem w instrukcji: " + results);
        instructions.setValue(results);

        return instructions;
    }

    @Override
    public MutableLiveData<List<Tools>> getTools() {
        MutableLiveData<List<Tools>> tools = new MutableLiveData<>();

        List<Tools> results = Backendless.Data.of(Tools.class).find();
        System.out.println("Jestem w tools " +  results);
        tools.setValue(results);

        return tools;
    }

    @Override
    public MutableLiveData<List<ProductImages>> getImagesProduct() {
        MutableLiveData<List<ProductImages>> productsImages = new MutableLiveData<>();

        List<ProductImages> results = Backendless.Data.of(ProductImages.class).find();
        System.out.println("Jestem w productImages " + results);
        productsImages.setValue(results);

        return productsImages;
    }















    /*    public void setDataCategory(){
        Backendless.Data.of(Category.class).find(new AsyncCallback<List<Category>>(){
            @Override
            public void handleResponse( List<Category> foundContacts )
            {
                List<Category> category = new ArrayList<>()
            }
            @Override
            public void handleFault( BackendlessFault fault )
            {
                // an error has occurred, the error code can be retrieved with fault.getCode()
            }
        });
    }*/



}
