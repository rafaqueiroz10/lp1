package br.cefetmg.inf.llp1.lista15.p1042Deque;

interface Fila<T> {
    // remove o primeiro item da fila;
    // retorna o item removido
    public T desenfileirar() throws NenhumItemException;
    
    // retorna o primeiro item da fila, sem removê-lo;
    public T obterPrimeiro() throws NenhumItemException;
    
    // função para enfileirar um item
    public void enfileirar(T item);
    
    // função que retorna o tamanho da fila
    public int tamanho();
    
    // verifica se a fila está vazia;
    // true: se vazia; caso contrário, false;
    public boolean vazia();
}

class NenhumItemException extends Exception {
    public NenhumItemException(String mensagem) {
        super(mensagem);
    }
    public NenhumItemException() {
        super();
    }
}

abstract class FilaAbstrata<T> implements Fila<T> {
    protected int quantos;
    
    public FilaAbstrata() {
        quantos = 0;
    }
    
    @Override
    public int tamanho() {
        return quantos;
    }
    
    @Override
    public boolean vazia() {
        return tamanho() == 0;
    }
}

/*class Deque<T> extends FilaAbstrata<T> {
    int inicio, fim, capacidade;
    T itens[];
    
    Deque(int numItens) {
        itens = (T[]) new Object[numItens];
        inicio = -1;
        fim = -1;
        capacidade = numItens;
    }
    
    public boolean cheia() {
        return ((fim + 1) % tamanho() == inicio);
    }
    
    public void inserirInicio(T item) {
        if(cheia())
            capacidade *= 2;
    }
        
    public void inserirFim(T item) {
        
    }
    
    public T removerInicio(T item) throws NenhumItemException {
        if(vazia())
            throw new NenhumItemException();
        
        T item = obterInicio();
    }
    
    public T removerFim(T item) throws NenhumItemException {
        if(vazia())
            throw new NenhumItemException();
        
        T item = obterFim();
    }
    
    public T obterInicio() throws NenhumItemException {
        if(vazia())
            throw new NenhumItemException();
        
        return itens[inicio];
    }
    
    public T obterFim(T item) throws NenhumItemException {
        if(vazia())
            throw new NenhumItemException();
        
        return itens[fim];  
    }
}

public class Main {
    public static void main(String[] args) {
        Fila<Integer> deque = new Deque<>(1);
        deque.
    }
}*/