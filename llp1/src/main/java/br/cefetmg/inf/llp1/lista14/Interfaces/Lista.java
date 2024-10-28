package br.cefetmg.inf.llp1.lista14.Interfaces;

import br.cefetmg.inf.llp1.lista14.Excecoes.NenhumItemException;
import br.cefetmg.inf.llp1.lista14.Excecoes.PosicaoInvalidaException;

public interface Lista<T> {
    // retorna o tamanho da lista
    public int tamanho();
    
    // verifica se a lista está vazia;
    // true: se vazia; caso contrário, false;
    public boolean vazia();
    
    // insere um item no inicio da lista
    public void inserirInicio(T item);
    
    // insere um item no fim da lista
    public void inserirFim(T item);
    
    // insere um item na lista, de acordo
    // com uma determinada posição
    public void inserir(T item, int posicao) 
            throws PosicaoInvalidaException;
    
    // remove um item no inicio da lista;
    // retorna o item removido
    public T removerInicio() throws NenhumItemException;
    
    // remove um item no fim da lista;
    // retorna o item removido
    public T removerFim() throws NenhumItemException;
    
    // remove um item no meio da lista,
    // de acordo com uma determinada posição;
    // retorna o item removido
    public T remover(int posicao) 
            throws PosicaoInvalidaException, NenhumItemException;
    
    // obtem um item no início da lista;
    // retorna o item obtido
    public T obterInicio() throws NenhumItemException;
    
    //  obtem um item no fim da lista;
    // retorna o item obtido
    public T obterFim() throws NenhumItemException;
    
    // obtem um item da lista,
    // dada uma posição;
    // retorna o item obtido
    public T obter(int posicao) 
            throws NenhumItemException, PosicaoInvalidaException;
    
    //  obtem a posição de um item da lista
    // retorna a posição do item
    public int pesquisar (T item) throws NenhumItemException;
    
    // método para ordenar a lista
    public Lista<T> ordenar() throws PosicaoInvalidaException, NenhumItemException;
}
