package br.cefetmg.inf.llp1.lista09.p1068b;

import java.util.Scanner;

class Pilha {
    private int topo, capacidade, tam;
    private Character ch[];
    
    public Pilha(int c) {
        capacidade = c;
        topo = -1;
        ch = new Character[capacidade];
        tam = 0;
    }
    
    private void redimensionar() {
        Character novoCh[] = new Character[capacidade * 2];
        System.arraycopy(ch, 0, novoCh, 0, capacidade);
        capacidade *= 2;
        ch = novoCh;
    }
    
    public void empilhar (Character c){
        if(topo == capacidade-1)
            redimensionar();
        
        topo++;
        ch[topo] = c;
        tam++;
    }
    
    public int tamanho() {
        return tam;
    }
    
    public Character desempilhar() {
        if(vazia())
            return null;
        
        Character c = ch[topo--];
        tam--;
        return c;
    }
    
    public boolean vazia() {
        return (topo == -1);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
   
        while(input.hasNext()) {
            String expressao = input.nextLine();
            Pilha pilha = new Pilha(3);
            boolean correto = true;
            
            for(int i = 0; i < expressao.length(); i++) {
                char caractere = expressao.charAt(i);
                if(caractere == '(') 
                    pilha.empilhar(caractere);
                else if(caractere == ')') {
                    if(pilha.desempilhar() == null) {
                        correto = false;
                        break;
                    }
                }
            }
            
            if(!pilha.vazia())
                correto = false;
        
            System.out.println(correto ? "correct" : "incorrect");
        }
    }
}