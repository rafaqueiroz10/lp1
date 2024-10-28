package br.cefetmg.inf.llp1.lista14.Excecoes;

public class PosicaoInvalidaException extends Exception {
    public PosicaoInvalidaException(String mensagem) {
        super(mensagem);
    }
    public PosicaoInvalidaException() {
        super();
    }
}
