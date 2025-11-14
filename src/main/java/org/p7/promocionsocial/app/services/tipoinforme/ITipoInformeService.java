package org.p7.promocionsocial.app.services.tipoinforme;

import org.p7.promocionsocial.app.models.TipoInforme;
import org.p7.promocionsocial.app.models.dto.response.ResponseList;

public interface ITipoInformeService {
    public ResponseList<TipoInforme> listarInformeSeguro(String codSeguro);
}
