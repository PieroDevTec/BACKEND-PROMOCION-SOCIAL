package org.p7.promocionsocial.app.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlyerBase64 {
    private String codigo;
    private String nombre;
    private String base64;
    private String estado;
}
