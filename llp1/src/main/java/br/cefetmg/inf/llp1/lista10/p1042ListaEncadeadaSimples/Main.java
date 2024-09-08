package br.cefetmg.inf.llp1.lista10.p1042ListaEncadeadaSimples;

import java.util.Scanner;

enum StatusLista {SUCESSO, POSICAOINVALIDA};

// erros no código(método inserir)
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
    
    Lista() {
        inicio = null;
        fim = null;
        quantos = 0;
    }
    
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
        No novo = new No(item);
        
        if (vazia()) {
            fim = novo;
            inicio = novo;
            novo.proximo = null;
        }
        else {
            novo.proximo = inicio;
            inicio = novo;
        }
        quantos++;
    }
    
    // insere item no final da lista
    public void inserirFim(Integer item) {
        No novo = new No(item);
        
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

        if(posicao == 0)
            inserirInicio(item);
        else if(posicao == tamanho())
            inserirFim(item);
        else {
            int p = 1;
            No novo = new No(item);
            No aux = inicio;
           
            for (int i = 0; i < posicao - 1; i++) {
                aux = aux.proximo;
            }
            
            novo.proximo = aux.proximo;
            aux.proximo = novo;
            quantos++;
        }
        return StatusLista.SUCESSO;
    }
    
    // remove item no início da lista
    // retorna null se lista vazia
    public Integer removerInicio() { 
        if(vazia())
            return null;
        
        Integer valorRemovido = inicio.item;
        inicio = inicio.proximo;
        quantos--;
        return valorRemovido;
    }
    
    // remove item no final da lista
    // retorna null se lista vazia
    public Integer removerFim() {
        if(vazia())
            return null;
        
        Integer valorRemovido = fim.item;
        
        if(inicio == fim) {
            inicio = null;
            fim = null;
        }
        else {
            No aux = inicio;
            while(aux.proximo != fim) {
                aux = aux.proximo;
            } 
            aux.proximo = null;
            fim = aux;
        }
        quantos--;
        return valorRemovido;
    }
    
    // remove item na 'posicao' da lista
    // retorna null se posicao inválida
    public Integer remover(int posicao) {
        if(vazia() || posicao < 0 || posicao > tamanho()-1)
            return null;
        if(posicao == 0)
            return removerInicio();
        if(posicao == tamanho()-1)
            return removerFim();
        
        Integer valorRemovido = obter(posicao);
        No aux = inicio;
        for (int i = 0; i < posicao - 1; i++) {
            aux = aux.proximo;
        }
        No proximo = aux.proximo;
        aux.proximo = proximo.proximo;
        quantos--;
        
        return valorRemovido;
    }
    
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
        if(vazia() || posicao > tamanho()-1 || posicao < 0)
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
        if(vazia())
            return -1;
        
        int posicao = 0;
        for(No aux = inicio; aux != null; aux = aux.proximo) {
            if(aux.item == item)
                return posicao;
            
            posicao++;
        }
        return -1; 
    }
    
    private void troca(No a, No b) {
        Integer aux = a.item;
        a.item = b.item;
        b.item = aux;
    }
    
    public void ordenar() {
        if(vazia())
            return;
        
        for(No aux = inicio; aux != null; aux = aux.proximo) 
            for(No aux2 = aux.proximo; aux2 != null; aux2 = aux2.proximo) 
                if(aux.item > aux2.item) 
                    troca(aux, aux2);
                    
    }
    
    public void exibir() {
        if(vazia())
            return;
        
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
        l1.inserir(a, 0);
        l1.inserir(b, 1);
        l1.inserir(c, 2);
        
        Lista l2 = new Lista();
        l2.inserir(a, 0);
        l2.inserir(b, 1);
        l2.inserir(c, 2);
        l1.ordenar();
        
        l1.exibir();
        System.out.println();
        l2.exibir();
    }
}