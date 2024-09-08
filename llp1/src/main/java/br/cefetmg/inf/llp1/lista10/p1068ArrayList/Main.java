package br.cefetmg.inf.llp1.lista10.p1068ArrayList;
import java.util.Scanner;

enum StatusLista {SUCESSO, POSICAOINVALIDA};

class ArrayList {
    private Character itens[];
    private int quantos, capacidade;
    
    ArrayList(int tamInicial) {
        itens = new Character[tamInicial];
        capacidade = tamInicial;
        quantos = 0;
    }
    // número de itens na lista
    public int tamanho() { 
        return quantos;
    }
    
    // true se lista não possuir itens;
    // false em caso contrário
    public boolean vazia() { 
        return tamanho() == 0; 
    }
    
    public boolean cheia() {
        return quantos == capacidade;
    }
    
    private void redimensionar() {
        capacidade *= 2;
        Character aux[] = new Character[capacidade];
        for(int i = 0; i < tamanho(); i++)
            aux[i] = itens[i];
        
        itens = aux;
    }
    
    // insere item no início da lista
    public void inserirInicio(Character item) { 
        quantos++;
        if(cheia())
            redimensionar();
        
        for(int i = 1; i < tamanho(); i++) 
            itens[i] = itens[i-1];

        itens[0] = item;
    }
    
    // insere item no final da lista
    public void inserirFim(Character item) { 
        if(cheia())
            redimensionar();

        itens[tamanho()] = item;
        quantos++;
    }
    
    // insere item na 'posisao' da lista
    // 'posicao' análoga ao índice dos arrays
    // posição válida: posicao >= 0 && <= tamanho
    public StatusLista inserir(Character item, int posicao) { 
        if (posicao < 0 || posicao > tamanho())
            return StatusLista.POSICAOINVALIDA;
            
        if(posicao == 0)
            inserirInicio(item);
        else if(posicao == tamanho())
            inserirFim(item);
        else {
            if(cheia())
                redimensionar();
            
            for(int i = posicao; i < tamanho()-1; i++) 
                itens[i+1] = itens[i];
            
            itens[posicao] = item;
            quantos++;
        }
        return StatusLista.SUCESSO;
    }
    
    // remove item no início da lista
    // retorna null se lista vazia
    public Character removerInicio() {
        if(vazia())
            return null;
        
        Character valorRemovido = itens[0];
        for(int i = 1; i < tamanho(); i++) {
            itens[i-1] = itens[i];
        }
        quantos--; 
        return valorRemovido;
    }
    
    // remove item no final da lista
    // retorna null se lista vazia
    public Character removerFim() {
        if(vazia())
            return null;
        
        Character valorRemovido = itens[tamanho()-1];
        quantos--;
        return valorRemovido; 
    }
    
    // remove item na 'posicao' da lista
    // retorna null se posicao inválida
    public Character remover(int posicao) {
        if(posicao < 0 || posicao > tamanho()-1)
            return null;
        
        if(posicao == 0)
            return removerInicio();
        
        if(posicao == tamanho()-1)
            return removerFim();
        
        Character valorRemovido = obter(posicao);
        for(int i = posicao+1; i < tamanho(); i++)
            itens[i-1] = itens[i];
        
        quantos--;
        return valorRemovido;
    }
    
    // retorna, sem remover, o item no início da lista
    // null se lista vazia
    public Character obterInicio() {
        return (vazia()) ? null : itens[0]; 
    }
    
    // retorna, sem remover, o item no fim da lista
    // null se lista vazia
    public Character obterFim() { 
        return (vazia()) ? null : itens[tamanho()-1]; 
    }
    
    // retorna, sem remover, o item na posição indicada 
    // null se for posição inválida
    public Character obter(int posicao) { 
        if(vazia() || posicao > tamanho() || posicao < 0)
            return null;
        
        return itens[posicao];
    }
    
    // retorna posição do item; 
    // -1 em caso contrário
    public int pesquisar (Character item) {
        for(int i = 0; i < tamanho(); i++)
            if(itens[i] == item)
                return i;
        
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList lista;
        
        while(input.hasNext()) {
            String expressao = input.nextLine();
            lista = new ArrayList(2);
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
