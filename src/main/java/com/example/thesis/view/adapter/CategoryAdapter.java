package com.example.thesis.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thesis.service.model.Category;
import com.example.thesis.view.Interfaces.OnCategoryListener;
import com.example.thesis.databinding.RowCategoryBinding;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {


    List<Category> mCategories;
    LayoutInflater layoutInflater;
    OnCategoryListener onCategoryListener;


    public CategoryAdapter(List<Category> category){

        this.mCategories = category;
    }

    public CategoryAdapter(List<Category> category, OnCategoryListener onCategoryListener){
        this.mCategories = category;
        this.onCategoryListener = onCategoryListener;
    }



    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            layoutInflater = LayoutInflater.from(parent.getContext());

        RowCategoryBinding rowCategoryBinding = RowCategoryBinding.inflate(
                layoutInflater, parent, false);
        /*RowCategoryBinding rowCategoryBinding = DataBindingUtil.inflate(
                layoutInflater, R.layout.row_category, parent, false);*/

        return new CategoryViewHolder(rowCategoryBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        holder.bindCategory(mCategories.get(position));
        holder.rowCategoryBinding.setCategoryModel(mCategories.get(position));
        holder.rowCategoryBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }


    public void setmCategories(List<Category> mCategories){
        this.mCategories = mCategories;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder  {


        private RowCategoryBinding rowCategoryBinding;


        public CategoryViewHolder(@NonNull RowCategoryBinding rowCategoryBinding) {
            super(rowCategoryBinding.getRoot());
            this.rowCategoryBinding = rowCategoryBinding;
        }


        public void bindCategory(Category category){

            rowCategoryBinding.getRoot().setOnClickListener(view -> onCategoryListener.onCategoryClick(category));
        }



    }



}


