package org.p7.promocionsocial.app.services.seguro.impl;

import org.p7.promocionsocial.app.models.Seguro;
import org.p7.promocionsocial.app.models.SeguroBase64;
import org.p7.promocionsocial.app.models.dto.response.ResponseList;
import org.p7.promocionsocial.app.repositories.seguro.ISeguroRepositorie;
import org.p7.promocionsocial.app.services.seguro.ISeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeguroServiceImpl implements ISeguroService {
    @Autowired
    private ISeguroRepositorie repo;
    @Override
    public ResponseList<SeguroBase64> listarSeguros() {
        ResponseList<SeguroBase64> resp = new ResponseList<>();
        try{
            List<Seguro> listOriginal = repo.listar();
            if(listOriginal == null){
                resp.setCodigo("001");
                resp.setMensaje("No disponible la lista de seguros.");
                resp.setLista(null);
                return resp;
            }
            List<SeguroBase64> list = listOriginal.stream()
                    .map(seguro -> new SeguroBase64(
                           seguro.getCodigo(),
                           seguro.getNombre(),
                            Base64.getEncoder().encodeToString(seguro.getImagen())
                    ))
                    .collect(Collectors.toList());
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
