package com.example.thesis.service.respository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;


public class CloudStorageRespository {

    private Application application;
    //private MutableLiveData<FirebaseUser> userMutableLiveData;
    private MutableLiveData<Boolean> loggedOutMutableLiveData;


    public CloudStorageRespository(Application application) {
        this.application = application;
/*
        StorageReference storageRef = storage.getReference();*/
    }




    public void getFilePdf(){
        // Create a reference with an initial file path and name
       /* StorageReference pathReference = storageRef.child("images/stars.jpg");

// Create a reference to a file from a Cloud Storage URI
        StorageReference gsReference = storage.getReferenceFromUrl("gs://bucket/images/stars.jpg");

// Create a reference from an HTTPS URL
// Note that in the URL, characters are URL escaped!
        StorageReference httpsReference = storage.getReferenceFromUrl("https://firebasestorage.googleapis.com/b/bucket/o/images%20stars.jpg");*/
    }

}
