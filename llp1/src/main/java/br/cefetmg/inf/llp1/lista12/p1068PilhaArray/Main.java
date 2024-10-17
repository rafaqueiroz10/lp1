/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.inf.llp1.lista12.p1068PilhaArray;

import java.util.Scanner;
import br.cefetmg.inf.llp1.lista12.NenhumItemException;

public class Main {  
    public static boolean validarExpressao(String expressao) throws NenhumItemException {
        PilhaArray pilha = new PilhaArray(1);
        for(int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);
            if(caractere == '(') 
                pilha.empilhar(caractere);
            else if(caractere == ')') {
                if(pilha.vazia()) 
                   return false;
                
                pilha.desempilhar();
            }
        }
        
        if(!pilha.vazia()) 
            return false;
            
        return true;
    }
    
    public static void main(String[] args) throws NenhumItemException {
        Scanner input = new Scanner(System.in);
   
        while(input.hasNext()) {
            String expressao = input.nextLine();
            String resposta = validarExpressao(expressao) ? "correct" : "incorrect";
            System.out.println(resposta);
        }
    }
}