package br.cefetmg.inf.llp1.lista12;

public class ExibirLista {
    public static void exibir(Lista lista) throws NenhumItemException, PosicaoInvalidaException {
        if(lista.vazia())
            throw new NenhumItemException();
        
        int posicao = 0;
        while(posicao < lista.tamanho()-1) {
            System.out.println(lista.obter(posicao));
            posicao++;
        }
    }
}