package br.cefetmg.inf.llp1.lista10.p1042ArrayList;

import java.util.Scanner;

enum StatusLista {SUCESSO, POSICAOINVALIDA};

class ArrayList {
    private Integer itens[];
    private int quantos, capacidade;
    
    ArrayList(int tamInicial) {
        itens = new Integer[tamInicial];
        capacidade = tamInicial;
        quantos = 0;
    }
    // número de itens na lista
    public int tamanho() { 
        return quantos;
    }
    
    // true se lista não possuir itens;
    // false em caso contrário
    public boolean vazia() { 
        return tamanho() == 0; 
    }
    
    public boolean cheia() {
        return quantos == capacidade;
    }
    
    private void redimensionar() {
        capacidade *= 2;
        Integer aux[] = new Integer[capacidade];
        for(int i = 0; i < tamanho(); i++)
            aux[i] = itens[i];
        
        itens = aux;
    }
    
    // insere item no início da lista
    public void inserirInicio(Integer item) { 
        quantos++;
        if(cheia())
            redimensionar();
        
        for(int i = 1; i < tamanho(); i++) 
            itens[i] = itens[i-1];

        itens[0] = item;
    }
    
    // insere item no final da lista
    public void inserirFim(Integer item) { 
        if(cheia())
            redimensionar();

        itens[tamanho()] = item;
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
            if(cheia())
                redimensionar();
            
            for(int i = posicao; i < tamanho()-1; i++) 
                itens[i+1] = itens[i];
            
            itens[posicao] = item;
            quantos++;
        }
        return StatusLista.SUCESSO;
    }
    
    // remove item no início da lista
    // retorna null se lista vazia
    public Integer removerInicio() {
        if(vazia())
            return null;
        
        Integer valorRemovido = itens[0];
        for(int i = 1; i < tamanho(); i++) {
            itens[i-1] = itens[i];
        }
        quantos--; 
        return valorRemovido;
    }
    
    // remove item no final da lista
    // retorna null se lista vazia
    public Integer removerFim() {
        if(vazia())
            return null;
        
        Integer valorRemovido = itens[tamanho()-1];
        quantos--;
        return valorRemovido; 
    }
    
    // remove item na 'posicao' da lista
    // retorna null se posicao inválida
    public Integer remover(int posicao) {
        if(posicao < 0 || posicao > tamanho()-1)
            return null;
        
        if(posicao == 0)
            return removerInicio();
        
        if(posicao == tamanho()-1)
            return removerFim();
        
        Integer valorRemovido = obter(posicao);
        for(int i = posicao+1; i < tamanho(); i++)
            itens[i-1] = itens[i];
        
        quantos--;
        return valorRemovido;
    }
    
    // retorna, sem remover, o item no início da lista
    // null se lista vazia
    public Integer obterInicio() {
        return (vazia()) ? null : itens[0]; 
    }
    
    // retorna, sem remover, o item no fim da lista
    // null se lista vazia
    public Integer obterFim() { 
        return (vazia()) ? null : itens[tamanho()-1]; 
    }
    
    // retorna, sem remover, o item na posição indicada 
    // null se for posição inválida
    public Integer obter(int posicao) { 
        if(vazia() || posicao > tamanho() || posicao < 0)
            return null;
        
        return itens[posicao];
    }
    
    // retorna posição do item; 
    // -1 em caso contrário
    public int pesquisar (Integer item) {
        for(int i = 0; i < tamanho(); i++)
            if(itens[i] == item)
                return i;
        
        return -1;
    }
    
    private void troca(int i, int j) {
        Integer aux = itens[i];
        itens[i] = itens[j];
        itens[j] = aux;
    }
    
    public void ordenar() {
        if(vazia())
            return;
        
        for(int i = 0; i < tamanho(); i++)
            for(int j = i + 1; j < tamanho(); j++)
                if(itens[i] > itens[j])
                    troca(i, j);
        
    }
    
    public void exibir() {
        if(vazia())
            return;
        
        for(int i = 0; i < tamanho(); i++)
            System.out.println(itens[i]);
        
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        ArrayList list = new ArrayList(1);
        list.inserir(a, 0);
        list.inserir(b, 1);
        list.inserir(c, 2);
        ArrayList list2 = new ArrayList(1);
        list2.inserir(a, 0);
        list2.inserir(b, 1);
        list2.inserir(c, 2);
        list.ordenar();
        list.exibir();
        System.out.println();
        list2.exibir();
    }
}