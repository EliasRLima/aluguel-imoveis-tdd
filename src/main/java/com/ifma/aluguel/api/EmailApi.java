package com.ifma.aluguel.api;

import com.ifma.aluguel.exception.AluguelException;
import com.ifma.aluguel.exception.MessageProperties;

import java.util.Objects;

public class EmailApi {

    public static void sendEmail(String email, String msg){

        if(!email.contains("@")){
            throw new AluguelException(
                    MessageProperties.getMensagemPadrao("erro.email.invalido"));
        }

        System.out.println(email + " notificado.");

    }

}
