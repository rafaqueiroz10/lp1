package br.cefetmg.inf.llp1.lista14.Lista;

import br.cefetmg.inf.llp1.lista14.ClassesAbstratas.ListaAbstrata;
import br.cefetmg.inf.llp1.lista14.Excecoes.NenhumItemException;
import br.cefetmg.inf.llp1.lista14.Excecoes.PosicaoInvalidaException;
import br.cefetmg.inf.llp1.lista14.Interfaces.Lista;

public class ArrayList<T> extends ListaAbstrata<T> {
    private T itens[];
    private int quantos, capacidade;
    
    public ArrayList(int tamInicial) {
        itens = (T[]) new Object[tamInicial];
        capacidade = tamInicial;
    }
    
    public boolean cheia() {
        return quantos == capacidade;
    }
    
    private void redimensionar() {
        capacidade *= 2;
        T aux[] = (T[]) new Object[capacidade];
        for(int i = 0; i < tamanho(); i++)
            aux[i] = itens[i];
        
        itens = aux;
    }
    
    // insere item no início da lista
    public void inserirInicio(T item) { 
        quantos++;
        if(cheia())
            redimensionar();
        
        for(int i = 1; i < tamanho(); i++) 
            itens[i] = itens[i-1];

        itens[0] = item;
    }
    
    // insere item no final da lista
    public void inserirFim(T item) { 
        if(cheia())
            redimensionar();

        itens[tamanho()] = item;
        quantos++;
    }
    
    // insere item na 'posisao' da lista
    // 'posicao' análoga ao índice dos arrays
    // posição válida: posicao >= 0 && <= tamanho
    public void inserir(T item, int posicao) throws PosicaoInvalidaException { 
        if (posicao < 0 || posicao > tamanho())
            throw new PosicaoInvalidaException();
        
        if(posicao == 0)
            inserirInicio(item);
        else if(posicao == tamanho())
            inserirFim(item);
        else {
            if(cheia())
                redimensionar();
            
            for(int i = posicao; i < tamanho()-1; i++) 
                itens[i+1] = itens[i];
            
            itens[posicao] = item;
            quantos++;
        }
    }
    
    // remove item no início da lista
    // retorna null se lista vazia
    public T removerInicio() throws NenhumItemException {
        if(vazia())
            throw new NenhumItemException();
        
        T valorRemovido = itens[0];
        for(int i = 1; i < tamanho(); i++) {
            itens[i-1] = itens[i];
        }
        quantos--; 
        return valorRemovido;
    }
    
    // remove item no final da lista
    // retorna null se lista vazia
    public T removerFim() throws NenhumItemException {
        if(vazia())
            throw new NenhumItemException();
        
        T valorRemovido = itens[tamanho()-1];
        quantos--;
        return valorRemovido; 
    }
    
    // remove item na 'posicao' da lista
    // retorna null se posicao inválida
    public T remover(int posicao) throws PosicaoInvalidaException, NenhumItemException {
        if(posicao < 0 || posicao > tamanho()-1)
            throw new PosicaoInvalidaException();
        
        if(vazia())
            throw new NenhumItemException();
        
        if(posicao == 0) 
            return removerInicio();
       
        if(posicao == tamanho()-1)
            return removerFim();
        
        T valorRemovido = obter(posicao);
        for(int i = posicao+1; i < tamanho(); i++)
            itens[i-1] = itens[i];
        
        quantos--;
        return valorRemovido;
    }
    
    // retorna, sem remover, o item no início da lista
    // null se lista vazia
    public T obterInicio() throws NenhumItemException {
        if(vazia())
            throw new NenhumItemException();
        
        return itens[0]; 
    }
    
    // retorna, sem remover, o item no fim da lista
    // null se lista vazia
    public T obterFim() throws NenhumItemException {
        if(vazia())
            throw new NenhumItemException();
        
        return itens[tamanho()-1]; 
    }
    
    // retorna, sem remover, o item na posição indicada 
    // null se for posição inválida
    public T obter(int posicao) throws NenhumItemException, PosicaoInvalidaException {
        if(vazia())
            throw new NenhumItemException();
        if(posicao > tamanho() || posicao < 0)
            throw new PosicaoInvalidaException();
        
        return itens[posicao];
    }
    
    // retorna posição do item; 
    // -1 em caso contrário
    public int pesquisar (T item) {
        for(int i = 0; i < tamanho(); i++)
            if(itens[i] == item)
                return i;
        
        return -1;
    }
    
    public Lista<T> ordenar() throws PosicaoInvalidaException, NenhumItemException {
        Lista<T> lista = new ArrayList<>(tamanho());
        
        try {
            for(int i = 0; true; i++) {
                lista.inserir(obter(i), i);
            }
        }
        catch(PosicaoInvalidaException e) {}
        catch(NenhumItemException e){}
        
        if(!(lista.obter(0).getClass().equals(Integer.class)))
            return lista;
        
        for(int i = 0; i < lista.tamanho(); i++) {
            for(int j = i+1; j < lista.tamanho(); j++) {
                if((Integer)lista.obter(i) > (Integer)lista.obter(j)) {
                    T aux = lista.obter(i);
                    lista.inserir(lista.obter(j), i);
                    lista.inserir(aux, j);
                }
            }
        } 
        
        return lista;
    }
}