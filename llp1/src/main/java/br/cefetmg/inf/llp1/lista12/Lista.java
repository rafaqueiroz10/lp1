package br.cefetmg.inf.llp1.lista12;

public interface Lista {
    public int tamanho();
    public boolean vazia();
    public void inserirInicio(Object item);
    public void inserirFim(Object item);
    public void inserir(Object item, int posicao) throws PosicaoInvalidaException;
    public Object removerInicio() throws PosicaoInvalidaException;
    public Object removerFim() throws PosicaoInvalidaException;
    public Object remover(int posicao) throws PosicaoInvalidaException, NenhumItemException;
    public Object obterInicio() throws NenhumItemException;
    public Object obterFim() throws NenhumItemException;
    public Object obter(int posicao) throws NenhumItemException, PosicaoInvalidaException;
    public int pesquisar (Integer item) throws NenhumItemException;
    public ListaEncadeada ordenar() throws NenhumItemException;
}
