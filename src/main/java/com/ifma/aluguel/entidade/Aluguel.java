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
    private Integer idAluguel;

    private Integer idLocacao;
    private LocalDateTime dataVencimento;
    private Double valorPago;
    private LocalDateTime dataPagamento;
    private String obs;

}
