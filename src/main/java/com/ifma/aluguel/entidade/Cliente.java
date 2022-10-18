package com.ifma.aluguel.entidade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idCliente;

    private String nomeCliente;
    private Integer cpf;
    private Integer telefone1;
    private Integer telefone2;
    private String email;
    private LocalDateTime dataNascimento;
}