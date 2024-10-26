package br.cefetmg.inf.llp1.lista13;

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
}
