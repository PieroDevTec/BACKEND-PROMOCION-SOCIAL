package org.p7.promocionsocial.app.models.dto.response;


public class Response {
    private String applicacion;
    private String codigo;
    private String mensaje;

    public String getApplicacion() {
        return "PROMOCION SOCIAL";
    }

    public void setApplicacion(String applicacion) {
        this.applicacion = applicacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
