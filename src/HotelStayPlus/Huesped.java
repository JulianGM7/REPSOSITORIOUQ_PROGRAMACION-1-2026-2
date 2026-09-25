package HotelStayPlus;

import java.util.ArrayList;
import java.util.List;

public class Huesped {
    private String nombreCompleto;
    private int documentoIdentidad;
    private int telefono;
    private String correoElectronico;
    private String paisProcedencia;

    private List <Reserva> reservas;

    /**
     * metodo constructor para la clase huesped
     * @param nombreCompleto del huesped
     * @param documentoIdentidad de huesped
     * @param telefono del huesped
     * @param correoElectronico del huesped
     * @param paisProcedencia del huesped
     */

    public Huesped(String nombreCompleto, int documentoIdentidad, int telefono, String correoElectronico, String paisProcedencia) {
        this.nombreCompleto = nombreCompleto;
        this.documentoIdentidad = documentoIdentidad;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.paisProcedencia = paisProcedencia;

        this.huespedes = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(int documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getPaisProcedencia() {
        return paisProcedencia;
    }

    public void setPaisProcedencia(String paisProcedencia) {
        this.paisProcedencia = paisProcedencia;
    }

    public List <Huesped> getHuespedes() {
        return huespedes;
    }

    public void setHuespedes(List<Huesped> huespedes) {
        this.huespedes = huespedes;
    }

    public List <Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List <Reserva> reservas) {
        this.reservas = reservas;
    }
}
