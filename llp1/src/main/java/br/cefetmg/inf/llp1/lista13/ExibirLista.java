package br.cefetmg.inf.llp1.lista13;

public class ExibirLista {
    public static void exibir(Lista lista) 
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