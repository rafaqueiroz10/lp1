package br.cefetmg.inf.llp1.lista14.Interfaces;

import br.cefetmg.inf.llp1.lista14.Excecoes.NenhumItemException;

public interface Pilha<T> {
    // retorna o tamanho da pilha
    public int tamanho();
    
    // verifica se a pilha está vazia
    // se vazia, retorna true;
    // caso contrário, retorna false;
    public boolean vazia();
    
    // empilha um item no topo da pilha;
    public void empilhar(T valor);
    
    // desempilha um item no topo da pilha
    // se vazia, lança uma exceção NenhumItemException;
    // caso contrário, retorna o item desempilhado;
    public T desempilhar() throws NenhumItemException;
    
    // se vazia, lança uma exceção NenhumItemException;
    // caso contrário retorna, sem remover, o elemento no topo da pilha;
    public T getTopo() throws NenhumItemException;
}