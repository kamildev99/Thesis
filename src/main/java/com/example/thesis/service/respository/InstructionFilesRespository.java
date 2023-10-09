package com.example.thesis.service.respository;

import androidx.lifecycle.MutableLiveData;

import com.example.thesis.api.ApiClient;
import com.example.thesis.service.model.InstructionFiles;

public class InstructionFilesRespository {


    ApiClient apiClient;


    public InstructionFilesRespository() {
        this.apiClient = new ApiClient();
    }

    public MutableLiveData<InstructionFiles> instructionFilesProductResultAssigned(int value){

        MutableLiveData<InstructionFiles> instructionFiles = new MutableLiveData<>();

        try {
            System.out.println("Ta wartość ");
            instructionFiles = apiClient.getSubInstructionFiles(value);
            return instructionFiles;

        } catch(Exception e) {
            System.out.println("Result Assigned something went wrong");
        }
        return null;
    }

}
