package br.cefetmg.inf.llp1.lista12;

public interface Fila {
    public Object desenfileirar() throws NenhumItemException;
    public Object obterPrimeiro() throws NenhumItemException;
    public void enfileirar(Object item);
    public int tamanho();
    public boolean vazia();
}