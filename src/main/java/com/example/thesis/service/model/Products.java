package com.example.thesis.service.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;


public class Products implements Parcelable {

    //For Product list
    private int productId;
    private String title;
    private String subTitle;
    private String imageUrl;
    private String description;
    private int subCategoryId;


    //private int typeProduct;
    private List<Tools> tools;
    private boolean expanded;


    //For product View
    //private List<String> imagesView;


    public Products(int productId, String title, String subTitle, String imageUrl, String description, int subCategoryId) {
        this.productId = productId;
        this.title = title;
        this.subTitle = subTitle;
        this.imageUrl = imageUrl;
        this.description = description;
        this.subCategoryId = subCategoryId;

    }

    public Products(String imageUrl, String title, String subTitle, List<Tools> toolId){
        this.title = title;
        this.imageUrl = imageUrl;
        this.subTitle = subTitle;
        this.tools = toolId;
        this.expanded = false;
    }

    public Products(){}

    protected Products(Parcel in) {
        title = in.readString();
        imageUrl = in.readString();
        subTitle = in.readString();
        tools = in.createTypedArrayList(Tools.CREATOR);
        expanded = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(imageUrl);
        dest.writeString(subTitle);
        dest.writeTypedList(tools);
        dest.writeByte((byte) (expanded ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Products> CREATOR = new Creator<Products>() {
        @Override
        public Products createFromParcel(Parcel in) {
            return new Products(in);
        }

        @Override
        public Products[] newArray(int size) {
            return new Products[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }


    public String getSubTitle() {
        return subTitle;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public List<Tools> getTools() {
        return tools;
    }

    public void setTools(List<Tools> tools) {
        this.tools = tools;
    }

    public int getProductId() {
        return productId;
    }

    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }


    public static Creator<Products> getCREATOR() {
        return CREATOR;
    }




}
