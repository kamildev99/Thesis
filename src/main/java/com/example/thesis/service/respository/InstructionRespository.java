package com.example.thesis.service.respository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.thesis.api.ApiClient;
import com.example.thesis.service.model.Instructions;

import java.util.List;

public class InstructionRespository {

    private Application application;
    private ApiClient apiClient;
    private MutableLiveData<List<Instructions>> mInstructions;


    public InstructionRespository(Application application) {
        this.application = application;
        this.apiClient = new ApiClient();
        mInstructions = this.getAllInstructions();
    }




    public MutableLiveData<List<Instructions>> getAllInstructions(){

        MutableLiveData<List<Instructions>> mldInstructions = new MutableLiveData<>();

        mldInstructions = this.apiClient.getInstructions();


        return mldInstructions;
    }



    public Instructions getInstruction(int productInstructionId){

        return this.apiClient.getSubInstruction(productInstructionId).getValue();
    }





}
