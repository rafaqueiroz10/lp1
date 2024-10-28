package br.cefetmg.inf.llp1.lista14.Lista;

import br.cefetmg.inf.llp1.lista14.Excecoes.NenhumItemException;
import br.cefetmg.inf.llp1.lista14.Excecoes.PosicaoInvalidaException;
import br.cefetmg.inf.llp1.lista14.Interfaces.Lista;

public class ExibirLista {
    public static <T> void exibir(Lista<T> lista) 
        throws NenhumItemException, PosicaoInvalidaException {
        
        try {
            int posicao = 0;
            while(true) {
                System.out.println(lista.obter(posicao));
                posicao++;
            }
        }
        catch(PosicaoInvalidaException e) {}
        catch(NenhumItemException e) {
            throw new NenhumItemException("Erro: lista vazia!!");
        }
    }
}