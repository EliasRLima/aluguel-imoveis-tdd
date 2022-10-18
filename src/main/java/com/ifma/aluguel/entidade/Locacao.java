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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Locacao {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idAluguel;
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