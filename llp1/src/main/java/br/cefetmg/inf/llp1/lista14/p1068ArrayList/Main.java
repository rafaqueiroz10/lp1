package br.cefetmg.inf.llp1.lista14.p1068ArrayList;

import java.util.Scanner;
import br.cefetmg.inf.llp1.lista14.Lista.ArrayList;
import br.cefetmg.inf.llp1.lista14.Interfaces.Lista;
import br.cefetmg.inf.llp1.lista14.Excecoes.NenhumItemException;
import br.cefetmg.inf.llp1.lista14.Excecoes.PosicaoInvalidaException;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        while(input.hasNext()) {
            String expressao = input.nextLine();
            Lista<Character> lista = new ArrayList<>(2);
            boolean correto = true;
            
            for(int i = 0; i < expressao.length(); i++) {
                if(expressao.charAt(i) == '(') {
                    try {
                        lista.inserir(expressao.charAt(i), lista.tamanho());
                    }
                    catch(PosicaoInvalidaException e){}
                }
                else if(expressao.charAt(i) == ')') {
                    try {
                        lista.remover(lista.tamanho()-1);
                    }
                    catch(NenhumItemException e) {
                        correto = false;
                        break;
                    }
                    catch(PosicaoInvalidaException e){}
                }
            }
            
            if(!lista.vazia())
                correto = false;
        
            System.out.println(correto ? "correct" : "incorrect");
        }
    }
}