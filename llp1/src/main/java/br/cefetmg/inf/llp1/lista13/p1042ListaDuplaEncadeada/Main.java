package br.cefetmg.inf.llp1.lista13.p1042ListaDuplaEncadeada;

import br.cefetmg.inf.llp1.lista13.ListaDuplamenteEncadeada;
import br.cefetmg.inf.llp1.lista13.NenhumItemException;
import br.cefetmg.inf.llp1.lista13.PosicaoInvalidaException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        
        ListaDuplamenteEncadeada l1 = new ListaDuplamenteEncadeada();
        ListaDuplamenteEncadeada l2 = new ListaDuplamenteEncadeada();
        
        try {
            l1.inserir(a, 0);
            l1.inserir(b, 1);
            l1.inserir(c, 2);
            
            l2.inserir(a, 0);
            l2.inserir(b, 1);
            l2.inserir(c, 2);
            
            l1 = l1.ordenar();
            
            ExibirLista.exibir(l1);
            System.out.println();
            ExibirLista.exibir(l2);
        }
        
        catch(PosicaoInvalidaException e) {
            System.out.println(e.getMessage());
        }
        
        catch(NenhumItemException e) {
            System.out.println(e.getMessage());
        }
    }
}