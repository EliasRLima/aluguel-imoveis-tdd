package com.ifma.aluguel.exception;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import static java.util.Locale.getDefault;
import static java.util.ResourceBundle.getBundle;

public class MessageProperties {

    public static final String BLANK = "";
    public static final String VIRGULA = ",";
    public static final String ASPAS_SIMPLES = "'";

    /**
     * Recupera as mensagens do propertie.properties.
     * @param chaveMensagem param
     * @param params param
     * @return
     */
    public static String getMensagemPadrao(final String chaveMensagem, final Object... params) {
        final ResourceBundle bundle = getBundle("messages", getDefault());

        return recuperarTexto(bundle, chaveMensagem, params);
    }

    private static String recuperarTexto(final ResourceBundle bundle, final String chaveMensagem,
            final Object params) {
        String mensagem = BLANK;

        try {
            mensagem = bundle.getString(chaveMensagem);
        } catch (final MissingResourceException e) {
            return chaveMensagem;
        }

        return new MessageFormat(mensagem).format(params);
    }
    
    private MessageProperties() {
        
    }
}
