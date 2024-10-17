package br.cefetmg.inf.llp1.lista12.p1068PilhaEncadeada;

import br.cefetmg.inf.llp1.lista12.PilhaAbstrata;
import br.cefetmg.inf.llp1.lista12.NenhumItemException;

public class PilhaEncadeada extends PilhaAbstrata {
    class No {
        Object item;
        No proximo;
        
        public No() {
            this(null, null);
        }
        
        public No(Object item) {
            this(item, null);
        }
        
        public No(Object item, No proximo) {
            this.item = item;
            this.proximo = proximo;
        }
    }
    
    private No topo;
    
    public PilhaEncadeada() {
        topo = null;
    }
    
    @Override
    public void empilhar (Object item){
        No novo = new No();
        novo.item = item;
        novo.proximo = topo;
        topo = novo;
        quantos++;
    }
    
    @Override
    public Object desempilhar() throws NenhumItemException {
        if(vazia())
            throw new NenhumItemException();
        
        Object item = topo.item;
        topo = topo.proximo;
        quantos--;
        return item;
    }
    
    @Override
    public Object getTopo() throws NenhumItemException {
        if(vazia()) 
            throw new NenhumItemException();
        
        return topo.item;
    }
}