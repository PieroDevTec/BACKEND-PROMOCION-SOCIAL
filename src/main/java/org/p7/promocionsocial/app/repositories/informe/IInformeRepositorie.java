package org.p7.promocionsocial.app.repositories.informe;

import org.p7.promocionsocial.app.models.Informe;

import java.util.List;

public interface IInformeRepositorie {
    public List<Informe> listar(String codSeguro,String codTipoInforme);
}
