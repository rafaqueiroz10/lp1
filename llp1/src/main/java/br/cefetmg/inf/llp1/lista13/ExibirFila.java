package br.cefetmg.inf.llp1.lista13;

public class ExibirFila {
    public static void exibir(Fila fila) {
        try {
            while(true) {
                System.out.println(fila.desenfileirar());
            }
        }
        catch(NenhumItemException e) {}
    }
}