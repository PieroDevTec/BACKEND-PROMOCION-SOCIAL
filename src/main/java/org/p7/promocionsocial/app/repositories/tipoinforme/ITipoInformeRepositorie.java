package org.p7.promocionsocial.app.repositories.tipoinforme;

import org.p7.promocionsocial.app.models.TipoInforme;

import java.util.List;

public interface ITipoInformeRepositorie {
    public List<TipoInforme> lista(String codSeguro);
}
