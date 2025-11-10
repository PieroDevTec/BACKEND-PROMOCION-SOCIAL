package org.p7.promocionsocial.app.services.flyer.impl;

import org.p7.promocionsocial.app.models.dto.Flyer;
import org.p7.promocionsocial.app.models.dto.FlyerBase64;
import org.p7.promocionsocial.app.models.responses.ResponseList;
import org.p7.promocionsocial.app.repositories.flyer.IFlyerRepositorie;
import org.p7.promocionsocial.app.services.flyer.IFlyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlyerService implements IFlyerService {

    @Autowired
    private IFlyerRepositorie repo;

    @Override
    public ResponseList<FlyerBase64> listarFlyers() {
        ResponseList<FlyerBase64> resp = new ResponseList<>();
        try{
            List<Flyer> listOriginal = repo.listar();
            if(listOriginal == null){
                resp.setCodigo("001");
                resp.setMensaje("No disponible los Flyers.");
                resp.setLista(null);
                return resp;
            }

            List<FlyerBase64> lista = listOriginal.stream()
                            .map(f -> new FlyerBase64(
                                    f.getCodigo(),
                                    f.getNombre(),
                                    Base64.getEncoder().encodeToString(f.getImagen()),
                                    f.getEstado()
                            ))
                                    .collect(Collectors.toList());
            resp.setCodigo("000");
            resp.setMensaje("Se encontraron resultados satisfactoriamente.");
            resp.setLista(lista);
            return resp;
        } catch (Exception e) {
            resp.setCodigo("002");
            resp.setMensaje(e.getMessage());
            resp.setLista(null);
            return resp;
        }
    }
}
