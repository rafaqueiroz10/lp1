package br.cefetmg.inf.llp1.lista10.p1042ListaEncadeadaSimples;

enum StatusLista {SUCESSO, POSICAOINVALIDA};

class Lista {
    static class No {
        Integer item;
        No proximo;
        
        public No() {
            this(null, null);
        }
        
        public No(Integer item) {
            this(item, null);
        }
        
        public No(Integer item, No proximo) {
            this.item = item;
            this.proximo = proximo;
        }
    }
    
    private int quantos;
    private No inicio, fim;
    
    // número de itens na lista
    public int tamanho() { 
        return quantos;
    }
    
    // true se lista não possuir itens;
    // false em caso contrário
    public boolean vazia() { 
        return (quantos == 0); 
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
    public Integer removerInicio() { return null; }
    
    // remove item no final da lista
    // retorna null se lista vazia
    public Integer removerFim() { return null; }
    
    // remove item na 'posicao' da lista
    // retorna null se posicao inválida
    public Integer remover(int posicao) { return null; }
    
    // retorna, sem remover, o item no início da lista
    // null se lista vazia
    public Integer obterInicio() {
        return (vazia()) ? inicio.item : null;
    }
    
    // retorna, sem remover, o item no fim da lista
    // null se lista vazia
    public Integer obterFim() { 
        return (vazia()) ? fim.item : null; 
    }
    
    // retorna, sem remover, o item na posição indicada 
    // null se for posição inválida
    public Integer obter(int posicao) {
        if(posicao > tamanho() || posicao < 0)
            return null;
        
        int p = 0;
        for(No aux = inicio; aux != null; aux = aux.proximo) {
            if(p == posicao)
                return aux.item;
            
            p++;
        }
        return null; 
    }
    
    // retorna posição do item; 
    // -1 em caso contrário
    public int pesquisar (Integer item) {
        int p = 0;
        for(No aux = inicio; aux != null; aux = aux.proximo) {
            if(aux.item == item)
                return aux.item;
            
            p++;
        }
        return -1; 
    }
}

public class Main {
    public static void main(String[] args) {
        
    }
}
