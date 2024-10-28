/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.inf.llp1.lista14.Fila;

import br.cefetmg.inf.llp1.lista14.ClassesAbstratas.FilaAbstrata;
import br.cefetmg.inf.llp1.lista14.Excecoes.NenhumItemException;

public class FilaEncadeada<T> extends FilaAbstrata<T> {
    class No {
        T valor;
        No prox;
        
        No(T v) {
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
    public void enfileirar(T v) {
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
    public T obterPrimeiro() throws NenhumItemException {
        if(vazia())
            throw new NenhumItemException();
        
        return inicio.valor;
    }
    
    @Override
    public T desenfileirar() throws NenhumItemException {
        try {
            T valorRemovido = obterPrimeiro();
            inicio = inicio.prox;
            quantos--;
            
            return valorRemovido;
        }
        catch(NenhumItemException e) {
            throw new NenhumItemException();
        }
    }
}
