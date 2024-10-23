package br.cefetmg.inf.llp1.lista13.p1042ListaDuplaEncadeada;

import br.cefetmg.inf.llp1.lista13.NenhumItemException;
import br.cefetmg.inf.llp1.lista13.PosicaoInvalidaException;
import br.cefetmg.inf.llp1.lista13.ListaDuplamenteEncadeada;

public class ExibirLista {
    public static void exibir(ListaDuplamenteEncadeada lista) 
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