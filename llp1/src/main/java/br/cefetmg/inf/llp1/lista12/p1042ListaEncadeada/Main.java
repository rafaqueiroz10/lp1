package br.cefetmg.inf.llp1.lista12.p1042ListaEncadeada;

import java.util.Scanner;
import br.cefetmg.inf.llp1.lista12.Lista;
import br.cefetmg.inf.llp1.lista12.ListaEncadeada;
import br.cefetmg.inf.llp1.lista12.NenhumItemException;
import br.cefetmg.inf.llp1.lista12.PosicaoInvalidaException;
import br.cefetmg.inf.llp1.lista12.ExibirLista;

public class Main {
    public static void main(String[] args) throws PosicaoInvalidaException, NenhumItemException {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        Lista l1 = new ListaEncadeada();
        l1.inserir(a, 0);
        l1.inserir(b, 1);
        l1.inserir(c, 2);
        Lista l2 = new ListaEncadeada();
        l2.inserir(a, 0);
        l2.inserir(b, 1);
        l2.inserir(c, 2);
        l1 = l1.ordenar();
        ExibirLista.exibir(l1);
        System.out.println();
        ExibirLista.exibir(l2);
    }
}