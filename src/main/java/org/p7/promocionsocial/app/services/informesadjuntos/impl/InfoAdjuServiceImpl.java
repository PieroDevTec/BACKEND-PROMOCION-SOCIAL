package org.p7.promocionsocial.app.services.informesadjuntos.impl;

import org.p7.promocionsocial.app.models.dto.TipoAdjunto;
import org.p7.promocionsocial.app.models.responses.ResponseList;
import org.p7.promocionsocial.app.repositories.informesadjuntos.IInfoAdjuRepositorie;
import org.p7.promocionsocial.app.services.informesadjuntos.IInfoAdjuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoAdjuServiceImpl implements IInfoAdjuService {

    @Autowired
    private IInfoAdjuRepositorie repo;

    @Override
    public ResponseList<TipoAdjunto> listarAdjuntos() {
        ResponseList<TipoAdjunto> resp = new ResponseList<>();
        try{
            List<TipoAdjunto> list = repo.listar();
            if(list == null){
                resp.setCodigo("001");
                resp.setMensaje("No disponible los tipos de adjuntos.");
                resp.setLista(list);
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
