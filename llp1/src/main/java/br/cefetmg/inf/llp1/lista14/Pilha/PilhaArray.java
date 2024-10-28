package br.cefetmg.inf.llp1.lista14.Pilha;

import br.cefetmg.inf.llp1.lista14.ClassesAbstratas.PilhaAbstrata;
import br.cefetmg.inf.llp1.lista14.Excecoes.NenhumItemException;

public class PilhaArray<T> extends PilhaAbstrata<T> {
    private int topo, capacidade;
    private T itens[];
    
    public PilhaArray(int tam) {
        capacidade = tam;
        topo = -1;
        itens = (T[]) new Object[capacidade];
    }
    
    private void redimensionar() {
        T novoItens[] = (T[])new Object[capacidade * 2];
        System.arraycopy(itens, 0, novoItens, 0, capacidade);
        capacidade *= 2;
        itens = novoItens;
    }
    
    @Override
    public void empilhar(T item) {
        if(topo == capacidade-1)
            redimensionar();
        
        topo++;
        itens[topo] = item;
        quantos++;
    }
    
    @Override
    public T desempilhar() throws NenhumItemException {
        if(vazia())
            throw new NenhumItemException();
        
        T itemRemover = itens[topo--];
        quantos--;
        return itemRemover;
    }
    
    @Override
    public T getTopo() throws NenhumItemException {
        if(vazia())
            throw new NenhumItemException();
        
        return itens[topo];
    }
}