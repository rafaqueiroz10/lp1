package br.cefetmg.inf.llp1.lista08.p1042.filaEncadeada;

import java.util.Scanner;
import java.lang.Integer;

class No {
    private Integer valor;
    private No prox;
    
    public Integer getValor() {
        return valor;
    }
    
    public void setValor(Integer v) {
        valor = v;
    }
    
    public void setProx(No no) {
        prox = no;
    }
    
    public No getProx() {
        return prox;
    }
}

class Fila {
    private No inicio, fim;
    private int quantos;
    
    Fila () {
        inicio = null;
        fim = null;
        quantos = 0;
    }
    
    private boolean vazia() {
        return (quantos == 0);
    }
    
    public void inserir(Integer v) {
        No novo = new No();
        novo.setValor(v);
        
        if (vazia()) {
            fim = novo;
            inicio = novo;
            novo.setProx(null);
        }
        else {
            fim.setProx(novo);
            fim = novo;
            novo.setProx(null);
        }
        
        quantos++;
    }
    
    public int len() {
        return quantos;
    }
    
    public Integer remover() {
        Integer numero = inicio.getValor();
        inicio = inicio.getProx();
        quantos--;
        return numero;
    }
    
    public Integer getIntInicio() {
        return inicio.getValor();
    }
    
    public Integer getIntFim() {
        return fim.getValor();
    }
    
    public No getInicio() {
        return inicio;
    }
    
    public No getFim() {
        return fim;
    }
    
    public void printar() {
        for(No aux = inicio; aux != null; aux = aux.getProx()) {
            System.out.println(aux.getValor());
        }
    }
    
    private void troca(No a, No b) {
        Integer aux = a.getValor();
        a.setValor(b.getValor());
        b.setValor(aux);
    }
    
    public void ordenar() {
        for (No aux = inicio; aux != null; aux = aux.getProx()) {
            for(No aux2 = aux.getProx(); aux2 != null; aux2 = aux2.getProx()) {
                if (aux.getValor() > aux2.getValor()) 
                   troca(aux, aux2);
            }
        }
    }
    
    public void copiar(Fila filaOrigem) {
        for (No current = filaOrigem.getInicio(); current != null; current = current.getProx()) {
            inserir(current.getValor());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Fila fila = new Fila();
        Fila filaCopia = new Fila();
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        fila.inserir(a);
        fila.inserir(b);
        fila.inserir(c);
        filaCopia.copiar(fila);
        fila.ordenar();
        fila.printar();
        System.out.println();
        filaCopia.printar();
    }
}