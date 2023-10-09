package com.example.thesis.service.respository;

import android.app.Application;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AppRepository {

    private Application application;
    private FirebaseAuth firebaseAuth;
    private MutableLiveData<FirebaseUser> userMutableLiveData;
    private MutableLiveData<Boolean> loggedOutMutableLiveData;


    public AppRepository(Application application){
        this.application = application;

        firebaseAuth = FirebaseAuth.getInstance();
        userMutableLiveData = new MutableLiveData<>();

    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public void register(String email, String password){
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(application.getMainExecutor(), new OnCompleteListener<AuthResult>(){
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task){
                      if(task.isSuccessful()){
                          userMutableLiveData.postValue(firebaseAuth.getCurrentUser());

                      }else{
                          Toast.makeText(application,"Registration failed ", Toast.LENGTH_SHORT).show();

                      }
                  }
                });
    }


    @RequiresApi(api = Build.VERSION_CODES.P)
    public void login(String email, String password){
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(application.getMainExecutor(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            userMutableLiveData.postValue(firebaseAuth.getCurrentUser());
                        } else{
                            Toast.makeText(application, "Login failed", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }



    public MutableLiveData<FirebaseUser> getUserMutableLiveData() {
        return userMutableLiveData;
    }


    public void logOut(){
        firebaseAuth.signOut();
    }

}
