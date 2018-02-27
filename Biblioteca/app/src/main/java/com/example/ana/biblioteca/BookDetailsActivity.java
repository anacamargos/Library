package com.example.ana.biblioteca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BookDetailsActivity extends AppCompatActivity {

    TextView bookName;
    TextView authorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        bookName = (TextView) findViewById(R.id.bd_tv_nomebook);
        authorName = (TextView) findViewById(R.id.bd_tv_nomeauthor);

        Intent intent = getIntent();
        if ( intent != null ) {
            Bundle params = intent.getExtras();
            if (params != null ) {
                Livro livro = (Livro) params.getSerializable("livro");
                bookName.setText(livro.getNomeLivro());
                authorName.setText(livro.getNomeAutor());
            }
        }
    }
}
