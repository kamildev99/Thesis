package com.example.thesis.service.model;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class produkty extends RealmObject  {
    @PrimaryKey
    public ObjectId _id;
    public String name;


    public produkty(){

    }

    public produkty(ObjectId _id, String name) {
        this._id = _id;
        this.name = name;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectId get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }


}