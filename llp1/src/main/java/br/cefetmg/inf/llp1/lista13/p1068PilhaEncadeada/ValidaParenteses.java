/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.inf.llp1.lista13.p1068PilhaEncadeada;

import br.cefetmg.inf.llp1.lista13.NenhumItemException;
import br.cefetmg.inf.llp1.lista13.Pilha;

/**
 *
 * @author rafav
 */
public class ValidaParenteses {
    public static boolean validar(String expressao) {
        Pilha pilha = new PilhaEncadeada();
        for(int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);
            if(caractere == '(') 
                pilha.empilhar(caractere);
            else if(caractere == ')') {
                try {
                    pilha.desempilhar();
                }
                catch(NenhumItemException e) {
                    return false;
                }
            }
        }
        
        if(!pilha.vazia()) 
            return false;
            
        return true;
    }
}
