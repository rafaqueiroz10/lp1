package br.cefetmg.inf.llp1.lista14.Fila;

import br.cefetmg.inf.llp1.lista14.Interfaces.Fila;
import br.cefetmg.inf.llp1.lista14.Excecoes.NenhumItemException;

public class ExibirFila {
    public static <T> void exibir(Fila<T> fila) {
        try {
            while(true) {
                System.out.println(fila.desenfileirar());
            }
        }
        catch(NenhumItemException e) {}
    }
}
