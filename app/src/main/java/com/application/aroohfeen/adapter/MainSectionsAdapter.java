package com.application.aroohfeen.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.aroohfeen.R;
import com.application.aroohfeen.model.MainSectionsItem;
import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainSectionsAdapter extends RecyclerView.Adapter<MainSectionsAdapter.MainSectionsViewHolder> {


    private final Context mContext;
    private String TAG = "MainSectionsViewHolderTAG";
    private int number = 1;
    private List<MainSectionsItem> mainSectionsItems;

    public MainSectionsAdapter(Context mContext , List<MainSectionsItem> mainSectionsItems) {
        this.mContext = mContext;
        this.mainSectionsItems = mainSectionsItems;
    }

    @NonNull
    @Override
    public MainSectionsAdapter.MainSectionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_main_products, parent, false);
        MainSectionsAdapter.MainSectionsViewHolder viewHolder = new MainSectionsAdapter.MainSectionsViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainSectionsAdapter.MainSectionsViewHolder holder, int position) {
        MainSectionsItem mainSectionsItem = mainSectionsItems.get(position);
        String productName = mainSectionsItem.getSectionName();
        int productImage = mainSectionsItem.getSectionImage();

        holder.mainSectionsName.setText(productName);
        Log.d("mainPresent" , " item is " + productName);
        Glide.with(mContext)
                .load(productImage)
                .into(holder.mainSectionsImage);
    }

    @Override
    public int getItemCount() {
        if (mainSectionsItems.size() != 0) {
            return mainSectionsItems.size();
        }else {
            return 0;
        }
    }

    public static class MainSectionsViewHolder extends RecyclerView.ViewHolder {
        private ImageView mainSectionsImage;
        private TextView mainSectionsName;
        public MainSectionsViewHolder(@NonNull View itemView) {
            super(itemView);

            mainSectionsName = itemView.findViewById(R.id.main_product_name);
            mainSectionsImage = itemView.findViewById(R.id.main_product_image);
        }
    }
}