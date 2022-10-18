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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluguel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idAluguel;

    private LocalDateTime dataVencimento;
    private Double valorPago;
    private LocalDateTime dataPagamento;
    private String obs;

}
