package com.example.thesis.view.ui;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageButton;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProviders;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.thesis.R;
import com.example.thesis.service.model.ProductImages;
import com.example.thesis.service.model.Products;
import com.example.thesis.service.model.Tools;
import com.example.thesis.view.adapter.ExpandableProductAdapter;
import com.example.thesis.viewmodel.ProductImagesViewModel;
import com.example.thesis.viewmodel.ProductViewModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//import com.example.thesis.View.ExpandableProductAdapter;

public class ProductsView extends AppCompatActivity implements Serializable {

    Products products;
    private ExpandableListView expandableListView;
    ProductViewModel productViewModel;
    ProductImagesViewModel productsImagesViewModel;
    List<SlideModel> slideModels;


    ArrayList<String> parent = new ArrayList<>();
    ArrayList<String> q1 = new ArrayList<>();
    ArrayList<String> q2 = new ArrayList<>();
    ArrayList<String> q3 = new ArrayList<>();

    List<ArrayList<String>> secondLevel = new ArrayList<>();
    List<ArrayList<String>> data = new ArrayList<>();

    ViewDataBinding binding;

    ImageButton imageButton;
    ImageButton imageButtonView;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_product_view);


        /* ####################### SLIDER #############################*/
        ImageSlider imageSlider = (ImageSlider) findViewById(R.id.slider);
        slideModels = new ArrayList<>();

        imageButton = findViewById(R.id.pdfBtn);
        imageButtonView = findViewById(R.id.pdfViewBtn);

        //binding = DataBindingUtil.setContentView(this, R.layout.layout_product_view);
        //binding.setLifecycleOwner(this);


        productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        productsImagesViewModel = ViewModelProviders.of(this).get(ProductImagesViewModel.class);

        if (getIntent().hasExtra("selected_product")) {

            //tools=((Products) getIntent().getParcelableExtra("selected_product")).getTools();
            int id = (int) getIntent().getIntExtra("selected_product",0);
            products = productViewModel.getProduct(id);

            setListContentInformation(id);
            setImagesToSlider();

            imageSlider.setImageList(slideModels, true);
            setUpAdapter();
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setImagesToSlider(){

        List<Integer> arrayImgUrls = new ArrayList<>();

            for (ProductImages tmpPrdImgs : productViewModel.getAllProductImages()) {
                    this.slideModels.add(new SlideModel(tmpPrdImgs.getImageUrl(), ""));
            }


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productViewModel.downloadFilePdf(getApplication(), products.getProductId());
            }
        });


        imageButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productViewModel.viewFilePdf(getApplication(), products.getProductId());
            }
        });


    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setListContentInformation(int productId){
        parent.add("Lista narzędzi");
        parent.add("Opis");
        parent.add("Instalacja/Montaż");

        for(Tools tmpTool : productViewModel.getToolsProduct(productId)){
            q1.add(tmpTool.getNameTools());
        }

        q2.add(productViewModel.getProduct(productId).getDescription());
        //String description = "zmienic";
        String description =productViewModel.getInstructionProduct(productId).getInstalationDescription().replaceAll(",", "\n");
        q3.add(description);

    }


    private void setUpAdapter() {

        secondLevel.add(q1);
        secondLevel.add(q2);
        secondLevel.add(q3);
        data.add(q1);
        data.add(q2);
        data.add(q3);

        expandableListView = (ExpandableListView) findViewById(R.id.elvMobiles);
        ExpandableProductAdapter threeLevelListAdapterAdapter = new ExpandableProductAdapter(this, parent, secondLevel, data);
        expandableListView.setAdapter(threeLevelListAdapterAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int previousGroup = -1;


            @Override
            public void onGroupExpand(int groupPosition) {
                if (groupPosition != previousGroup) {
                    expandableListView.collapseGroup(previousGroup);
                }

                previousGroup = groupPosition;
            }
        });
    }
}
