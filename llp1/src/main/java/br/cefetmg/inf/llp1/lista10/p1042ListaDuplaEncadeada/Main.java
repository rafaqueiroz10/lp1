package br.cefetmg.inf.llp1.lista10.p1042ListaDuplaEncadeada;

import java.util.Scanner;

enum StatusLista {SUCESSO, POSICAOINVALIDA};

class Lista {
    class No {
        Integer item;
        No proximo, anterior;
        
        public No() {
            this(null, null, null);
        }
        
        public No(Integer item) {
            this(item, null, null);
        }
        
        public No(Integer item, No proximo, No anterior) {
            this.item = item;
            this.proximo = proximo;
            this.anterior = anterior;
        }
    }
    
    private int quantos;
    No inicio, fim;
    
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
        return (tamanho() == 0); 
    }
    
    // insere item no início da lista
    public void inserirInicio(Integer item) { 
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
    public void inserirFim(Integer item) { 
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
            No aux = inicio.proximo;
            while(p < posicao && aux != null && aux != fim) {
                p++;
                aux = aux.proximo;
            }
                        
            novo.proximo = aux.proximo;
            novo.anterior = aux;
            aux.proximo.anterior = novo;
            aux.proximo = novo;
        }
        return StatusLista.SUCESSO;
    }
    
    // remove item no início da lista
    // retorna null se lista vazia
    public Integer removerInicio() { 
        if(vazia())
            return null;
        
        Integer valorRemovido = obterInicio();
        inicio = inicio.proximo;
        quantos--;
        return valorRemovido;
    }
    
    // remove item no final da lista
    // retorna null se lista vazia
    public Integer removerFim() {
        if(vazia())
            return null;
        
        Integer valorRemovido = obterFim();
        fim = fim.anterior;
        quantos--;
        if(vazia())
            inicio = null;
        else 
            fim.proximo = null;
        
        return valorRemovido;
    }
    
    // remove item na 'posicao' da lista
    // retorna null se posicao inválida
    public Integer remover(int posicao) { 
        if(posicao < 0 || posicao > tamanho())
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
        Integer valorRemovido = obter(p);
        aux.anterior.proximo = aux.proximo;
        aux.proximo.anterior = aux.anterior;
        quantos--;
        return valorRemovido;
    }
    
    // retorna, sem remover, o item no início da lista
    // null se lista vazia
    public Integer obterInicio() { 
        return (vazia()) ? null : inicio.item;
    }
    
    // retorna, sem remover, o item no fim da lista
    // null se lista vazia
    public Integer obterFim() { 
        return (vazia()) ? null : fim.item;
    }
    
    // retorna, sem remover, o item na posição indicada 
    // null se for posição inválida
    public Integer obter(int posicao) { 
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
    public int pesquisar (Integer item) {
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