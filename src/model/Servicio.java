package model;

/**
 *
 * @author Daniel Barrientos - 1152143
 */
public class Servicio {

    private Integer codigo;
    private String descripcion;

    public Servicio() {
    }

    public Servicio(Integer codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
