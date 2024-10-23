package br.cefetmg.inf.llp1.lista13;

public class ListaDuplamenteEncadeada {
    class No {
        Object item;
        No proximo, anterior;
        
        public No() {
            this(null, null, null);
        }
        
        public No(Object item) {
            this(item, null, null);
        }
        
        public No(Object item, No proximo, No anterior) {
            this.item = item;
            this.proximo = proximo;
            this.anterior = anterior;
        }
    }
    
    private int quantos;
    private No inicio, fim;
    
    public ListaDuplamenteEncadeada() {
        this(null, null, 0);
    }
    
    public ListaDuplamenteEncadeada(No inicio, No fim, int quantos) {
        this.inicio = inicio;
        this.fim = fim;
        this.quantos = quantos;
    }
    
    // número de itens na lista
    public int tamanho() { 
        return quantos;
    }
    
    // true se lista não possuir itens;
    // false em caso contrário
    public boolean vazia() { 
        return (tamanho() == 0); 
    }
    
    // insere item no início da lista
    public void inserirInicio(Object item) { 
        No novo = new No(item);
        if(vazia()) {
            inicio = novo;
            fim = novo;
            novo.anterior = null;
            novo.proximo = null;
        }
        else {
            novo.proximo = inicio;
            inicio.anterior = novo;
            novo.anterior = null;
            inicio = novo;
        }
        quantos++;
    }
    
    // insere item no final da lista
    public void inserirFim(Object item) { 
        No novo = new No(item);
        if(vazia()) {
            inicio = novo;
            fim = novo;
            novo.anterior = null;
            novo.proximo = null;
        }
        else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
            fim.proximo = null;
        }
        quantos++;
    }
    
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
            while(p < posicao) {
                aux = aux.proximo;
                p++;
            }
                        
            novo.proximo = aux.proximo;
            novo.anterior = aux;
            aux.proximo.anterior = novo;
            aux.proximo = novo;
            quantos++;
        }
    }
    
    // remove item no início da lista
    // retorna null se lista vazia
    public Object removerInicio() throws NenhumItemException {
        try {
            Object item = obterInicio();
            inicio = inicio.proximo;
            quantos--;
            
            return item;   
        }
        catch(NenhumItemException e) {
            throw new NenhumItemException();
        }
    }
    
    // remove item no final da lista
    // retorna null se lista vazia
    public Object removerFim() throws NenhumItemException {
        try {
            Object item = obterFim();
            fim = fim.anterior;
            quantos--;
            if(vazia())
                inicio = null;
            else 
                fim.proximo = null;
        
            return item;
        }
        catch(NenhumItemException e) {
            throw new NenhumItemException();
        }
    }
    
    // remove item na 'posicao' da lista
    // retorna null se posicao inválida
    public Object remover(int posicao) throws NenhumItemException, PosicaoInvalidaException { 
        try {
            if(posicao == 0)
                return removerInicio();
            if(posicao == tamanho()-1)
                return removerFim();
        
            No aux = inicio.proximo;
            int p = 1;
            while(aux != null && p != posicao) {
                aux = aux.proximo;
                p++;
            }
            Object item = obter(p);
            aux.anterior.proximo = aux.proximo;
            aux.proximo.anterior = aux.anterior;
            quantos--;
            return item;
        }
        catch(PosicaoInvalidaException e) {
            throw new PosicaoInvalidaException();
        }
        catch(NenhumItemException e) {
            throw new NenhumItemException();
        }
    }
    
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
        if(vazia())
            throw new NenhumItemException();
        
        return fim.item;
    }
    
    // retorna, sem remover, o item na posição indicada 
    // null se for posição inválida
    public Object obter(int posicao) throws NenhumItemException, PosicaoInvalidaException { 
        if(vazia())
            throw new NenhumItemException();
        if(posicao < 0 || posicao > tamanho())
            throw new PosicaoInvalidaException();
        
        int indice = 0;
        for(No aux = inicio; aux != null; aux = aux.proximo)
            if(indice == posicao)
                return aux.item;
        
        return null;
    }
    
    // retorna posição do item; 
    // -1 em caso contrário
    public int pesquisar (Object item) throws NenhumItemException {
        if(vazia())
            throw new NenhumItemException();
        
        int indice = 0;
        for(No aux = inicio; aux != null; aux = aux.proximo) {
            if(aux.item == item)
                return indice;
            
            indice++;
        }
        return -1;
    }
    
    private void troca(No a, No b) {
        Object aux = a.item;
        a.item = b.item;
        b.item = aux;
    }

    public ListaDuplamenteEncadeada ordenar() throws NenhumItemException {
        if(vazia())
            throw new NenhumItemException();
        
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        
        for(No i = inicio; i != null; i = i.proximo)
            lista.inserirInicio(i.item);
        
        for(No aux = lista.inicio; aux != null; aux = aux.proximo) 
            for(No aux2 = aux.proximo; aux2 != null; aux2 = aux2.proximo) 
                if((Integer)aux.item > (Integer)aux2.item) 
                    troca(aux, aux2);
        
        return lista;
    }

}
