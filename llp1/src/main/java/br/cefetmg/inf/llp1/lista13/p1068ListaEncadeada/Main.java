package br.cefetmg.inf.llp1.lista13.p1068ListaEncadeada;

import java.util.Scanner;
import br.cefetmg.inf.llp1.lista13.NenhumItemException;
import br.cefetmg.inf.llp1.lista13.PosicaoInvalidaException;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       
        while(input.hasNext()) {
            String expressao = input.nextLine();
            try {
                boolean valido = ValidaParenteses.validar(expressao);
                System.out.println(valido ? "correct" : "incorrect");
            }
            catch(PosicaoInvalidaException e) {
                System.out.println();
            }
            catch(NenhumItemException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

