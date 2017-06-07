package com.example.alvinpranata.projectpeniruas;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by tc4b03 on 5/9/2017.
 */

/*
public class RecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Product> productList;

    public RecycleAdapter(List<Product> productList){
        this.productList = productList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);

        RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(view){};
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TextView textName = (TextView) holder.itemView.findViewById(R.id.txtTittle);
        TextView textHarga = (TextView) holder.itemView.findViewById(R.id.txtHarga);
        TextView textDesk = (TextView) holder.itemView.findViewById(R.id.txtDesk);
        ImageView imageView = (ImageView) holder.itemView.findViewById(R.id.imageFoto);

        textName.setText(productList.get(position).getNama());
        textHarga.setText("Rp. "+productList.get(position).getHarga());
        textDesk.setText(productList.get(position).getDeskripsi());

        URL url = null;

        try {
            url = new URL("http://penir.jitusolution.com/img/"+productList.get(position).getId()+".jpg");
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            imageView.setImageBitmap(bitmap);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
*/
