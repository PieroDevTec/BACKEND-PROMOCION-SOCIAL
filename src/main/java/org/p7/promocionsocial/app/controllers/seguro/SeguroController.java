package org.p7.promocionsocial.app.controllers.seguro;

import org.p7.promocionsocial.app.models.Seguro;
import org.p7.promocionsocial.app.models.SeguroBase64;
import org.p7.promocionsocial.app.models.dto.response.ResponseList;
import org.p7.promocionsocial.app.services.seguro.ISeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/seguro")
public class SeguroController {

    @Autowired
    private ISeguroService servi;

    @RequestMapping(value = "/listar",method = RequestMethod.GET)
    public ResponseEntity<ResponseList<SeguroBase64>> listar(){
        ResponseList<SeguroBase64> resp  = new ResponseList<>();
        try{
            resp = servi.listarSeguros();
            if(resp == null || resp.getCodigo().equalsIgnoreCase("001")){
                resp.setCodigo("001");
                resp.setMensaje("No disponible los seguros");
                resp.setLista(null);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
            }
            if(resp.getCodigo().equalsIgnoreCase("002")){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
            }
            return ResponseEntity.status(HttpStatus.OK).body(resp);
        } catch (Exception e) {
            resp.setMensaje("002");
            resp.setMensaje(e.getMessage());
            resp.setLista(null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
        }
    }
}
