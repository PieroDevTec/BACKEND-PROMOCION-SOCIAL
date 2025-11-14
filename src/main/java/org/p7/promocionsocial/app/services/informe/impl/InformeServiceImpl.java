package org.p7.promocionsocial.app.services.informe.impl;

import org.p7.promocionsocial.app.models.Informe;
import org.p7.promocionsocial.app.models.dto.response.ResponseList;
import org.p7.promocionsocial.app.repositories.informe.IInformeRepositorie;
import org.p7.promocionsocial.app.services.informe.IInformeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformeServiceImpl implements IInformeService {

    @Autowired
    private IInformeRepositorie repo;

    @Override
    public ResponseList<Informe> listarInformesSeguro(String codSeguro, String codTipoInforme) {
        ResponseList<Informe> resp = new ResponseList<>();
        try{
            if(codSeguro.length() != 5 || codTipoInforme.length() != 5){
                resp.setCodigo("001");
                resp.setMensaje("Seguro y/o informes no disponibles.");
                resp.setLista(null);
                return null;
            }
            List<Informe> list = repo.listar(codSeguro,codTipoInforme);
            if(list == null){
                resp.setCodigo("001");
                resp.setMensaje("Informes no disponibles.");
                resp.setLista(null);
                return resp;
            }
            resp.setCodigo("000");
            resp.setMensaje("Se encontraron resultados satisfactoriamente.");
            resp.setLista(list);
            return resp;
        } catch (Exception e) {
            resp.setCodigo("002");
            resp.setMensaje(e.getMessage());
            resp.setLista(null);
            return resp;
        }
    }
}
