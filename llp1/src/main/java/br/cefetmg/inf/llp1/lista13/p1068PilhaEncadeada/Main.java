package br.cefetmg.inf.llp1.lista13.p1068PilhaEncadeada;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
   
        while(input.hasNext()) {
            String expressao = input.nextLine();
            String resposta = ValidaParenteses.validar(expressao) ? "correct" : "incorrect";
            System.out.println(resposta);
        }
    }
}