package br.cefetmg.inf.llp1.lista09.p1068a;

import java.util.Scanner;

class No {
    private Character ch;
    private No prox;
    
    public void setCh(Character c) {
        ch = c;
    }
    
    public Character getCh() {
        return ch;
    }
    
    public void setProx(No no) {
        prox = no;
    }
    
    public No getProx() {
        return prox;
    }
}

class Pilha {
    private No topo;
    private int tam;
    
    Pilha() {
        topo = null;
        tam = 0;
    }
    
    public void empilhar (Character ch){
        No novo = new No();
        novo.setCh(ch);
        novo.setProx(topo);
        topo = novo;
        tam++;
    }
    
    public Character desempilhar() {
        if(vazia())
            return null;
        
        Character ch = topo.getCh();
        No aux = topo;
        topo = topo.getProx();
        tam--;
        return ch;
    }
    
    public boolean vazia() {
        return (tam == 0);
    }
    
    public int tamanho() {
        return tam;
    }
    
    public String verificarExpressao(String expressao) {
        for(int i = 0; i < expressao.length(); i++) {
            if(expressao.charAt(i) == '(') 
                empilhar(expressao.charAt(i));
            else if(expressao.charAt(i) == ')') 
                if(desempilhar() == null)
                    return "incorrect";
        }
        
        if(vazia())
            return "correct";
        return "incorrect";
    }
}

public class Main {
    public static void main(String[] args) {
        Pilha pilha = new Pilha();
        Scanner input = new Scanner(System.in);
        while(input.hasNext()) {
            String expressao = input.nextLine();
            System.out.println(pilha.verificarExpressao(expressao));
            pilha = new Pilha();
        }
    }
}