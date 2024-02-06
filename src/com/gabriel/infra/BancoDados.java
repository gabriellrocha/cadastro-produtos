package com.gabriel.infra;

import com.gabriel.entidades.Produto;
import java.util.ArrayList;

public class BancoDados {

    private static final ArrayList<Produto> produtos = new ArrayList<>();

    private BancoDados(){
    }

    public static void cadastrar(Produto produto) {
        produtos.add(produto);
    }

    public static ArrayList<Produto> exibirProdutos() {
        return produtos;
    }

}
