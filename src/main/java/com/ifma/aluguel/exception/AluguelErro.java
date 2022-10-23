package com.ifma.aluguel.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(value = NON_NULL)
public class AluguelErro {

    private String mensagem;
    private Object detalhe;

    public AluguelErro() {
        this(null, null);
    }

    public void setMensagem(final String mensagem) {
        this.mensagem = mensagem;
    }

    public void setDetalhe(final Object detalhe) {
        this.detalhe = detalhe;
    }

    @Override
    public String toString() {
        return String.format("LivrariaErro [mensagem=%s, detalhe=%s]", mensagem, detalhe);
    }
}
