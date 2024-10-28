package br.cefetmg.inf.llp1.lista14.Fila;

import br.cefetmg.inf.llp1.lista14.ClassesAbstratas.FilaAbstrata;
import br.cefetmg.inf.llp1.lista14.Excecoes.NenhumItemException;

public class FilaArray<T> extends FilaAbstrata<T> {
    private int inicio, ultimo;
    private T valores[];
    private int capacidade;
    
    public FilaArray(int n) {
        inicio = -1;
        ultimo = -1;
        capacidade = n;
        valores = (T[]) new Object[capacidade];
    }
    
    private boolean cheia() {
        return tamanho() == capacidade;
    }
    
    @Override
    public T obterPrimeiro() throws NenhumItemException {
        if(vazia()) 
            throw new NenhumItemException();
        
        return valores[inicio];
    }
    
    @Override
    public void enfileirar(T valor) {
        if(cheia()) {
            capacidade *= 2;
            T novoValores[] = (T[]) new Object[capacidade];
            System.arraycopy(valores, 0, novoValores, 0, valores.length);
            valores = novoValores;
        }
        if (inicio == -1) 
            inicio = 0;
        
        ultimo++;
        valores[ultimo] = valor;
        quantos++;
    }
    
    @Override
    public T desenfileirar() throws NenhumItemException {
        try {
            T valor = obterPrimeiro();
            for (int i = inicio+1; i < ultimo+1; i++) 
                valores[i-1] = valores[i];

            ultimo--;
            quantos--;
            
            return valor;
        }
        catch(NenhumItemException e) {
            throw new NenhumItemException();
        }
    }
}