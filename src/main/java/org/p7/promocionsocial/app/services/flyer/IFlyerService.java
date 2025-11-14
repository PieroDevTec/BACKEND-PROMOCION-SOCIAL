package org.p7.promocionsocial.app.services.flyer;

import org.p7.promocionsocial.app.models.FlyerBase64;
import org.p7.promocionsocial.app.models.dto.response.ResponseList;

public interface IFlyerService {
    public ResponseList<FlyerBase64> listarFlyers();
}
