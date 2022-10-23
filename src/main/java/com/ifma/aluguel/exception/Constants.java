package com.ifma.aluguel.exception;


import static com.ifma.aluguel.exception.MessageProperties.getMensagemPadrao;

public class Constants {
    public static final String PAIS_PAGAMENTO_BRA = "BRA";

    public static final String RESPONSE_200 = getMensagemPadrao("response.code200");
    public static final String RESPONSE_201 = getMensagemPadrao("response.code201");
    public static final String RESPONSE_204 = getMensagemPadrao("response.code204");

    public static final String RESPONSE_304 = getMensagemPadrao("response.code304");

    public static final String RESPONSE_400 = getMensagemPadrao("response.code400");
    public static final String RESPONSE_401 = getMensagemPadrao("response.code401");
    public static final String RESPONSE_404 = getMensagemPadrao("response.code404");
    public static final String RESPONSE_431 = getMensagemPadrao("response.code431");
    
    public static final String RESPONSE_500 = getMensagemPadrao("response.code500");

    public static final String EXCECAO_ARGUMENTO_INVALIDO_MSG = "Erro de parâmetro(s) inválido(s).";
    public static final String EXCECAO_ARGUMENTO_INVALIDO_DTL = "%s; Campo = '%s'; Valor = '%s'.";

    public static final String NOME_PROJETO = "IFMA_LIVRARIA";

    private Constants() {
        
    }
}
