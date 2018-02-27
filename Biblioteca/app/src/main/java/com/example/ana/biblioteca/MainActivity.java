package com.example.ana.biblioteca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Livro> listaDeLivros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        listaDeLivros = new ArrayList<Livro>();

        Livro livro = new Livro ("Harry Potter", "J.K Rowling");
        Livro novolivro = new Livro ( "O nome do vento", "Patrick Rothfuss");
        Livro novonovoLivro = new Livro ("O Ladrão de Raios", "Rick Riordan");
        listaDeLivros.add(livro);
        listaDeLivros.add(novolivro);
        listaDeLivros.add(novonovoLivro);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, listaDeLivros);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
