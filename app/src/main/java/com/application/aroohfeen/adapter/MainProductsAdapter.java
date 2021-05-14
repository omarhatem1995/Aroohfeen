package com.application.aroohfeen.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.application.aroohfeen.R;
import com.application.aroohfeen.model.MainProductsItem;
import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainProductsAdapter extends RecyclerView.Adapter<MainProductsAdapter.MainProductsViewHolder> {


    private final Context mContext;
    private String TAG = "MainProductsViewHolderTAG";
    private int number = 1;
    private List<MainProductsItem> mainProductsItems;

    public MainProductsAdapter(Context mContext , List<MainProductsItem> mainProductsItems) {
        this.mContext = mContext;
        this.mainProductsItems = mainProductsItems;
    }

    @NonNull
    @Override
    public MainProductsAdapter.MainProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_main_products, parent, false);
        MainProductsAdapter.MainProductsViewHolder viewHolder = new MainProductsAdapter.MainProductsViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainProductsAdapter.MainProductsViewHolder holder, int position) {
        MainProductsItem mainProductsItem = mainProductsItems.get(position);
        String productName = mainProductsItem.getProductName();
        int productImage = mainProductsItem.getProductImage();
        String productPrice = mainProductsItem.getProductPrice();

        holder.mainProductsName.setText(productName);
        Log.d("mainPresent" , " item is " + productName);
        Glide.with(mContext)
                .load(productImage)
                .into(holder.mainProductsImage);
    }

    @Override
    public int getItemCount() {
        if (mainProductsItems.size() != 0) {
            return mainProductsItems.size();
        }else {
            return 0;
        }
    }

    public static class MainProductsViewHolder extends RecyclerView.ViewHolder {
        private ImageView mainProductsImage;
        private TextView mainProductsName;
        public MainProductsViewHolder(@NonNull View itemView) {
            super(itemView);

            mainProductsName = itemView.findViewById(R.id.main_product_name);
            mainProductsImage = itemView.findViewById(R.id.main_product_image);
        }
    }
}