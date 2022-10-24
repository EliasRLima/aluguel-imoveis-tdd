package com.ifma.aluguel.entidade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Locacao {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idLocacao;
    private Integer idImovel;
    private Integer idCliente;

    private Double valorAluguel;
    private Double percentualMulta;
    private Integer diaVencimento;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Boolean ativo;
    private String obs;
}
