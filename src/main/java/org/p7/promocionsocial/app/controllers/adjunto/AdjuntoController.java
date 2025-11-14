package org.p7.promocionsocial.app.controllers.adjunto;

import org.p7.promocionsocial.app.models.AdjuntoBase64;
import org.p7.promocionsocial.app.models.dto.response.ResponseList;
import org.p7.promocionsocial.app.services.adjuntoFlyer.IAdjuntoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/adjunto")
public class AdjuntoController {
    @Autowired
    private IAdjuntoService serv;

    @RequestMapping(value = "/listar",method = RequestMethod.GET)
    public ResponseEntity<ResponseList<AdjuntoBase64>> listar(@RequestParam String codigo){
        ResponseList<AdjuntoBase64> resp = new ResponseList<>();
        try{
            resp = serv.listarAdjuntos(codigo);
            return ResponseEntity.status(HttpStatus.OK).body(resp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resp.setCodigo("002");
            resp.setMensaje(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
        }
    }
}
