package com.gabriel.principal;

import com.gabriel.entidades.Produto;
import com.gabriel.infra.BancoDados;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    private static final BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));

    public static  void main(String[] args) throws Exception {

        Integer opcao;

        boolean isTrue = true;
        System.out.println("\nBem-vindo(a)");


        while(isTrue) {

            exibirOpcoes();
            opcao = null;

            while(opcao == null){
                try {
                    opcao = Integer.parseInt(leitor.readLine());

                } catch (NumberFormatException e) {
                    System.out.println("\nInforme apenas números");
                    exibirOpcoes();
                }
            }

            if(opcao == 1) {
               cadastrarProduto();
               exibirProdutosOrdemCrescente();
            } else if (opcao == 2) {
                exibirProdutosOrdemCrescente();
            } else if (opcao == 0) {
                isTrue = false;
            } else {
                System.out.println("\nOpção inválida");
            }
        }
    }

    private static void exibirOpcoes(){
        System.out.print(
                "\n1 - Cadastrar um novo produto\n" +
                "2 - Exibir produtos cadastrados\n" +
                "0 - Sair\n\n" +
                "Insira o código da opção desejada: "
        );
    }

    private static void cadastrarProduto() throws IOException {

        System.out.println("---Novo produto---");

        System.out.print("Nome: ");
        String nome = leitor.readLine();

        System.out.print("Descrição: ");
        String descricao = leitor.readLine();

        System.out.print("Valor R$: ");
        String valorString = leitor.readLine();
        if(valorString.contains(",")){
           valorString = valorString.replace(",", ".");
        }

        System.out.print("Disponível (s/n): ");
        char disponivel = leitor.readLine().toLowerCase().charAt(0);

        BancoDados.cadastrar(new Produto(nome, descricao, Double.parseDouble(valorString), produtoDisponivel(disponivel)));
    }

    private static boolean produtoDisponivel(char caractere) {
        return caractere == 's';
    }

    private static void exibirProdutosOrdemCrescente(){
        ArrayList<Produto> produtos = BancoDados.exibirProdutos();

        // Usa a ordem natural de ordenação dos elementos (produtos)
        produtos.sort(null);
        if(!BancoDados.exibirProdutos().isEmpty()) {
            System.out.println("-----------------------------------");
            System.out.println("\tProdutos Cadastrados");
            System.out.println("-----------------------------------");

            System.out.println("\tNome\t|\tValor\t");
            System.out.println("-----------------------------------");

            for(Produto p : produtos) {
                System.out.println(p);
            }
        } else {
            System.out.println("\nLista de produtos vazia");
        }
    }
}
