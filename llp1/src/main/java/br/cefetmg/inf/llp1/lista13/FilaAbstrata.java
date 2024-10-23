package br.cefetmg.inf.llp1.lista13;

public abstract class FilaAbstrata implements Fila {
    protected int quantos;
    
    public FilaAbstrata() {
        quantos = 0;
    }
    
    @Override
    public int tamanho() {
        return quantos;
    }
    
    @Override
    public boolean vazia() {
        return tamanho() == 0;
    }
}