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

public class RecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Post> postList;

    public RecycleAdapter(List<Post> postList){
        this.postList = postList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);

        RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(view){};
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TextView textTitle = (TextView) holder.itemView.findViewById(R.id.txtTittle);
        ImageView imageLike = (ImageView) holder.itemView.findViewById(R.id.imageLike);
        TextView jumlahLike = (TextView) holder.itemView.findViewById(R.id.textJumlahLike);
        ImageView imageFoto = (ImageView) holder.itemView.findViewById(R.id.imageFoto);

        textTitle.setText(postList.get(position).getTitle());
        jumlahLike.setText(""+postList.get(position).getJumlah_like());
        URL url = null;

        try {
            url = new URL("http://103.52.146.34/penir/penir06/"+postList.get(position).getKategori()+"/"+postList.get(position).getGambar());
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            imageFoto.setImageBitmap(bitmap);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
