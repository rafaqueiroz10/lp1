package br.cefetmg.inf.llp1.lista12;

public interface Pilha {
    public int tamanho();
    public boolean vazia();
    public void empilhar(Object valor);
    public Object desempilhar() throws NenhumItemException;
    public Object getTopo() throws NenhumItemException;
}
