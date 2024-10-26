package br.cefetmg.inf.llp1.lista13.p1068ListaEncadeada;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       
        while(input.hasNext()) {
            String expressao = input.nextLine();
            boolean valido = ValidaParenteses.validar(expressao);
            System.out.println(valido ? "correct" : "incorrect");
        }
    }
}