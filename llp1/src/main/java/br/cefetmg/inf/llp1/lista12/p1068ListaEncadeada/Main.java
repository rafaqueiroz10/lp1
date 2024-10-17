package br.cefetmg.inf.llp1.lista12.p1068ListaEncadeada;

import java.util.Scanner;
import br.cefetmg.inf.llp1.lista12.Lista;
import br.cefetmg.inf.llp1.lista12.NenhumItemException;
import br.cefetmg.inf.llp1.lista12.PosicaoInvalidaException;
import br.cefetmg.inf.llp1.lista12.ListaEncadeada;

public class Main {
    public static void main(String[] args) throws PosicaoInvalidaException, NenhumItemException {
        Scanner input = new Scanner(System.in);
       
        while(input.hasNext()) {
            String expressao = input.nextLine();
            Lista lista = new ListaEncadeada();
            boolean correto = true;
            
            for(int i = 0; i < expressao.length(); i++) {
                if(expressao.charAt(i) == '(') 
                    lista.inserir(expressao.charAt(i), lista.tamanho());
                else if(expressao.charAt(i) == ')') {
                    if(lista.remover(lista.tamanho()-1) == null) {
                        correto = false;
                        break;
                    }
                }
            }
            
            if(!lista.vazia())
                correto = false;
        
            System.out.println(correto ? "correct" : "incorrect");
        }
    }
}
