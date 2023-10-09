package com.example.thesis.view.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thesis.R;
//import com.example.thesis.View.RecyclerAdapterProducts;
import com.example.thesis.view.adapter.RecyclerProductsAdapter;
import com.example.thesis.viewmodel.ProductsListViewModel;
import com.example.thesis.service.model.Products;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//import android.widget.SearchView;

public class ProductsListFragment extends AppCompatActivity implements View.OnClickListener, RecyclerProductsAdapter.OnProductListener, Serializable {

        RecyclerView recyclerView;
        RecyclerProductsAdapter recyclerAdapterProducts;
        RelativeLayout relativeLayoutProduct;
        List<Products> products = new ArrayList<>();
        ProductsListViewModel productsListViewModel;


@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_listproducts);
        Toolbar toolbar = findViewById(R.id.toolbar_list_products);
        toolbar.inflateMenu(R.menu.main_menu_search);
        setSupportActionBar(toolbar);



        relativeLayoutProduct = (RelativeLayout)findViewById(R.id.layout_product_list);
        relativeLayoutProduct.setOnClickListener(this);

        productsListViewModel = ViewModelProviders.of(this).get(ProductsListViewModel.class);


        if (getIntent().hasExtra("selected_subcategory")) {

            //products = ((SubCategory) getIntent().getParcelableExtra("selected_subcategory")).getProducts();
            int id = getIntent().getIntExtra("selected_subcategory",0);
                products = productsListViewModel.getAllProductsFromSubCategory(id).getValue();

                recyclerAdapterProducts = new RecyclerProductsAdapter(this, products, this::onProductClick);
                recyclerView = findViewById(R.id.recyclerView_productList);
                recyclerView.setAdapter(recyclerAdapterProducts);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(gridLayoutManager);

        }

        }

@Override
public void onClick(View view) { }

@Override
public void onProductClick(int position) {

        Intent intent;
        intent = new Intent(getApplicationContext(), ProductsView.class);
        intent.putExtra("selected_product", products.get(position).getProductId());
        startActivity(intent);
    }


/*############################3 DO SEARCHVIEW #################################*/

@Override
public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu_search, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

        @Override
        public boolean onQueryTextSubmit(String query) {
                return false;
                }

        @Override
        public boolean onQueryTextChange(String newText) {
        recyclerAdapterProducts.getFilter().filter(newText);
        return false;
        }
        });

        return super.onCreateOptionsMenu(menu);

    }


}
