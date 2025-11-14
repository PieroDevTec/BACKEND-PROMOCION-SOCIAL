package org.p7.promocionsocial.app.services.informesadjuntos;

import org.p7.promocionsocial.app.models.TipoAdjunto;
import org.p7.promocionsocial.app.models.dto.response.ResponseList;

public interface IInfoAdjuService {
    public ResponseList<TipoAdjunto> listarAdjuntos();
}
