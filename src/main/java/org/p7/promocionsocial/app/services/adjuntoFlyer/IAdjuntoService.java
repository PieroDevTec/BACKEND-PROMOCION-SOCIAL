package org.p7.promocionsocial.app.services.adjuntoFlyer;

import org.p7.promocionsocial.app.models.AdjuntoBase64;
import org.p7.promocionsocial.app.models.dto.response.ResponseList;

public interface IAdjuntoService {
    public ResponseList<AdjuntoBase64> listarAdjuntos(String codFlyer);
}
