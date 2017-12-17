package com.jo.netowrking;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ahmed on 30/11/2017.
 */

public class Adapter extends RecyclerView.Adapter<ViewHolder> implements ListItemClickListener {
    Context c;
    List<EarthQuake> items;
    public Adapter(Context c, List<EarthQuake> items) {
        this.c= c;
        this.items=items;
       // this.mOnClickListener = mOnClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(c).inflate(R.layout.earthquake_item,parent,false);

        return new ViewHolder(v,c, this);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
          holder.bind_data(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onItemClick(int itemPostion) {
        Intent openWeb = new Intent(Intent.ACTION_VIEW,Uri.parse(items.get(itemPostion).getUrl()));
        if(openWeb.resolveActivity(c.getPackageManager())!=null){
            c.startActivity(openWeb);
        }
    }


}
