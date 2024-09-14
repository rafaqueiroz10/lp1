package br.cefetmg.inf.llp1.lista11.p1068a;

public interface Pilha {
    public int tamanho();
    public boolean vazia();
    public void empilhar(Object valor);
    public Object desempilhar();
    public Object getTopo();
}