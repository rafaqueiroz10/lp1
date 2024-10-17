package br.cefetmg.inf.llp1.lista12;

public class ListaEncadeada extends ListaAbstrata {
    class No {
        Object item;
        No proximo;
        
        public No() {
            this(null, null);
        }
        
        public No(Object item) {
            this(item, null);
        }
        
        public No(Object item, No proximo) {
            this.item = item;
            this.proximo = proximo;
        }
    }
    
    private No inicio, fim;
    
    public ListaEncadeada() {
        inicio = null;
        fim = null;
    }
    
    @Override
    // insere item no início da lista
    public void inserirInicio(Object item) {
        No novo = new No(item);
        
        if (vazia()) {
            fim = novo;
            inicio = novo;
            novo.proximo = null;
        }
        else {
            novo.proximo = inicio;
            inicio = novo;
        }
        quantos++;
    }
    
    @Override
    // insere item no final da lista
    public void inserirFim(Object item) {
        No novo = new No(item);
        
        if (vazia()) {
            fim = novo;
            inicio = novo;
            novo.proximo = null;
        }
        else {
            fim.proximo = novo;
            fim = novo;
            fim.proximo = null;
        }
        
        quantos++;
    }
    
    @Override
    // insere item na 'posisao' da lista
    // 'posicao' análoga ao índice dos arrays
    // posição válida: posicao >= 0 && <= tamanho
    public void inserir(Object item, int posicao) throws PosicaoInvalidaException { 
        if (posicao < 0 || posicao > tamanho())
            throw new PosicaoInvalidaException();

        if(posicao == 0)
            inserirInicio(item);
        else if(posicao == tamanho())
            inserirFim(item);
        else {
            int p = 1;
            No novo = new No(item);
            No aux = inicio;
           
            for (int i = 0; i < posicao - 1; i++) {
                aux = aux.proximo;
            }
            
            novo.proximo = aux.proximo;
            aux.proximo = novo;
            quantos++;
        }
    }
    
    @Override
    // remove item no início da lista
    // retorna null se lista vazia
    public Object removerInicio() throws PosicaoInvalidaException { 
        if(vazia())
            throw new PosicaoInvalidaException();
        
        Object valorRemovido = inicio.item;
        inicio = inicio.proximo;
        quantos--;
        return valorRemovido;
    }
    
    @Override
    // remove item no final da lista
    // retorna null se lista vazia
    public Object removerFim() throws PosicaoInvalidaException {
        if(vazia())
            throw new PosicaoInvalidaException();
        
        Object valorRemovido = fim.item;
        
        if(inicio == fim) {
            inicio = null;
            fim = null;
        }
        else {
            No aux = inicio;
            while(aux.proximo != fim) {
                aux = aux.proximo;
            } 
            aux.proximo = null;
            fim = aux;
        }
        quantos--;
        return valorRemovido;
    }
    
    @Override
    // remove item na 'posicao' da lista
    // retorna null se posicao inválida
    public Object remover(int posicao) throws PosicaoInvalidaException, NenhumItemException {
        if(vazia() || posicao < 0 || posicao > tamanho()-1)
            throw new PosicaoInvalidaException();
        
        if(posicao == 0)
            return removerInicio();
        if(posicao == tamanho()-1)
            return removerFim();
        
        Object valorRemovido = obter(posicao);
        No aux = inicio;
        for (int i = 0; i < posicao - 1; i++) {
            aux = aux.proximo;
        }
        No proximo = aux.proximo;
        aux.proximo = proximo.proximo;
        quantos--;
        
        return valorRemovido;
    }
    
    @Override
    // retorna, sem remover, o item no início da lista
    // null se lista vazia
    public Object obterInicio() throws NenhumItemException {
        if(vazia())
            throw new NenhumItemException();
        
        return inicio.item;
    }
    
    // retorna, sem remover, o item no fim da lista
    // null se lista vazia
    public Object obterFim() throws NenhumItemException { 
        if (vazia())
            throw new NenhumItemException();
        
        return fim.item; 
    }
    
    @Override
    // retorna, sem remover, o item na posição indicada 
    // null se for posição inválida
    public Object obter(int posicao) throws NenhumItemException, PosicaoInvalidaException {
        if(vazia()) 
           throw new NenhumItemException();
            
        if(posicao > tamanho()-1 || posicao < 0)
            throw new PosicaoInvalidaException();
        
        int p = 0;
        for(No aux = inicio; aux != null; aux = aux.proximo) {
            if(p == posicao) 
                return aux.item;

            p++;
        }
        return null; 
    }
    
    @Override
    // retorna posição do item; 
    // -1 em caso contrário
    public int pesquisar (Integer item) throws NenhumItemException  {
        if(vazia())
            throw new NenhumItemException();
        
        int posicao = 0;
        for(No aux = inicio; aux != null; aux = aux.proximo) {
            if(aux.item == item)
                return posicao;
            
            posicao++;
        }
        return -1; 
    }
    
    private void troca(No a, No b) {
        Object aux = a.item;
        a.item = b.item;
        b.item = aux;
    }
    
    public ListaEncadeada ordenar() throws NenhumItemException {
        if(vazia())
            throw new NenhumItemException();
        
        ListaEncadeada lista = new ListaEncadeada();
        
        for(No i = inicio; i != null; i = i.proximo)
            lista.inserirInicio(i.item);
        
        for(No aux = lista.inicio; aux != null; aux = aux.proximo) 
            for(No aux2 = aux.proximo; aux2 != null; aux2 = aux2.proximo) 
                if((Integer)aux.item > (Integer)aux2.item) 
                    troca(aux, aux2);
        
        return lista;
    }
}