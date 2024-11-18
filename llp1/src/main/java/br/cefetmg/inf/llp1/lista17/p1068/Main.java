package br.cefetmg.inf.llp1.lista17.p1068;

import java.util.Stack;
import java.util.Scanner;
import java.util.EmptyStackException;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       
        while(input.hasNext()) {
            Stack<Character> stack = new Stack<>();
            String expressao = input.nextLine();
       
            boolean correto = true;
            try {
                for(int i = 0; i < expressao.length(); i++) {
                    char caractere = expressao.charAt(i);
                    if(caractere == '(') {
                        stack.add(caractere);
                    }
                    else if(caractere == ')') {
                        stack.pop();
                    }
                }
                
                if(!stack.isEmpty()) {
                    correto = false;
                }
            }
            catch(EmptyStackException e) {
                correto = false;
            }
        
            if(correto) 
                System.out.println("correct");
            else
                System.out.println("incorrect");
       
        }
    }
}