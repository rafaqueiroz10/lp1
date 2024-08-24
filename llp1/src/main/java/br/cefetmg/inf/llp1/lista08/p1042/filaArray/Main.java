package br.cefetmg.inf.llp1.lista08.p1042.filaArray;

import java.util.Scanner;
import java.lang.Integer;

class FilaArray {
    private int inicio, ultimo, tamanho;
    private Integer valores[];
    private int capacidade;
    
    FilaArray(int n) {
        inicio = -1;
        ultimo = -1;
        capacidade = n;
        tamanho = 0;
        valores = new Integer[capacidade];
    }
    
    private boolean vazia() {
        return (tamanho == 0);
    }
    
    private boolean cheia() {
        return tamanho == capacidade;
    }
    
    void enfileirar(Integer valor) {
        if(cheia()) {
            capacidade *= 2;
            Integer copiaValores[] = new Integer[capacidade];
            
            for (int i = 0; i < tamanho; i++) {
                copiaValores[i] = valores[i];
            }
            valores = copiaValores;
        }
        inicio = 0;
        ultimo++;
        valores[ultimo] = valor;
        tamanho++;
    }
    
    void desenfileirar() {
        if(vazia()) 
            return;
 
        for (int i = inicio+1; i < ultimo+1; i++) {
            valores[i-1] = valores[i];
        }
        ultimo--;
        tamanho--;
    }
    
    void printar() {
        if (vazia())
            return;
        
        for(int i = inicio; i < tamanho; i++) {
            System.out.println(valores[i]);
        }
    }
    
    Integer getInicio() {
        if(vazia()) 
            return -1;
        return valores[inicio];
    }
    
    Integer getUltimo() {
        if(vazia()) 
            return -1;
        return valores[ultimo];
    }
    
    int getIndiceInicio() {
        if(vazia()) 
            return -1;
        return inicio;
    }
    
    int getIndiceUltimo() {
        if(vazia()) 
            return -1;
        return ultimo;
    }
    
    int getTamanho() {
        return tamanho;
    }
    
    private void troca(int i, int j) {
        if (i > tamanho-1 || j > tamanho-1)
            return;
        
        Integer aux = valores[i];
        valores[i] = valores[j];
        valores[j] = aux;
    }
    
    void ordenar() {
        if (vazia())
            return;
        
        for(int i = inicio; i < ultimo+1; i++) 
            for(int j = i + 1; j < ultimo+1; j++) 
                if(valores[i] > valores[j]) 
                    troca(i, j);
                    
    }
    
    void copiar(FilaArray original) {
        if (original.vazia())
            return;
        
        for(int i = 0; i < original.ultimo+1; i++) {
            enfileirar(original.valores[i]);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FilaArray fila = new FilaArray(1);
        FilaArray filaCopia = new FilaArray(1);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        fila.enfileirar(a);
        fila.enfileirar(b);
        fila.enfileirar(c);
        filaCopia.copiar(fila);
        fila.ordenar();
        fila.printar();
        System.out.println();
        filaCopia.printar();
    }
}