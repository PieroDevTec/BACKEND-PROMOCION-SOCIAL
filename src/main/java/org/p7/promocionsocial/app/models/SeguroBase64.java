package org.p7.promocionsocial.app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeguroBase64 {
    private String codigo;
    private String nombre;
    private String imagenBase64;
}
