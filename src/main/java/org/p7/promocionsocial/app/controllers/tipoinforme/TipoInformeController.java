package org.p7.promocionsocial.app.controllers.tipoinforme;

import org.p7.promocionsocial.app.models.TipoInforme;
import org.p7.promocionsocial.app.models.dto.response.ResponseList;
import org.p7.promocionsocial.app.services.tipoinforme.ITipoInformeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/tipoinforme")
public class TipoInformeController {
    @Autowired
    private ITipoInformeService serv;
    @RequestMapping(value = "/listar",method = RequestMethod.GET)
    public ResponseEntity<ResponseList<TipoInforme>> listar(@RequestParam String codigo){
        ResponseList<TipoInforme> resp = new ResponseList<>();
        try{
            resp = serv.listarInformeSeguro(codigo);
            return ResponseEntity.status(HttpStatus.OK).body(resp);
        } catch (Exception e) {
            resp.setCodigo("002");
            resp.setMensaje(e.getMessage());
            resp.setLista(null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
        }
    }
}
