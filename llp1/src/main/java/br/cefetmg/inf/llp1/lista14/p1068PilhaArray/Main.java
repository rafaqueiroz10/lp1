/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.inf.llp1.lista14.p1068PilhaArray;

import br.cefetmg.inf.llp1.lista14.Excecoes.NenhumItemException;
import br.cefetmg.inf.llp1.lista14.Interfaces.Pilha;
import br.cefetmg.inf.llp1.lista14.Pilha.PilhaArray;
import java.util.Scanner;

public class Main { 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
   
        while(input.hasNext()) {
            String expressao = input.nextLine();
            Pilha<Character> pilha = new PilhaArray<>(1);
            boolean correto = true;
            for(int i = 0; i < expressao.length(); i++) {
                char caractere = expressao.charAt(i);
                if(caractere == '(') 
                    pilha.empilhar(caractere);
                else if(caractere == ')') {
                    try {
                        pilha.desempilhar();
                    }
                    catch(NenhumItemException e) {
                        correto = false;
                        break;
                    }
                }
            }
        
            if(!pilha.vazia()) 
                correto = false;
            
            String resposta = correto ? "correct" : "incorrect";
            System.out.println(resposta);
        }
    }
}