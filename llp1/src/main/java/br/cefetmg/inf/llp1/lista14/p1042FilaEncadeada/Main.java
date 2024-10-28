package br.cefetmg.inf.llp1.lista14.p1042FilaEncadeada;

import br.cefetmg.inf.llp1.lista14.Interfaces.Fila;
import br.cefetmg.inf.llp1.lista14.Fila.ExibirFila;
import br.cefetmg.inf.llp1.lista14.Fila.OrdenaFila;
import br.cefetmg.inf.llp1.lista14.Fila.FilaEncadeada;
import br.cefetmg.inf.llp1.lista14.Excecoes.NenhumItemException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Fila<Integer> fila = new FilaEncadeada<>();
        Fila<Integer> filaCopia = new FilaEncadeada<>();
        
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
        
        try {
            fila = OrdenaFila.ordenar(fila);
            
            ExibirFila.exibir(fila);
            System.out.println();
            ExibirFila.exibir(filaCopia);
        }
        catch(NenhumItemException e) {
            System.out.println(e.getMessage());
        }
    }
}