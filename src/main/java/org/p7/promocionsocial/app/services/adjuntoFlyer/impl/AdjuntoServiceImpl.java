package org.p7.promocionsocial.app.services.adjuntoFlyer.impl;

import org.p7.promocionsocial.app.models.Adjunto;
import org.p7.promocionsocial.app.models.AdjuntoBase64;
import org.p7.promocionsocial.app.models.dto.response.ResponseList;
import org.p7.promocionsocial.app.repositories.adjuntoflyer.IAdjuntoRepositorie;
import org.p7.promocionsocial.app.services.adjuntoFlyer.IAdjuntoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdjuntoServiceImpl implements IAdjuntoService {
    @Autowired
    private IAdjuntoRepositorie repo;

    @Override
    public ResponseList<AdjuntoBase64> listarAdjuntos(String codFlyer) {
        ResponseList<AdjuntoBase64> resp = new ResponseList<>();
        try{
            if(codFlyer.length() != 5 ){
                resp.setCodigo("001");
                resp.setMensaje("No se ha identificado los adjuntos del flyer.");
                resp.setLista(null);
                return resp;
            }

            List<Adjunto> listOriginal =  repo.listar(codFlyer);
            if(listOriginal == null){
                resp.setCodigo("001");
                resp.setMensaje("No disponible los adjuntos.");
                resp.setLista(null);
                return resp;
            }
            List<AdjuntoBase64> list = listOriginal.stream()
                    .map(adju -> new AdjuntoBase64(
                            adju.getCodigo(),
                            adju.getNombre(),
                         Base64.getEncoder().encodeToString(adju.getDocumento()),
                         adju.getUrlDrive()
                    ))
                    .collect(Collectors.toList());
            resp.setCodigo("000");
            resp.setMensaje("Se encontraron resultados satisfactoriamente.");
            resp.setLista(list);
            return resp;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resp.setCodigo("002");
            resp.setMensaje(e.getMessage());
            resp.setLista(null);
            return resp;
        }
    }
}
