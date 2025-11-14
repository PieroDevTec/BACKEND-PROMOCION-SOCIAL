package org.p7.promocionsocial.app.services.tipoinforme.impl;

import org.p7.promocionsocial.app.models.TipoInforme;
import org.p7.promocionsocial.app.models.dto.response.ResponseList;
import org.p7.promocionsocial.app.repositories.error.Log;
import org.p7.promocionsocial.app.repositories.tipoinforme.ITipoInformeRepositorie;
import org.p7.promocionsocial.app.services.tipoinforme.ITipoInformeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoInformeServiceImpl implements ITipoInformeService {

    @Autowired
    private ITipoInformeRepositorie repo;

    @Override
    public ResponseList<TipoInforme> listarInformeSeguro(String codSeguro) {
        ResponseList<TipoInforme> resp = new ResponseList<>();

        if(codSeguro.length() != 5){
            resp.setCodigo("001");
            resp.setMensaje("Informes no disponibles");
            resp.setLista(null);
            return resp;
        }
        try{
            List<TipoInforme> list = repo.lista(codSeguro);
            if(list == null){
                resp.setCodigo("001");
                resp.setMensaje("No hay informes disponibles.");
                resp.setLista(null);
                return resp;
            }
            resp.setCodigo("000");
            resp.setMensaje("Se encontraron resultados satisfactoriamente.");
            resp.setLista(list);
            return resp;

        } catch (Exception e) {
            Log.logMessage(e);
            return null;
        }
    }
}
