package com.example.thesis.service.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Tools implements Parcelable {

    private int toolsId;
    private String nameTools;
    private String imageUrl;
    private int productId;


    public Tools(){}

    public Tools(int toolsId, String nameTools, String imageUrl, int productId) {
        this.toolsId = toolsId;
        this.nameTools = nameTools;
        this.imageUrl = imageUrl;
        this.productId = productId;
    }

    public Tools(int id, String name) {
        this.toolsId = id;
        this.nameTools = name;
    }

    protected Tools(Parcel in) {
        toolsId = in.readInt();
        nameTools = in.readString();
    }




    public int getToolsId() {
        return toolsId;
    }

    public void setToolsId(int toolsId) {
        this.toolsId = toolsId;
    }

    public String getNameTools() {
        return nameTools;
    }

    public void setNameTools(String nameTools) {
        this.nameTools = nameTools;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeInt(toolsId);
        parcel.writeString(nameTools);
    }


    public static final Creator<Tools> CREATOR = new Creator<Tools>() {
        @Override
        public Tools createFromParcel(Parcel in) {
            return new Tools(in);
        }

        @Override
        public Tools[] newArray(int size) {
            return new Tools[size];
        }
    };
}
