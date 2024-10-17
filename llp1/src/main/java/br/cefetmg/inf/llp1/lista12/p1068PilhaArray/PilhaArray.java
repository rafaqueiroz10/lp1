package br.cefetmg.inf.llp1.lista12.p1068PilhaArray;

import br.cefetmg.inf.llp1.lista12.PilhaAbstrata;
import br.cefetmg.inf.llp1.lista12.NenhumItemException;

public class PilhaArray extends PilhaAbstrata {
    private int topo, capacidade;
    private Object itens[];
    
    public PilhaArray(int tam) {
        capacidade = tam;
        topo = -1;
        itens = new Object[capacidade];
    }
    
    private void redimensionar() {
        Object novoItens[] = new Object[capacidade * 2];
        System.arraycopy(itens, 0, novoItens, 0, capacidade);
        capacidade *= 2;
        itens = novoItens;
    }
    
    @Override
    public void empilhar(Object item) {
        if(topo == capacidade-1)
            redimensionar();
        
        topo++;
        itens[topo] = item;
        quantos++;
    }
    
    @Override
    public Object desempilhar() throws NenhumItemException {
        if(vazia())
            throw new NenhumItemException();
        
        Object itemRemover = itens[topo--];
        quantos--;
        return itemRemover;
    }
    
    @Override
    public Object getTopo() throws NenhumItemException {
        if(vazia())
            throw new NenhumItemException();
        
        return itens[topo];
    }
}
