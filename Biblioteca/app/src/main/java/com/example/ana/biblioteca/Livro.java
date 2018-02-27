package com.example.ana.biblioteca;

/**
 * Created by Ana on 27/02/2018.
 */

public class Livro {
    private String nomeLivro;
    private String nomeAutor;

    public Livro ( String nomeLivro, String nomeAutor  ) {
        this.nomeAutor = nomeAutor;
        this.nomeLivro = nomeLivro;
    }

    public String getNomeLivro ( ) {
        return nomeLivro;
    }
    public String getNomeAutor ( ) {
        return nomeAutor;
    }
}
