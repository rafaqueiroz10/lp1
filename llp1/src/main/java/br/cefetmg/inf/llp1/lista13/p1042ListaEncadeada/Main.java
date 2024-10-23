/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.inf.llp1.lista13.p1042ListaEncadeada;

import br.cefetmg.inf.llp1.lista13.ListaEncadeada;
import br.cefetmg.inf.llp1.lista13.ExibirLista;
import br.cefetmg.inf.llp1.lista13.Lista;
import br.cefetmg.inf.llp1.lista13.NenhumItemException;
import br.cefetmg.inf.llp1.lista13.PosicaoInvalidaException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        
        ListaEncadeada l1 = new ListaEncadeada();
        try {
            l1.inserir(a, 0);
            l1.inserir(b, 1);
            l1.inserir(c, 2);
        }
        catch(PosicaoInvalidaException e) {}
        
        Lista l2 = new ListaEncadeada();
        try {
            l2.inserir(a, 0);
            l2.inserir(b, 1);
            l2.inserir(c, 2);
        }
        catch(PosicaoInvalidaException e) {}
        
        try {
            l1 = l1.ordenar();
        }
        catch(NenhumItemException e) {}
        
        ExibirLista.exibir(l1);
        System.out.println();
        ExibirLista.exibir(l2);
    }
}