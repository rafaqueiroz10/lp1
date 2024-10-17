package br.cefetmg.inf.llp1.lista12;

import br.cefetmg.inf.llp1.lista12.NenhumItemException;
import br.cefetmg.inf.llp1.lista12.Fila;

public class OrdenaFila {
    public static Fila ordenar(Fila fila) throws NenhumItemException {
        if(fila.vazia())
            throw new NenhumItemException();
 
        Object[] vetor = new Object[fila.tamanho()];
        for(int i = 0; i < fila.tamanho(); i++) 
            vetor[i] = fila.desenfileirar();
        
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