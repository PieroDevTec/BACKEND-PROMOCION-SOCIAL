package org.p7.promocionsocial.app.controllers.flyer;

import org.p7.promocionsocial.app.models.dto.Flyer;
import org.p7.promocionsocial.app.models.dto.FlyerBase64;
import org.p7.promocionsocial.app.models.responses.ResponseList;
import org.p7.promocionsocial.app.services.flyer.IFlyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/flyer")
public class FlyerController {

    @Autowired
    private IFlyerService service;

    @RequestMapping(value = "/listar",method = RequestMethod.GET)
    public ResponseEntity<ResponseList<FlyerBase64>> listar(){
        ResponseList<FlyerBase64> resp = new ResponseList<>();
        try{
            resp = service.listarFlyers();
            return ResponseEntity.status(HttpStatus.OK).body(resp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resp.setCodigo("002");
            resp.setMensaje(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
        }

    }
}
