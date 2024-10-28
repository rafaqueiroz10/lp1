package br.cefetmg.inf.llp1.lista14.Excecoes;

public class NenhumItemException extends Exception {
    public NenhumItemException(String mensagem) {
        super(mensagem);
    }
    public NenhumItemException() {
        super();
    }
}
