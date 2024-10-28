/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.inf.llp1.lista14.ClassesAbstratas;

import br.cefetmg.inf.llp1.lista14.Interfaces.Lista;

public abstract class ListaAbstrata<T> implements Lista<T> {
    protected int quantos;
    
    public ListaAbstrata() {
        quantos = 0;
    }
    
    @Override
    public boolean vazia() {
        return quantos == 0;
    }
    
    @Override
    public int tamanho() {
        return quantos;
    }
}