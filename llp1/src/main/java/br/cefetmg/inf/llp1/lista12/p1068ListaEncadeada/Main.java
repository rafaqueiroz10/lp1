package br.cefetmg.inf.llp1.lista12.p1068ListaEncadeada;

import java.util.Scanner;
import br.cefetmg.inf.llp1.lista12.Lista;
import br.cefetmg.inf.llp1.lista12.NenhumItemException;
import br.cefetmg.inf.llp1.lista12.PosicaoInvalidaException;
import br.cefetmg.inf.llp1.lista12.ListaEncadeada;

public class Main {
    public static boolean validar(String expressao) throws PosicaoInvalidaException, NenhumItemException {
        Lista lista = new ListaEncadeada();

        for(int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);
            if(caractere == '(') 
                lista.inserir(caractere, lista.tamanho());
            else if(caractere == ')') {
                if(lista.vazia())
                    return false;
                    
                lista.remover(lista.tamanho()-1);
            }   
        }
           
        if(!lista.vazia())
            return false;
       
        return true;
    }
    public static void main(String[] args) throws PosicaoInvalidaException, NenhumItemException {
        Scanner input = new Scanner(System.in);
       
        while(input.hasNext()) {
            String expressao = input.nextLine();
            boolean valido = validar(expressao);
            System.out.println(valido ? "correct" : "incorrect");
        }
    }
}
