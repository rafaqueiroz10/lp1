/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.inf.llp1.lista14.ClassesAbstratas;

import br.cefetmg.inf.llp1.lista14.Interfaces.Pilha;

public abstract class PilhaAbstrata<T> implements Pilha<T> {
    protected int quantos;
   
    public PilhaAbstrata() {
        quantos = 0;
    }
    
    @Override
    public int tamanho() {
        return quantos;
    }
    
    @Override
    public boolean vazia() {
        return (tamanho() == 0);
    }
}