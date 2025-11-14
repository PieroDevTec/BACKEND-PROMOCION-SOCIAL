package org.p7.promocionsocial.app.services.informe;

import org.p7.promocionsocial.app.models.Informe;
import org.p7.promocionsocial.app.models.dto.response.ResponseList;

public interface IInformeService {
    public ResponseList<Informe> listarInformesSeguro(String codSeguro,String codTipoInforme);
}
