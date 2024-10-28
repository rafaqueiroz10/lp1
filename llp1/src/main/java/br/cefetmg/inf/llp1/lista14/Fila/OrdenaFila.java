package br.cefetmg.inf.llp1.lista14.Fila;

import br.cefetmg.inf.llp1.lista14.Interfaces.Fila;
import br.cefetmg.inf.llp1.lista14.Excecoes.NenhumItemException;

public class OrdenaFila {
    public static <T> Fila<T> ordenar(Fila<T> fila) throws NenhumItemException {
        if(fila.vazia())
            throw new NenhumItemException("Erro: fila vazia!!");
        
        T[] vetor = (T[]) new Object[fila.tamanho()];
        
        try {
            for(int i = 0; true; i++) {
                vetor[i] = fila.desenfileirar();
            }
        }
        catch(NenhumItemException e) {}
        
        for(int i = 0; i < vetor.length; i++) {
            for(int j = i + 1; j < vetor.length; j++) {
                if((Integer)vetor[i] > (Integer)vetor[j]) {
                    T aux = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = aux;
                }
            }
        }
        
        for(T item:vetor)
            fila.enfileirar(item);
        
        return fila;
    }
}