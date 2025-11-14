package org.p7.promocionsocial.app.models;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AdjuntoBase64 {
    private String codigo;
    private String nombre;
    private String documentoBase64;
    private String urlDrive;
}
