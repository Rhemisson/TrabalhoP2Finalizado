/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.javaweb.Produtos;

import java.text.NumberFormat;

public class Instrumento {

    private int id;
    private String nome;
    private String descricao;
    private String imagem;
    public double preco;
   

    public Instrumento() {
    }

    public Instrumento(int id, String nome, String descricao, String imagem, double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.imagem = imagem;
        this.preco = preco;
        
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public String getNome() {
        return nome;
    }

    public String getPreco() {
        NumberFormat formatadorMoeda = NumberFormat.getCurrencyInstance();
        String preco = formatadorMoeda.format(this.preco);
        return preco;
    }

    public double getPrecoNormal() {
        return preco;
    }
}
