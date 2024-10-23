package br.cefetmg.inf.llp1.lista13;

public class ExibirLista {
    public static void exibir(Lista lista) {
        try {
            int posicao = 0;
            while(true) {
                System.out.println(lista.obter(posicao));
                posicao++;
            }
        }
        catch(PosicaoInvalidaException e) {}
        catch(NenhumItemException e) {}
    }
}