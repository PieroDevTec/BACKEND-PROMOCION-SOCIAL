package org.p7.promocionsocial.app.services.flyer;

import org.p7.promocionsocial.app.models.dto.Flyer;
import org.p7.promocionsocial.app.models.dto.FlyerBase64;
import org.p7.promocionsocial.app.models.responses.ResponseList;

public interface IFlyerService {
    public ResponseList<FlyerBase64> listarFlyers();
}
