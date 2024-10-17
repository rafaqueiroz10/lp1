package br.cefetmg.inf.llp1.lista12;

public class ExibirFila {
    public static void exibir(Fila fila) throws NenhumItemException {
        while(!fila.vazia()) {
            System.out.println(fila.desenfileirar());
        }
    }
}
