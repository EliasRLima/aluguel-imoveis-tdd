package com.ifma.aluguel.entidade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluguel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_aluguel")
    private Integer idAluguel;

    @Column(name = "id_locacao")
    private Integer idLocacao;
    @Column(name = "data_vencimento")
    private LocalDateTime dataVencimento;
    @Column(name = "valor_pago")
    private Double valorPago;
    @Column(name = "data_pagamento")
    private LocalDateTime dataPagamento;
    private String obs;

}
