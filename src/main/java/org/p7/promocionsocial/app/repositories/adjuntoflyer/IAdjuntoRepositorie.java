package org.p7.promocionsocial.app.repositories.adjuntoflyer;

import org.p7.promocionsocial.app.models.Adjunto;

import java.util.List;

public interface IAdjuntoRepositorie {
    public List<Adjunto> listar(String codFlyer);
}
