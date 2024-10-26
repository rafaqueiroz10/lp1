/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.inf.llp1.lista13.p1068ListaDuplaEncadeada;

import br.cefetmg.inf.llp1.lista13.Lista;
import br.cefetmg.inf.llp1.lista13.ListaEncadeada;
import br.cefetmg.inf.llp1.lista13.NenhumItemException;
import br.cefetmg.inf.llp1.lista13.PosicaoInvalidaException;

public class ValidaParenteses {
    public static boolean validar(String expressao) {
        Lista lista = new ListaEncadeada();

        for(int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);
            if(caractere == '(') {
                try {
                    lista.inserir(caractere, lista.tamanho());
                }
                catch(PosicaoInvalidaException e) {}
            }
            else if(caractere == ')') {
                try {
                    lista.remover(lista.tamanho()-1);
                }
                catch(PosicaoInvalidaException e) {}
                catch(NenhumItemException e) {
                    return true;
                }
            }   
        }
           
        return false;
    }
}