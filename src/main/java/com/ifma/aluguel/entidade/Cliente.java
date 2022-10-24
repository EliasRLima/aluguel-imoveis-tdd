package com.ifma.aluguel.entidade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    private String cpf;
    private String telefone1;
    private String telefone2;
    private String email;
    private LocalDateTime dataNascimento;
}
