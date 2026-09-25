package HotelStayPlus;

import java.util.ArrayList;

public class ServicioAdicional {
    private int codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private String disponibilidad;


    list <ServicioAdicional> serviosAdiccionales;

    public ServicioAdicional(int codigo, String nombre, String descripcion, double precio, String disponibilidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponibilidad = disponibilidad;

        this.serviosAdiccionales = new ArrayList<>();

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public list<ServicioAdicional> getServiosAdiccionales() {
        return serviosAdiccionales;
    }

    public void setServiosAdiccionales(list<ServicioAdicional> serviosAdiccionales) {
        this.serviosAdiccionales = serviosAdiccionales;
    }
}
