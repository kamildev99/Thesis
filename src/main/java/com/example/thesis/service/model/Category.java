package com.example.thesis.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Category implements Parcelable {

    private List<SubCategory> subCategoryList = new ArrayList<>();

    private String objectId;
    private int categoryId;
    private String nameCategory;
    private String imageUrl;

    private String description;
    private String type;


    public Category(){

    }

    public Category(String objectId, int categoryId, String nameCategory, String imageUrl) {
        this.objectId = objectId;
        this.categoryId = categoryId;
        this.nameCategory = nameCategory;
        this.imageUrl = imageUrl;
    }


    public Category(int categoryId, String nameCategory, String imageUrl) {
        this.categoryId = categoryId;
        this.nameCategory = nameCategory;
        this.imageUrl = imageUrl;
    }

    public Category(List<SubCategory> subCategoryList, String nameCategory, String description, String imageUrl) {
        this.subCategoryList = subCategoryList;
        this.nameCategory = nameCategory;
        this.description = description;
        this.imageUrl = imageUrl;
    }



    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }


    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setSubCategoryList(List<SubCategory> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }


    @BindingAdapter("android:loadImage")
    public static void loadImage(ImageView imageView, String imageUrl){
        Glide.with(imageView).load(imageUrl).into(imageView);
    }


    //Parcelable
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(subCategoryList);
        parcel.writeString(nameCategory);
        parcel.writeString(description);
        parcel.writeString(type);
        parcel.writeString(imageUrl);
    }


    protected Category(Parcel in) {
        subCategoryList = in.createTypedArrayList(SubCategory.CREATOR);
        nameCategory = in.readString();
        description = in.readString();
        type = in.readString();
        imageUrl = in.readString();
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

}
