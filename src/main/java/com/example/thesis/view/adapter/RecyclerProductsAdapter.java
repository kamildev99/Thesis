package com.example.thesis.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.thesis.R;
import com.example.thesis.service.model.Products;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RecyclerProductsAdapter extends RecyclerView.Adapter<RecyclerProductsAdapter.AdaViewHolder> implements Filterable {

    private static final String TAG = "RecyclerViewAdapter";

    private Context mContext;
    private List<Products> list;
    private List<Products> listAll;
    private RecyclerProductsAdapter.OnProductListener mOnProductListener;


    public RecyclerProductsAdapter(Context mContext, List<Products> list, RecyclerProductsAdapter.OnProductListener onProductListener) {
        this.mContext = mContext;
        this.list = list;
        this.listAll = new ArrayList<>(list);
        this.mOnProductListener = onProductListener;
    }

    @NonNull
    @Override
    public RecyclerProductsAdapter.AdaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.row, parent,false);
        return new RecyclerProductsAdapter.AdaViewHolder(view, mOnProductListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerProductsAdapter.AdaViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.expandText.setText(list.get(position).getSubTitle());

        Glide.with(holder.itemView.getContext()).load(list.get(position).getImageUrl()).into(holder.myImage);

        boolean isExpanded = list.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.expandArrow.setVisibility(isExpanded ? View.GONE : View.VISIBLE);
        holder.itemView.requestLayout();

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    // ################# FILTERABLE ########################3
    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        //run on background thread
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            List<Products> filteredListP = new ArrayList<Products>();

            if (charSequence.toString().isEmpty()) {
                filteredListP.addAll(listAll);

            } else {
                for (Products p : listAll) {
                    if (p.getTitle().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                        filteredListP.add(p);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredListP;
            return filterResults;
        }

        //runs on a ui thread
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            list.clear();
            list.addAll((Collection<? extends Products>) filterResults.values);
            notifyDataSetChanged();
        }
    };



    public class AdaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        RelativeLayout parentLayout;
        private ImageView myImage;
        private TextView title;
        private TextView subTitle;
        private TextView expandText;
        private RecyclerProductsAdapter.OnProductListener onProductListener;

        LinearLayout expandableLayout;
        ImageButton expandArrow;
        ImageButton hideArrow;

        public AdaViewHolder(@NonNull View itemView, RecyclerProductsAdapter.OnProductListener onProductListener) {
            super(itemView);
            title = itemView.findViewById(R.id.row_text_title);
            myImage = itemView.findViewById(R.id.image_row);
            expandableLayout = itemView.findViewById(R.id.expandableLayoutProductDesc);
            expandText = itemView.findViewById(R.id.expandableTextProductDesc);
            expandArrow = itemView.findViewById(R.id.expand_arrow);
            hideArrow = itemView.findViewById(R.id.hide_arrow);


            this.onProductListener = onProductListener;
            itemView.setOnClickListener(this);
            expandArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Products p = list.get(getAdapterPosition());
                    p.setExpanded(!p.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

            hideArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Products p = list.get(getAdapterPosition());
                    p.setExpanded(!p.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }

        @Override
        public void onClick(View view){
            onProductListener.onProductClick(getAdapterPosition());
        }

    }

    public interface OnProductListener{
        void onProductClick(int position);
    }


}
