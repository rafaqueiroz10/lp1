package br.cefetmg.inf.llp1.lista13;

public class OrdenaFila {
    public static Fila ordenar(Fila fila) {
        Object[] vetor = new Object[fila.tamanho()];
        
        try {
            for(int i = 0; true; i++) {
                vetor[i] = fila.desenfileirar();
            }
        }
        catch(NenhumItemException e) {}
        
        for(int i = 0; i < vetor.length; i++) {
            for(int j = i + 1; j < vetor.length; j++) {
                if((Integer)vetor[i] > (Integer)vetor[j]) {
                    Integer aux = (Integer)vetor[i];
                    vetor[i] = (Integer)vetor[j];
                    vetor[j] = aux;
                }
            }
        }
        
        for(int i = 0; i < vetor.length; i++)
            fila.enfileirar(vetor[i]);
        
        return fila;
    }
}