/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.inf.llp1.lista13.p1068ListaDuplaEncadeada;

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