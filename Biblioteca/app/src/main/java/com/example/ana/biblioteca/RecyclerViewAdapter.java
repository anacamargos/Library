package com.example.ana.biblioteca;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Ana on 27/02/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    ArrayList<Livro> listaDeLivros;
    View view;
    ViewHolder viewHolder;

    public RecyclerViewAdapter (Context context, ArrayList<Livro> listaDeLivros) {
        this.context = context;
        this.listaDeLivros = listaDeLivros;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.card_layout, parent, false);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Livro livro = listaDeLivros.get(position);
        holder.bookNameTV.setText(livro.getNomeLivro());
        holder.authorNameTV.setText(livro.getNomeAutor());
    }

    @Override
    public int getItemCount() {
        return listaDeLivros.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView bookNameTV;
        TextView authorNameTV;

        public ViewHolder (View intemView) {
            super(intemView);
            bookNameTV = (TextView) itemView.findViewById(R.id.nomeLivro);
            authorNameTV = (TextView) itemView.findViewById(R.id.nomeAutor);
        }

    }
}