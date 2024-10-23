/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.inf.llp1.lista13.p1042ListaEncadeada;

import br.cefetmg.inf.llp1.lista13.ListaEncadeada;
import br.cefetmg.inf.llp1.lista13.NenhumItemException;
import br.cefetmg.inf.llp1.lista13.PosicaoInvalidaException;

public class ExibirLista {
    public static void exibir(ListaEncadeada lista) 
        throws NenhumItemException, PosicaoInvalidaException {
        try {
            int posicao = 0;
            while(true) {
                System.out.println(lista.obter(posicao));
                posicao++;
            }
        }
        catch(PosicaoInvalidaException e) {
            throw new PosicaoInvalidaException("Fim da lista!!");
        }
        catch(NenhumItemException e) {
            throw new NenhumItemException("Erro: lista vazia!!");
        }
    }
}