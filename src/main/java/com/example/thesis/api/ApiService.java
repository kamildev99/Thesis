package com.example.thesis.api;

import androidx.lifecycle.MutableLiveData;

import com.example.thesis.service.model.Category;
import com.example.thesis.service.model.Instructions;
import com.example.thesis.service.model.InstructionFiles;
import com.example.thesis.service.model.Products;
import com.example.thesis.service.model.ProductImages;
import com.example.thesis.service.model.SubCategory;
import com.example.thesis.service.model.Tools;

import java.util.List;

public interface ApiService {

    public MutableLiveData<List<Category>> getCategories();
    public MutableLiveData<List<SubCategory>> getSubCategory();
    public MutableLiveData<List<Products>> getProducts();
    public MutableLiveData<List<Instructions>> getInstructions();
    public MutableLiveData<List<Tools>> getTools();
    public MutableLiveData<List<ProductImages>> getImagesProduct();


    public MutableLiveData<List<SubCategory>> getSubCategoriesSub(int value);
    public MutableLiveData<List<Products>> getSubProducts(int value);
    public MutableLiveData<List<Tools>> getSubTools(int value);
    public MutableLiveData<List<ProductImages>> getSubProductImages(int value);
    public MutableLiveData<Instructions> getSubInstruction(int value);
    public MutableLiveData<InstructionFiles> getSubInstructionFiles(int value);
}
