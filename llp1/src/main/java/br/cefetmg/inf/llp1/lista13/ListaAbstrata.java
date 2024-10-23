package br.cefetmg.inf.llp1.lista13;

public abstract class ListaAbstrata implements Lista {
    protected int quantos;
    
    public ListaAbstrata() {
        quantos = 0;
    }
    
    @Override
    public boolean vazia() {
        return quantos == 0;
    }
    
    @Override
    public int tamanho() {
        return quantos;
    }
}