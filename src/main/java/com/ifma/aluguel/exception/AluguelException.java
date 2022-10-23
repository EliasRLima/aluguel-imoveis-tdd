package com.ifma.aluguel.exception;

public class AluguelException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final transient AluguelErro erro;

    public AluguelException() {
        super();
        erro = new AluguelErro(null, null);
    }

    public AluguelException(final String mensagem, final Throwable causa) {
        super(mensagem, causa);
        erro = new AluguelErro(mensagem, causa.getStackTrace());
    }

    public AluguelException(final String mensagem) {
        this(mensagem, mensagem);
    }

    public AluguelException(final String mensagem, final Object detalhe) {
        super(mensagem);
        erro = new AluguelErro(mensagem, detalhe);
    }

    public AluguelErro getErro() {
        return erro;
    }

    @Override
    public String toString() {
        return String.format("AluguelException [erro=%s]", erro);
    }

}
