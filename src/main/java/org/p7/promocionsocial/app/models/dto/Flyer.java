package org.p7.promocionsocial.app.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Flyer {
    private String codigo;
    private String nombre;
    private byte[] imagen;
    private String estado;
}
