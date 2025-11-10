package org.p7.promocionsocial.app.services.informesadjuntos;

import org.p7.promocionsocial.app.models.dto.TipoAdjunto;
import org.p7.promocionsocial.app.models.responses.ResponseList;

public interface IInfoAdjuService {
    public ResponseList<TipoAdjunto> listarAdjuntos();
}
