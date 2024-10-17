package br.cefetmg.inf.llp1.lista12.p1042FilaEncadeada;

import br.cefetmg.inf.llp1.lista12.NenhumItemException;
import br.cefetmg.inf.llp1.lista12.FilaAbstrata;

public class FilaEncadeada extends FilaAbstrata {
    class No {
        Object valor;
        No prox;
        
        No(Object v) {
            valor = v;
            prox = null;
        }
    }
    
    private No inicio, fim;

    public FilaEncadeada() {
        inicio = null;
        fim = null;
    }
    
    @Override
    public void enfileirar(Object v) {
        No novo = new No(v);
        
        if (vazia()) {
            fim = novo;
            inicio = novo;
            novo.prox = null;
        }
        else {
            fim.prox = novo;
            fim = novo;
            novo.prox = null;
        }
        
        quantos++;
    }
    
    @Override
    public Object obterPrimeiro() throws NenhumItemException {
        if(vazia())
            throw new NenhumItemException();
        
        return inicio.valor;
    }
    
    @Override
    public Object desenfileirar() throws NenhumItemException {
        if(vazia()) 
            throw new NenhumItemException();
      
        Object valorRemovido = obterPrimeiro();
        inicio = inicio.prox;
        quantos--;
        return valorRemovido;
    }
}