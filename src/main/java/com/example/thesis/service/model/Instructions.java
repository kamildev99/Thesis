package com.example.thesis.service.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Instructions implements Parcelable {

    private int instructionId;
    private int productId;
    private String nameInstruction;
    private String instalationDescription;


    public Instructions(){}

    public Instructions(int instructionId, int productId, String nameInstruction, String instalationDescription) {
        this.instructionId = instructionId;
        this.productId = productId;
        this.nameInstruction = nameInstruction;
        this.instalationDescription = instalationDescription;
    }



    public int getInstructionId() {
        return instructionId;
    }

    public void setInstructionId(int instructionId) {
        this.instructionId = instructionId;
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getNameInstruction() {
        return nameInstruction;
    }

    public void setNameInstruction(String nameInstruction) {
        this.nameInstruction = nameInstruction;
    }

    public String getInstalationDescription() {
        return instalationDescription;
    }

    public void setInstalationDescription(String instalationDescription) {
        this.instalationDescription = instalationDescription;
    }



    // ############ PARCELABLE ########################3

    protected Instructions(Parcel in) {
        instructionId = in.readInt();
        nameInstruction = in.readString();
        instalationDescription = in.readString();
    }


    public static final Creator<Instructions> CREATOR = new Creator<Instructions>() {
        @Override
        public Instructions createFromParcel(Parcel in) {
            return new Instructions(in);
        }

        @Override
        public Instructions[] newArray(int size) {
            return new Instructions[size];
        }
    };


    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(instructionId);
        parcel.writeString(nameInstruction);
        parcel.writeString(instalationDescription);
    }



    @Override
    public int describeContents() {
        return 0;
    }



}
