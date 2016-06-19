/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.javaweb.Produtos;



import java.util.ArrayList;
import java.util.List;

 public class AdicionarCarrinho {

    private List<ItemP> items = new ArrayList<ItemP>();

    public AdicionarCarrinho() {
    }
    
    

    public AdicionarCarrinho(ItemP item) {
        this.addItem(item);
    }

    public void addItem(ItemP item) {
        if (items.contains(item)) {
            int indice = items.indexOf(item);
            ItemP temp = (ItemP) items.get(indice);
            int quantidade = temp.getQuantidade();
            temp.setQuantidade(quantidade + 1);
        } else {
            this.items.add(item);
        }
    }

    public List<ItemP> getItems() {
        return items;
    }
}
