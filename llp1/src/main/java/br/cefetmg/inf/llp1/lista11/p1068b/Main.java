package br.cefetmg.inf.llp1.lista11.p1068b;
import java.util.Scanner;
import br.cefetmg.inf.llp1.lista11.p1068a.PilhaAbstrata;

public class Main {
    public static String verificarExpressao(String expressao) {
        PilhaAbstrata pilha = new PilhaArray(1);
        for(int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);
            if(caractere == '(') 
                pilha.empilhar(caractere);
            else if(caractere == ')') 
                if(pilha.desempilhar() == null) 
                    return "incorrect";
                
        }
        
        if(!pilha.vazia())
            return "incorrect";
        
        return "correct";
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
   
        while(input.hasNext()) {
            String expressao = input.nextLine();
            String resposta = verificarExpressao(expressao);
            System.out.println(resposta);
        }
    }
}
