package br.cefetmg.inf.llp1.lista10.p1042ListaDuplaEncadeada;
import java.util.Scanner;

enum StatusLista {SUCESSO, POSICAOINVALIDA};

class Lista {
    class No {
        Integer item;
        No proximo, anterior;
        
        public No() {
            this(null, null, null);
        }
        
        public No(Integer item) {
            this(item, null, null);
        }
        
        public No(Integer item, No proximo, No anterior) {
            this.item = item;
            this.proximo = proximo;
            this.anterior = anterior;
        }
    }
    
    private int quantos;
    No inicio, fim;
    
    Lista() {
        inicio = null;
        fim = null;
        quantos = 0;
    }
    
    // número de itens na lista
    public int tamanho() { 
        return quantos;
    }
    
    // true se lista não possuir itens;
    // false em caso contrário
    public boolean vazia() { 
        return (tamanho() == 0); 
    }
    
    // insere item no início da lista
    public void inserirInicio(Integer item) { 
        
    }
    
    // insere item no final da lista
    public void inserirFim(Integer item) { 
    
    }
    
    // insere item na 'posisao' da lista
    // 'posicao' análoga ao índice dos arrays
    // posição válida: posicao >= 0 && <= tamanho
    public StatusLista inserir(Integer item, int posicao) { 
        if (posicao < 0 || posicao > tamanho())
            return StatusLista.POSICAOINVALIDA;
             
        return StatusLista.SUCESSO;
    }
    
    // remove item no início da lista
    // retorna null se lista vazia
    public Integer removerInicio() { 
        return null; 
    }
    
    // remove item no final da lista
    // retorna null se lista vazia
    public Integer removerFim() {
        return null; 
    }
    
    // remove item na 'posicao' da lista
    // retorna null se posicao inválida
    public Integer remover(int posicao) { 
        return null; 
    }
    
    // retorna, sem remover, o item no início da lista
    // null se lista vazia
    public Integer obterInicio() { 
        return (vazia()) ? null : inicio.item;
    }
    
    // retorna, sem remover, o item no fim da lista
    // null se lista vazia
    public Integer obterFim() { 
        return (vazia()) ? null : fim.item;
    }
    
    // retorna, sem remover, o item na posição indicada 
    // null se for posição inválida
    public Integer obter(int posicao) { 
        return null; 
    }
    
    // retorna posição do item; 
    // -1 em caso contrário
    public int pesquisar (Integer item) {
        return 0; 
    }
    
    private void troca(No a, No b) {
        Integer aux = a.item;
        a.item = b.item;
        b.item = aux;
    }
    
    public void ordenar() {
        if(vazia())
            return;
        
        for(No aux = inicio; aux != null; aux = aux.proximo) 
            for(No aux2 = aux.proximo; aux2 != null; aux2 = aux2.proximo) 
                if(aux.item > aux2.item) 
                    troca(aux, aux2);
                    
    }
    
    public void exibir() {
        if(vazia())
            return;
        
        No aux = inicio;
        while(aux != null) {
            System.out.println(aux.item);
            aux = aux.proximo;
        } 
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        Lista l1 = new Lista();
        l1.inserir(a, 0);
        l1.inserir(b, 1);
        l1.inserir(c, 2);
        Lista l2 = new Lista();
        l2.inserir(a, 0);
        l2.inserir(b, 1);
        l2.inserir(c, 2);
        l1.ordenar();
        l1.exibir();
        System.out.println();
        l2.exibir();
    }
}
