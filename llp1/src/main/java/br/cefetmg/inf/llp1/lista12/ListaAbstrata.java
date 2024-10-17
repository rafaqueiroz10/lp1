package br.cefetmg.inf.llp1.lista12;

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
