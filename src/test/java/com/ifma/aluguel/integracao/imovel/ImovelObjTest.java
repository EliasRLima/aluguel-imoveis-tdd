package com.ifma.aluguel.integracao.imovel;

import com.ifma.aluguel.entidade.Imovel;

public class ImovelObjTest {

    public Imovel getImovelNovoTest(){
        Imovel imovel = new Imovel();
        imovel.setTipoImovel("Casa");
        imovel.setBairro("Vila do Pato");
        imovel.setCep(21312123);

        return imovel;
    }

    public Imovel getImovelExistenteTest(){
        Imovel imovel = new Imovel();
        imovel.setIdImovel(11);
        imovel.setTipoImovel("Casa");
        imovel.setBairro("Vila do Pato");
        imovel.setCep(21312123);
        imovel.setValorAluguelSugerido(1100.0);
        return imovel;
    }

    public Imovel getImovelExistenteSemLocacaoTest(){
        Imovel imovel = new Imovel();
        imovel.setIdImovel(12);
        imovel.setTipoImovel("Casa");
        imovel.setBairro("Vila do Pato");
        imovel.setCep(21312123);
        imovel.setValorAluguelSugerido(12000.0);
        return imovel;
    }
}
