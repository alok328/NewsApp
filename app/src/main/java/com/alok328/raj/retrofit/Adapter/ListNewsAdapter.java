package com.alok328.raj.retrofit.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alok328.raj.retrofit.Interface.ItemClickListener;
import com.alok328.raj.retrofit.Model.Article;
import com.alok328.raj.retrofit.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

class ListNewsViewHOlder extends RecyclerView.ViewHolder implements View.OnClickListener{

    ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    CircleImageView newsImage;
    TextView newsTitle;

    public ListNewsViewHOlder(View itemView) {
        super(itemView);
        newsImage = (CircleImageView) itemView.findViewById(R.id.newsImg);
        newsTitle = (TextView)itemView.findViewById(R.id.newsTitle);
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),false);
    }
}

public class ListNewsAdapter extends RecyclerView.Adapter<ListNewsViewHOlder> {

    List<Article> articles;
    Context context;

    public ListNewsAdapter(List<Article> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    @NonNull
    @Override
    public ListNewsViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.news_layout,parent,false);
        return new ListNewsViewHOlder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListNewsViewHOlder holder, int position) {
        Picasso.with(context)
                .load(articles.get(position).getUrlToImage())
                .into(holder.newsImage);
        holder.newsTitle.setText(articles.get(position).getTitle());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View v, int position, boolean isLongClick) {
                Toast.makeText(context, articles.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
}
