package br.cefetmg.inf.llp1.lista14.Pilha;

import br.cefetmg.inf.llp1.lista14.ClassesAbstratas.PilhaAbstrata;
import br.cefetmg.inf.llp1.lista14.Excecoes.NenhumItemException;

public class PilhaEncadeada<T> extends PilhaAbstrata<T> {
    class No {
        T item;
        No proximo;
        
        public No() {
            this(null, null);
        }
        
        public No(T item) {
            this(item, null);
        }
        
        public No(T item, No proximo) {
            this.item = item;
            this.proximo = proximo;
        }
    }
    
    private No topo;
    
    public PilhaEncadeada() {
        topo = null;
    }
    
    @Override
    public void empilhar (T item){
        No novo = new No();
        novo.item = item;
        novo.proximo = topo;
        topo = novo;
        quantos++;
    }
    
    @Override
    public T desempilhar() throws NenhumItemException {
        try {
            T item = getTopo();
            topo = topo.proximo;
            quantos--;
            
            return item;
        }
        catch(NenhumItemException e) {
            throw new NenhumItemException();
        }
    }
    
    @Override
    public T getTopo() throws NenhumItemException {
        if(vazia()) 
            throw new NenhumItemException();
        
        return topo.item;
    }
}