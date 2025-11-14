package org.p7.promocionsocial.app.services.seguro;

import org.p7.promocionsocial.app.models.Seguro;
import org.p7.promocionsocial.app.models.SeguroBase64;
import org.p7.promocionsocial.app.models.dto.response.ResponseList;

public interface ISeguroService {
    public ResponseList<SeguroBase64> listarSeguros();
}
