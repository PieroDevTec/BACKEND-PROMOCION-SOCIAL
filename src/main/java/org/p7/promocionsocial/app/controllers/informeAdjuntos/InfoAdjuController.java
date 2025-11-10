package org.p7.promocionsocial.app.controllers.informeAdjuntos;

import org.p7.promocionsocial.app.models.dto.TipoAdjunto;
import org.p7.promocionsocial.app.models.responses.ResponseList;
import org.p7.promocionsocial.app.services.informesadjuntos.IInfoAdjuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/infoadju")
public class InfoAdjuController {

    @Autowired
    private IInfoAdjuService service;

    @RequestMapping(value = "/listar",method = RequestMethod.GET)
    public ResponseEntity<ResponseList<TipoAdjunto>> listar(){
        ResponseList<TipoAdjunto> respList = new ResponseList<>();
        try{
            respList  = service.listarAdjuntos();
            return ResponseEntity.status(HttpStatus.OK).body(respList);
        } catch (Exception e) {
            respList.setCodigo("002");
            respList.setMensaje(e.getMessage());
            respList.setLista(null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respList);
        }
    }
}
