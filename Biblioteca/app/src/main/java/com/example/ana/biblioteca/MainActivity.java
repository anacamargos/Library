package com.example.ana.biblioteca;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        final RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, listaDeLivros);
        recyclerView.setAdapter(recyclerViewAdapter);

        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(findViewById(R.id.coordinator), "Exemplo de Snackbar", Snackbar.LENGTH_LONG).show();
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(view.getContext());
                LayoutInflater inflater = getLayoutInflater();

                View view1 = inflater.inflate(R.layout.dialog_book, null);
                mBuilder.setView(view1);

                final EditText etNomeAuthor = (EditText) view1.findViewById(R.id.et_nomeAutor);
                final EditText etNomeLivro = (EditText) view1.findViewById(R.id.et_nomeLivro);
                Button btn = (Button) view1.findViewById(R.id.btn);

                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!etNomeAuthor.getText().toString().isEmpty() && !etNomeLivro.getText().toString().isEmpty()) {
                            Livro novoLivro = new Livro (etNomeLivro.getText().toString(),etNomeAuthor.getText().toString());
                            listaDeLivros.add(novoLivro);
                            dialog.dismiss();
                            Toast.makeText(MainActivity.this, "Inserido com sucesso!", Toast.LENGTH_SHORT).show();
                            recyclerViewAdapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(view.getContext(), "Favor preencher todos os campos", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Livro livroClicado = listaDeLivros.get(position);
                Bundle params = new Bundle();
                params.putSerializable("livro",livroClicado);

                Intent intent = new Intent(view.getContext(), BookDetailsActivity.class);
                intent.putExtras(params);
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }
}
