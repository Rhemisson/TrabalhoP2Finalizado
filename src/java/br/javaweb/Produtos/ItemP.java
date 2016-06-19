/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.javaweb.Produtos;

public class ItemP {

    private Instrumento instrumento;
    private int quantidade;

    public ItemP(Instrumento inst, int quantidade) {
        this.instrumento = inst;
        this.quantidade = quantidade;
    }

    public Instrumento getInstumentos() {
        return instrumento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setInstrumentos(Instrumento instrumento) {
        this. instrumento= instrumento;
    }

    public void setQuantidade(int i) {
        quantidade = i;
    }
}
