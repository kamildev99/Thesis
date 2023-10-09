package com.example.thesis.service.respository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.thesis.api.ApiClient;
import com.example.thesis.service.model.Tools;

import java.util.ArrayList;
import java.util.List;

public class ToolsRespository {

    private Application application;
    private ApiClient apiClient;
    private MutableLiveData<List<Tools>> mTools;

    public ToolsRespository(Application application){
        this.application = application;
        this.apiClient = new ApiClient();
        mTools = this.getAllTools();
    }




    public MutableLiveData<List<Tools>> getAllTools(){
        MutableLiveData<List<Tools>> mldSubCategory= new MutableLiveData<>();

        mldSubCategory = this.apiClient.getTools();

        return mldSubCategory;
    }


    public List<Tools> getTools(int idProducts){
        List<Tools> tools = new ArrayList<>();

       tools = apiClient.getSubTools(idProducts).getValue();

        return tools;
    }



}
