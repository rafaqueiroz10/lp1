package br.cefetmg.inf.llp1.lista10.p1068ListaDuplaEncadeada;

import java.util.Scanner;

enum StatusLista {SUCESSO, POSICAOINVALIDA};

class Lista {
    class No {
        Character item;
        No proximo, anterior;
        
        public No() {
            this(null, null, null);
        }
        
        public No(Character item) {
            this(item, null, null);
        }
        
        public No(Character item, No proximo, No anterior) {
            this.item = item;
            this.proximo = proximo;
            this.anterior = anterior;
        }
    }
    
    private int quantos;
    No inicio, fim;
    
    public Lista() {
        this(null, null, 0);
    }
    
    public Lista(No inicio, No fim, int quantos) {
        this.inicio = inicio;
        this.fim = fim;
        this.quantos = quantos;
    }
    
    // número de itens na lista
    public int tamanho() { 
        return quantos;
    }
    
    // true se lista não possuir itens;
    // false em caso contrário
    public boolean vazia() { 
        return (tamanho() == 0); 
    }
    
    // insere item no início da lista
    public void inserirInicio(Character item) { 
        No novo = new No(item);
        if(vazia()) {
            inicio = novo;
            fim = novo;
            novo.anterior = null;
            novo.proximo = null;
        }
        else {
            novo.proximo = inicio;
            inicio.anterior = novo;
            novo.anterior = null;
            inicio = novo;
        }
        quantos++;
    }
    
    // insere item no final da lista
    public void inserirFim(Character item) { 
        No novo = new No(item);
        if(vazia()) {
            inicio = novo;
            fim = novo;
            novo.anterior = null;
            novo.proximo = null;
        }
        else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
            fim.proximo = null;
        }
        quantos++;
    }
    
    // insere item na 'posisao' da lista
    // 'posicao' análoga ao índice dos arrays
    // posição válida: posicao >= 0 && <= tamanho
    public StatusLista inserir(Character item, int posicao) { 
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
            while(p < posicao) {
                aux = aux.proximo;
                p++;
            }
                        
            novo.proximo = aux.proximo;
            novo.anterior = aux;
            aux.proximo.anterior = novo;
            aux.proximo = novo;
            quantos++;
        }
        return StatusLista.SUCESSO;
    }
    
    // remove item no início da lista
    // retorna null se lista vazia
    public Character removerInicio() { 
        if(vazia())
            return null;
        
        Character chRemovido = obterInicio();
        inicio = inicio.proximo;
        quantos--;
        return chRemovido;
    }
    
    // remove item no final da lista
    // retorna null se lista vazia
    public Character removerFim() {
        if(vazia())
            return null;
        
        Character chRemovido = obterFim();
        fim = fim.anterior;
        quantos--;
        if(vazia())
            inicio = null;
        else 
            fim.proximo = null;
        
        return chRemovido;
    }
    
    // remove item na 'posicao' da lista
    // retorna null se posicao inválida
    public Character remover(int posicao) { 
        if(posicao < 0 || posicao > tamanho()-1)
            return null;
        
        if(posicao == 0)
            return removerInicio();
        if(posicao == tamanho()-1)
            return removerFim();
        
        No aux = inicio.proximo;
        int p = 1;
        while(aux != null && p != posicao) {
            aux = aux.proximo;
            p++;
        }
        Character chRemovido = obter(p);
        aux.anterior.proximo = aux.proximo;
        aux.proximo.anterior = aux.anterior;
        quantos--;
        return chRemovido;
    }
    
    // retorna, sem remover, o item no início da lista
    // null se lista vazia
    public Character obterInicio() { 
        return (vazia()) ? null : inicio.item;
    }
    
    // retorna, sem remover, o item no fim da lista
    // null se lista vazia
    public Character obterFim() { 
        return (vazia()) ? null : fim.item;
    }
    
    // retorna, sem remover, o item na posição indicada 
    // null se for posição inválida
    public Character obter(int posicao) { 
        if(vazia() || posicao < 0 || posicao > tamanho())
            return null; 
        
        int indice = 0;
        for(No aux = inicio; aux != null; aux = aux.proximo)
            if(indice == posicao)
                return aux.item;
        
        return null;
    }
    
    // retorna posição do item; 
    // -1 em caso contrário
    public int pesquisar (Character item) {
        if(vazia())
            return -1;
        
        int indice = 0;
        for(No aux = inicio; aux != null; aux = aux.proximo) {
            if(aux.item == item)
                return indice;
            
            indice++;
        }
        return -1;
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
        Lista lista;
        
        while(input.hasNext()) {
            String expressao = input.nextLine();
            lista = new Lista();
            boolean correto = true;
            
            for(int i = 0; i < expressao.length(); i++) {
                if(expressao.charAt(i) == '(') 
                    lista.inserir(expressao.charAt(i), lista.tamanho());
                else if(expressao.charAt(i) == ')') {
                    if(lista.remover(lista.tamanho()-1) == null) {
                        correto = false;
                        break;
                    }
                }
            }
            
            if(!lista.vazia())
                correto = false;
        
            System.out.println(correto ? "correct" : "incorrect");
        }
    }
}