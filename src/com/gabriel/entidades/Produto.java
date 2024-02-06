package com.gabriel.entidades;

public class Produto implements Comparable<Produto> {

    private String nome;
    private String descricao;
    private double valor;
    private boolean disponivel;

    public Produto(String nome, String descricao, double valor, boolean disponivel) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.disponivel = disponivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String toString() {
        return "\t" + nome + "\t|\tR$" + String.format("%.2f", valor);
    }

    @Override

    // Ordem natural é dada pelo preço
    public int compareTo(Produto outroProduto) {
        if(this.valor < outroProduto.valor) {
            return -1;
        } else if (this.valor > outroProduto.valor) {
            return 1;
        }
        return 0;
    }
}
