package br.cefetmg.inf.llp1.lista13.p1068ListaEncadeada;

import br.cefetmg.inf.llp1.lista12.Lista;
import br.cefetmg.inf.llp1.lista12.ListaEncadeada;
import br.cefetmg.inf.llp1.lista12.NenhumItemException;
import br.cefetmg.inf.llp1.lista12.PosicaoInvalidaException;

public class ValidaParenteses {
    public static boolean validar(String expressao) {
        Lista lista = new ListaEncadeada();

        for(int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);
            if(caractere == '(') 
                try {
                    lista.inserir(caractere, lista.tamanho());
                }
                catch(PosicaoInvalidaException e) {}
            
            else if(caractere == ')') {
                try {
                    lista.remover(lista.tamanho()-1);
                }
                catch(NenhumItemException e) {}
                catch(PosicaoInvalidaException e) {}
            }
        }
           
        if(!lista.vazia())
            return false;
       
        return true;
    }
}
