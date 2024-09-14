package br.cefetmg.inf.llp1.lista11.p1068a;

public class PilhaEncadeada extends PilhaAbstrata {
    class No {
        Object item;
        No proximo;
        
        public No() {
            this(null, null);
        }
        
        public No(Object item) {
            this(item, null);
        }
        
        public No(Object item, No proximo) {
            this.item = item;
            this.proximo = proximo;
        }
    }
    
    private No topo;
    
    public PilhaEncadeada() {
        topo = null;
    }
    
    @Override
    public void empilhar (Object item){
        No novo = new No();
        novo.item = item;
        novo.proximo = topo;
        topo = novo;
        quantos++;
    }
    
    @Override
    public Object desempilhar() {
        if(vazia())
            return null;
        
        Object item = topo.item;
        topo = topo.proximo;
        quantos--;
        return item;
    }
    
    @Override
    public Object getTopo() {
        return topo.item;
    }
}
