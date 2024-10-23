package br.cefetmg.inf.llp1.lista13.p1042FilaArray;

import java.util.Scanner;
import br.cefetmg.inf.llp1.lista13.Fila;
import br.cefetmg.inf.llp1.lista13.OrdenaFila;
import br.cefetmg.inf.llp1.lista13.ExibirFila;

public class Main {
    public static void main(String[] args) {
        Fila fila = new FilaArray(1);
        Fila filaCopia = new FilaArray(1);
        
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        
        fila.enfileirar(a);
        fila.enfileirar(b);
        fila.enfileirar(c);
        filaCopia.enfileirar(a);
        filaCopia.enfileirar(b);
        filaCopia.enfileirar(c);
        
        fila = OrdenaFila.ordenar(fila);
        ExibirFila.exibir(fila);
        System.out.println();
        ExibirFila.exibir(filaCopia);
    }
}
