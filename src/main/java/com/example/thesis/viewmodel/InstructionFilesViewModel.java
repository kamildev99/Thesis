package com.example.thesis.viewmodel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.thesis.service.model.InstructionFiles;
import com.example.thesis.service.respository.InstructionFilesRespository;
import com.example.thesis.utils.DownlaodUtils;

public class InstructionFilesViewModel extends ViewModel {


   InstructionFilesRespository instructionFilesRespository;

    public InstructionFilesViewModel() {
        super();
        this.instructionFilesRespository = new InstructionFilesRespository();
    }



    public MutableLiveData<InstructionFiles> getInstructionFiles(int value){

        return this.instructionFilesRespository.instructionFilesProductResultAssigned(value);
    }

    public void downloadFilePdf(Context context, int value){
        MutableLiveData<InstructionFiles> instructionFile = new MutableLiveData<>();
        instructionFile = instructionFilesRespository.instructionFilesProductResultAssigned(value);
        DownlaodUtils.downloadFile(context, instructionFile.getValue().getFileDestination());
    }




}
