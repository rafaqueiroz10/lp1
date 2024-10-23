package br.cefetmg.inf.llp1.lista13.p1068PilhaEncadeada;

import br.cefetmg.inf.llp1.lista13.PilhaAbstrata;
import br.cefetmg.inf.llp1.lista13.NenhumItemException;

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
        try {
            Object item = getTopo();
            topo = topo.proximo;
            quantos--;
            
            return item;
        }
        catch(NenhumItemException e) {
            throw new NenhumItemException();
        }
    }
    
    @Override
    public Object getTopo() throws NenhumItemException {
        if(vazia()) 
            throw new NenhumItemException();
        
        return topo.item;
    }
}