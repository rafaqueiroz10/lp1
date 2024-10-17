package br.cefetmg.inf.llp1.lista12.p1042FilaArray;

import br.cefetmg.inf.llp1.lista12.Fila;
import br.cefetmg.inf.llp1.lista12.NenhumItemException;
import br.cefetmg.inf.llp1.lista12.ExibirFila;
import br.cefetmg.inf.llp1.lista12.OrdenaFila;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NenhumItemException {
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
