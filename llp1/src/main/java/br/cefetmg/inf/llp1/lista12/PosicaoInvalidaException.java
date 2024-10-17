package br.cefetmg.inf.llp1.lista12;

public class PosicaoInvalidaException extends Exception {
    public PosicaoInvalidaException(String mensagem) {
        super(mensagem);
    }
    public PosicaoInvalidaException() {}
}
