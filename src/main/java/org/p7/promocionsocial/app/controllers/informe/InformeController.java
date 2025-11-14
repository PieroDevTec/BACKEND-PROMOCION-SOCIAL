package org.p7.promocionsocial.app.controllers.informe;

import org.p7.promocionsocial.app.models.Informe;
import org.p7.promocionsocial.app.models.dto.request.InformeRequest;
import org.p7.promocionsocial.app.models.dto.response.ResponseList;
import org.p7.promocionsocial.app.services.informe.IInformeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/informe")
public class InformeController {
    @Autowired
    private IInformeService serv;
    @RequestMapping(value = "/listar",method = RequestMethod.GET)
    public ResponseEntity<ResponseList<Informe>> listar(@RequestBody InformeRequest data){
        ResponseList<Informe> resp = new ResponseList<>();
        try{
            resp = serv.listarInformesSeguro(data.getCodSeguro(),data.getCodTipoInforme());
            return ResponseEntity.status(HttpStatus.OK).body(resp);
        } catch (Exception e) {
            resp.setCodigo("002");
            resp.setMensaje(e.getMessage());
            resp.setLista(null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
        }
    }
}
