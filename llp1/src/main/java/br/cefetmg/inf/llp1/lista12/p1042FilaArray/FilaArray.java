package br.cefetmg.inf.llp1.lista12.p1042FilaArray;

import br.cefetmg.inf.llp1.lista12.NenhumItemException;
import br.cefetmg.inf.llp1.lista12.FilaAbstrata;

public class FilaArray extends FilaAbstrata {
    private int inicio, ultimo;
    private Object valores[];
    private int capacidade;
    
    public FilaArray(int n) {
        inicio = -1;
        ultimo = -1;
        capacidade = n;
        valores = new Object[capacidade];
    }
    
    private boolean cheia() {
        return tamanho() == capacidade;
    }
    
    @Override
    public Object obterPrimeiro() throws NenhumItemException {
        if(vazia()) 
            throw new NenhumItemException();
        
        return valores[inicio];
    }
    
    @Override
    public void enfileirar(Object valor) {
        if(cheia()) {
            capacidade *= 2;
            Object novoValores[] = new Object[capacidade];
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
    public Object desenfileirar() throws NenhumItemException {
        if(vazia()) 
            throw new NenhumItemException();
 
        Object valor = obterPrimeiro();
        for (int i = inicio+1; i < ultimo+1; i++) 
            valores[i-1] = valores[i];

        ultimo--;
        quantos--;
        
        return valor;
    }
}