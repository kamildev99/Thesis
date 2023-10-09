package com.example.thesis.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thesis.databinding.RowSubcategoryBinding;
import com.example.thesis.service.model.SubCategory;
import com.example.thesis.view.Interfaces.OnSubCategoryListener;

import java.util.List;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.SubCategoryViewHolder> {


    List<SubCategory> mSubCategories;
    LayoutInflater layoutInflater;
    OnSubCategoryListener onSubCategoryListener;


    public SubCategoryAdapter(List<SubCategory> subCategory){

        this.mSubCategories = subCategory;
    }

    public SubCategoryAdapter(List<SubCategory> subCategory, OnSubCategoryListener onSubCategoryListener){
        this.mSubCategories = subCategory;
        this.onSubCategoryListener = onSubCategoryListener;
    }



    @NonNull
    @Override
    public SubCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        layoutInflater = LayoutInflater.from(parent.getContext());

        RowSubcategoryBinding rowSubCategoryBinding = RowSubcategoryBinding.inflate(
                layoutInflater, parent, false);
        return new SubCategoryViewHolder(rowSubCategoryBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull SubCategoryViewHolder holder, int position) {

        holder.bindSubCategory(mSubCategories.get(position));
        holder.rowSubCategoryBinding.setSubCategoryModel(mSubCategories.get(position));
        holder.rowSubCategoryBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mSubCategories.size();
    }


    public void setmSubCategories(List<SubCategory> mSubCategories){
        this.mSubCategories = mSubCategories;
    }

    public class SubCategoryViewHolder extends RecyclerView.ViewHolder  {


        private RowSubcategoryBinding rowSubCategoryBinding;


        public SubCategoryViewHolder(@NonNull RowSubcategoryBinding rowSubCategoryBinding) {
            super(rowSubCategoryBinding.getRoot());
            this.rowSubCategoryBinding = rowSubCategoryBinding;
        }


        public void bindSubCategory(SubCategory subCategory){

            rowSubCategoryBinding.getRoot().setOnClickListener(view -> onSubCategoryListener.onSubCategoryClick(subCategory));
        }

    }

}



