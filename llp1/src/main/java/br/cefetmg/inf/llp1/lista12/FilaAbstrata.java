/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.inf.llp1.lista12;

import br.cefetmg.inf.llp1.lista12.Fila;

public abstract class FilaAbstrata implements Fila {
    protected int quantos;
    
    public FilaAbstrata() {
        quantos = 0;
    }
    
    @Override
    public int tamanho() {
        return quantos;
    }
    
    @Override
    public boolean vazia() {
        return tamanho() == 0;
    }
    
    @Override
    public abstract void enfileirar(Object item);
    
    @Override
    public abstract Object desenfileirar() throws NenhumItemException;
    
    @Override
    public abstract Object obterPrimeiro() throws NenhumItemException;
}