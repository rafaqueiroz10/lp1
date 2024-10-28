package br.cefetmg.inf.llp1.lista14.Interfaces;

import br.cefetmg.inf.llp1.lista14.Excecoes.NenhumItemException;

public interface Fila<T> {
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
