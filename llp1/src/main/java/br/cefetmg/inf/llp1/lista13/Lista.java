package br.cefetmg.inf.llp1.lista13;

public interface Lista {
    // retorna o tamanho da lista
    public int tamanho();
    
    // verifica se a lista está vazia;
    // true: se vazia; caso contrário, false;
    public boolean vazia();
    
    // insere um item no inicio da lista
    public void inserirInicio(Object item);
    
    // insere um item no fim da lista
    public void inserirFim(Object item);
    
    // insere um item na lista, de acordo
    // com uma determinada posição
    public void inserir(Object item, int posicao) 
            throws PosicaoInvalidaException;
    
    // remove um item no inicio da lista;
    // retorna o item removido
    public Object removerInicio() throws NenhumItemException;
    
    // remove um item no fim da lista;
    // retorna o item removido
    public Object removerFim() throws NenhumItemException;
    
    // remove um item no meio da lista,
    // de acordo com uma determinada posição;
    // retorna o item removido
    public Object remover(int posicao) 
            throws PosicaoInvalidaException, NenhumItemException;
    
    // obtem um item no início da lista;
    // retorna o item obtido
    public Object obterInicio() throws NenhumItemException;
    
    //  obtem um item no fim da lista;
    // retorna o item obtido
    public Object obterFim() throws NenhumItemException;
    
    // obtem um item da lista,
    // dada uma posição;
    // retorna o item obtido
    public Object obter(int posicao) 
            throws NenhumItemException, PosicaoInvalidaException;
    
    //  obtem a posição de um item da lista
    // retorna a posição do item
    public int pesquisar (Integer item) throws NenhumItemException;
}