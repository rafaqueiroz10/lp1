package br.cefetmg.inf.llp1.lista12;

public class ExibirLista {
    public static void exibir(Lista lista) throws NenhumItemException, PosicaoInvalidaException {
        if(lista.vazia())
            throw new NenhumItemException();
        
        while(!lista.vazia()) {
            System.out.println(lista.obterInicio());
            lista.removerInicio();
        }
    }
}
