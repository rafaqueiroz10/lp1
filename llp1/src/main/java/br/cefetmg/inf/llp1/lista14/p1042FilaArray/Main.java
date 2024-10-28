package br.cefetmg.inf.llp1.lista14.p1042FilaArray;

import br.cefetmg.inf.llp1.lista14.Excecoes.NenhumItemException;
import br.cefetmg.inf.llp1.lista14.Interfaces.Fila;
import br.cefetmg.inf.llp1.lista14.Fila.FilaArray;
import br.cefetmg.inf.llp1.lista14.Fila.ExibirFila;
import br.cefetmg.inf.llp1.lista14.Fila.OrdenaFila;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        
        Fila<Integer> f1 = new FilaArray<>(1);
        Fila<Integer> f2 = new FilaArray<>(1);
        
        f1.enfileirar(a);
        f1.enfileirar(b);
        f1.enfileirar(c);
            
        f2.enfileirar(a);
        f2.enfileirar(b);
        f2.enfileirar(c);
          
        try {
            f1 = OrdenaFila.ordenar(f1);
            
            ExibirFila.exibir(f1);
            System.out.println();
            ExibirFila.exibir(f2);
        }     
        catch(NenhumItemException e) {
            System.out.println(e.getMessage());
        }
    }
}
