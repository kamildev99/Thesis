package com.example.thesis.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class SubCategory implements Parcelable {

    private int subCategoryId;
    private String nameSubCategory;
    private String imageUrl;
    private int categoryId;

    private List<Products> products = new ArrayList<>();
    private String type;



    public SubCategory(){}

    public SubCategory(int subCategoryId, String nameSubCategory, String imageUrl, int categoryId) {
        this.subCategoryId = subCategoryId;
        this.nameSubCategory = nameSubCategory;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
    }

    public SubCategory(String nameSubCategory, List<Products> products, String type, String imageUrl) {
        this.nameSubCategory = nameSubCategory;
        this.products = products;
        this.type = type;
        this.imageUrl = imageUrl;
    }


    @BindingAdapter("android:loadImage")
    public static void loadImage(ImageView imageView, String imageUrl){
        Glide.with(imageView).load(imageUrl).into(imageView);
    }


    public String getNameSubCategory() {
        return nameSubCategory;
    }

    public void setNameSubCategory(String nameSubCategory) {
        this.nameSubCategory = nameSubCategory;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }


    protected SubCategory(Parcel in) {
        nameSubCategory = in.readString();
        products = in.createTypedArrayList(Products.CREATOR);
        type = in.readString();
        imageUrl = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameSubCategory);
        dest.writeTypedList(products);
        dest.writeString(type);
        dest.writeString(imageUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }


    public static final Creator<SubCategory> CREATOR = new Creator<SubCategory>() {
        @Override
        public SubCategory createFromParcel(Parcel in) {
            return new SubCategory(in);
        }

        @Override
        public SubCategory[] newArray(int size) {
            return new SubCategory[size];
        }
    };
}
