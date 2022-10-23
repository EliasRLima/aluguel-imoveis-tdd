package com.ifma.aluguel.entidade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_imovel")
public class Imovel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idImovel;

    private String tipoImovel;
    private String endereco;
    private String bairro;
    private Integer cep;
    private Double metragem;
    private Integer dormitorios;
    private Integer banheiros;
    private Integer suites;
    private Integer vagasGaragem;
    private Double valorAluguelSugerido;
    private String obs;

}
