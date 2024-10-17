package br.cefetmg.inf.llp1.lista12;

public abstract class PilhaAbstrata implements Pilha {
    protected int quantos;
   
    public PilhaAbstrata() {
        quantos = 0;
    }
    
    @Override
    public int tamanho() {
        return quantos;
    }
    
    @Override
    public boolean vazia() {
        return (tamanho() == 0);
    }
    
    @Override
    public abstract Object desempilhar() throws NenhumItemException;
    
    @Override
    public abstract Object getTopo() throws NenhumItemException;
    
    @Override
    public abstract void empilhar(Object valor);
}
