package br.cefetmg.inf.llp1.lista14.Lista;

import br.cefetmg.inf.llp1.lista14.ClassesAbstratas.ListaAbstrata;
import br.cefetmg.inf.llp1.lista14.Excecoes.NenhumItemException;
import br.cefetmg.inf.llp1.lista14.Excecoes.PosicaoInvalidaException;
import br.cefetmg.inf.llp1.lista14.Interfaces.Lista;

public class ListaDuplamenteEncadeada<T> extends ListaAbstrata<T> {
    class No {
        T item;
        No proximo, anterior;
        
        public No() {
            this(null, null, null);
        }
        
        public No(T item) {
            this(item, null, null);
        }
        
        public No(T item, No proximo, No anterior) {
            this.item = item;
            this.proximo = proximo;
            this.anterior = anterior;
        }
    }
    
    private int quantos;
    private No inicio, fim;
    
    public ListaDuplamenteEncadeada() {
        this(null, null);
    }
    
    public ListaDuplamenteEncadeada(No inicio, No fim) {
        this.inicio = inicio;
        this.fim = fim;
    }
    
    // insere item no início da lista
    public void inserirInicio(T item) { 
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
    public void inserirFim(T item) { 
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
    public void inserir(T item, int posicao) throws PosicaoInvalidaException { 
        if (posicao < 0 || posicao > tamanho())
            throw new PosicaoInvalidaException("Erro: posição inválida!!");
        
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
    public T removerInicio() throws NenhumItemException {
        try {
            T item = obterInicio();
            inicio = inicio.proximo;
            quantos--;
            
            return item;   
        }
        catch(NenhumItemException e) {
            throw new NenhumItemException("Erro: lista vazia!!");
        }
    }
    
    // remove item no final da lista
    // retorna null se lista vazia
    public T removerFim() throws NenhumItemException {
        try {
            T item = obterFim();
            fim = fim.anterior;
            quantos--;
            if(vazia())
                inicio = null;
            else 
                fim.proximo = null;
        
            return item;
        }
        catch(NenhumItemException e) {
            throw new NenhumItemException("Erro: lista vazia!!");
        }
    }
    
    // remove item na 'posicao' da lista
    // retorna null se posicao inválida
    public T remover(int posicao) throws NenhumItemException, PosicaoInvalidaException { 
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
            T item = obter(p);
            aux.anterior.proximo = aux.proximo;
            aux.proximo.anterior = aux.anterior;
            quantos--;
            return item;
        }
        catch(PosicaoInvalidaException e) {
            throw new PosicaoInvalidaException("Erro: posição inválida!!");
        }
        catch(NenhumItemException e) {
            throw new NenhumItemException("Erro: lista vazia!!");
        }
    }
    
    // retorna, sem remover, o item no início da lista
    // null se lista vazia
    public T obterInicio() throws NenhumItemException {
        if(vazia())
            throw new NenhumItemException("Erro: lista vazia!!");
        
        return inicio.item;
    }
    
    // retorna, sem remover, o item no fim da lista
    // null se lista vazia
    public T obterFim() throws NenhumItemException { 
        if(vazia())
            throw new NenhumItemException("Erro: lista vazia!!");
        
        return fim.item;
    }
    
    // retorna, sem remover, o item na posição indicada 
    // null se for posição inválida
    public T obter(int posicao) throws NenhumItemException, PosicaoInvalidaException { 
        if(vazia())
            throw new NenhumItemException("Erro: lista vazia!!");
        if(posicao < 0 || posicao > tamanho())
            throw new PosicaoInvalidaException("Erro: posição inválida!!");
        
        int indice = 0;
        for(No aux = inicio; aux != null; aux = aux.proximo, indice++)
            if(indice == posicao)
                return aux.item;
        
        return null;
    }
    
    // retorna posição do item; 
    // -1 em caso contrário
    public int pesquisar (T item) throws NenhumItemException {
        if(vazia())
            throw new NenhumItemException("Erro: lista vazia!!");
        
        int indice = 0;
        for(No aux = inicio; aux != null; aux = aux.proximo) {
            if(aux.item == item)
                return indice;
            
            indice++;
        }
        return -1;
    }
    
    private void troca(No a, No b) {
        T aux = a.item;
        a.item = b.item;
        b.item = aux;
    }

    public Lista<T> ordenar() throws NenhumItemException {
        if(vazia())
            throw new NenhumItemException("Erro: lista vazia!!");
        
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