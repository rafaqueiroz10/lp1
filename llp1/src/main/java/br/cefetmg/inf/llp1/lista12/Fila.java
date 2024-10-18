package br.cefetmg.inf.llp1.lista12;

public interface Fila {
    // remove o primeiro item da fila;
    // retorna o item removido
    public Object desenfileirar() throws NenhumItemException;
    
    // retorna o primeiro item da fila, sem removê-lo;
    public Object obterPrimeiro() throws NenhumItemException;
    
    // função para enfileirar um item
    public void enfileirar(Object item);
    
    // função que retorna o tamanho da fila
    public int tamanho();
    
    // verifica se a fila está vazia;
    // true: se vazia; caso contrário, false;
    public boolean vazia();
}