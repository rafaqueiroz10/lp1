package br.cefetmg.inf.llp1.lista14.p1068PilhaEncadeada;

import br.cefetmg.inf.llp1.lista14.Excecoes.NenhumItemException;
import br.cefetmg.inf.llp1.lista14.Interfaces.Pilha;
import br.cefetmg.inf.llp1.lista14.Pilha.PilhaEncadeada;
import java.util.Scanner;

public class Main { 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
   
        while(input.hasNext()) {
            String expressao = input.nextLine();
            Pilha<Character> pilha = new PilhaEncadeada<>();
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