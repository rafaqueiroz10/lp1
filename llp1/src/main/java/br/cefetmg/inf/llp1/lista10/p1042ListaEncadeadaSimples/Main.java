package br.cefetmg.inf.llp1.lista10.p1042ListaEncadeadaSimples;

import java.util.Scanner;

enum StatusLista {SUCESSO, POSICAOINVALIDA};

class Lista {
    static class No {
        Integer item;
        No proximo;
        
        public No() {
            this(null, null);
        }
        
        public No(Integer item) {
            this(item, null);
        }
        
        public No(Integer item, No proximo) {
            this.item = item;
            this.proximo = proximo;
        }
    }
    
    private int quantos;
    private No inicio, fim;
    
    // número de itens na lista
    public int tamanho() { 
        return quantos;
    }
    
    // true se lista não possuir itens;
    // false em caso contrário
    public boolean vazia() { 
        return (quantos == 0); 
    }
    
    // insere item no início da lista
    public void inserirInicio(Integer item) {
        No novo = new No();
        novo.item = item;
        
        if (vazia()) {
            fim = novo;
            inicio = novo;
            novo.proximo = null;
        }
        else {
            novo.proximo = inicio;
            inicio = novo;
        }
    }
    
    // insere item no final da lista
    public void inserirFim(Integer item) {
        No novo = new No();
        novo.item = item;
        
        if (vazia()) {
            fim = novo;
            inicio = novo;
            novo.proximo = null;
        }
        else {
            fim.proximo = novo;
            fim = novo;
            fim.proximo = null;
        }
        
        quantos++;
    }
    
    // insere item na 'posisao' da lista
    // 'posicao' análoga ao índice dos arrays
    // posição válida: posicao >= 0 && <= tamanho
    public StatusLista inserir(Integer item, int posicao) { 
        if (posicao < 0 || posicao > tamanho())
            return StatusLista.POSICAOINVALIDA;
            
        for(No aux = inicio; aux != null; aux = aux.proximo) {
            if(aux == inicio)
                inserirInicio(item);
            else if(aux == fim)
                inserirFim(item);
            else 
                
        }
        return StatusLista.SUCESSO;
    }
    
    // remove item no início da lista
    // retorna null se lista vazia
    public Integer removerInicio() { 
        Integer valorRemovido = inicio.item;
        inicio = inicio.proximo; 
        return valorRemovido;
    }
    
    // remove item no final da lista
    // retorna null se lista vazia
    public Integer removerFim() {
        Integer valorRemovido = fim.item;
        int posicao = 0;
        
        No aux = inicio;
        while(posicao != tamanho()-2) {
            aux = aux.proximo;
            posicao++;
        } 
        aux.proximo = null;
        return valorRemovido;
    }
    
    // remove item na 'posicao' da lista
    // retorna null se posicao inválida
    /*public Integer remover(int posicao) {
        int p = 0;
        for (No aux = inicio; aux != null;) {
            if (p == posicao) {
                if (aux == inicio) 
                    removerInicio();
                else if (aux == fim) 
                    removerFim();
                else {
                    int pos = 0;
                    for(No aux = inicio.proximo; pos == p-1; aux = aux.proximo) {
                        
                    }
                }
                quantos--;
            }
            else {
                p++;
                aux = aux.proximo;
            }
        }
    }*/
    
    // retorna, sem remover, o item no início da lista
    // null se lista vazia
    public Integer obterInicio() {
        return (vazia()) ? inicio.item : null;
    }
    
    // retorna, sem remover, o item no fim da lista
    // null se lista vazia
    public Integer obterFim() { 
        return (vazia()) ? fim.item : null; 
    }
    
    // retorna, sem remover, o item na posição indicada 
    // null se for posição inválida
    public Integer obter(int posicao) {
        if(posicao > tamanho() || posicao < 0)
            return null;
        
        int p = 0;
        for(No aux = inicio; aux != null; aux = aux.proximo) {
            if(p == posicao)
                return aux.item;
            
            p++;
        }
        return null; 
    }
    
    // retorna posição do item; 
    // -1 em caso contrário
    public int pesquisar (Integer item) {
        int posicao = 0;
        for(No aux = inicio; aux != null; aux = aux.proximo) {
            if(aux.item == item)
                return posicao;
            
            posicao++;
        }
        return -1; 
    }
    
    private void troca(No a, No b) {
        No aux = a;
        a = b;
        b = aux;
    }
    
    public void ordenar() {
        for(No aux = inicio; aux != null; aux = aux.proximo) 
            for(No aux2 = inicio; aux2 != null; aux = aux.proximo) 
                if(aux.item > aux2.item) 
                    troca(aux, aux2);
                    
    }
    
    public void exibir() {
        No aux = inicio;
        while(aux != null) {
            System.out.println(aux.item);
            aux = aux.proximo;
        } 
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        Lista l1 = new Lista();
        l1.inserirFim(a);
        l1.inserirFim(b);
        l1.inserirFim(c);
        Lista l2 = l1;
        l1.ordenar();
        l1.exibir();
        System.out.println();
        l2.exibir();
    }
}