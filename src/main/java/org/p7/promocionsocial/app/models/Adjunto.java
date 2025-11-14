package org.p7.promocionsocial.app.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Adjunto {
    private String codigo;
    private String nombre;
    private byte[] documento;
    private String urlDrive;
}
