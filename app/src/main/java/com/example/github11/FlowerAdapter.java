package com.example.github11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.ViewHolder> {

    private final static String avatarUrl = " https://api.github.com/";
    private List<Flower> mFlowers;
    private Context mContext;
    private String login;
    private int contributions;


    FlowerAdapter(List<Flower> flowers) {
        this.mFlowers = flowers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Flower flower = mFlowers.get(position);
        //holder.nameTextView.setText(flower.getName());




        Picasso.get()
                .load(flower.getAvatarUrl())

                .resize(100, 100)
                .into(holder.flowerImageView);

        holder.nameTextView.setText(flower.getLogin());
        holder.textView1.setText(flower.getContributions().toString());

    }

    @Override
    public int getItemCount() {
        if (mFlowers == null) {
            return 0;
        }
        return mFlowers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView nameTextView;
        ImageView flowerImageView;

        ViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            flowerImageView = (ImageView) itemView.findViewById(R.id.itemImageView);
            textView1 = (TextView) itemView.findViewById(R.id.textView1);
        }
    }
}