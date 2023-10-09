package com.example.thesis.service.model;

public class ProductImages {

    private int productImagesId;
    private String imageUrl;
    private int productId;
    //private int productId;


    public ProductImages(){}

    public ProductImages(int productImagesId, String imageUrl, int productId) {
        this.productImagesId = productImagesId;
        this.imageUrl = imageUrl;
        this.productId = productId;
        //this.productId = productId;
    }

    public int getProductImagesId() {
        return productImagesId;
    }

    public void setProductImagesId(int productImagesId) {
        this.productImagesId = productImagesId;
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

    /* public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }*/
}
