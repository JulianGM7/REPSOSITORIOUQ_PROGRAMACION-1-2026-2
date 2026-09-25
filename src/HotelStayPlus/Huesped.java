package HotelStayPlus;

import java.util.ArrayList;
import java.util.List;

public class Huesped {
    private String nombreCompleto;
    private int documentoIdentidad;
    private int telefono;
    private String correoElectronico;
    private String paisProcedencia;
    private List<Reserva> reservas;

    public Huesped(String nombreCompleto, int documentoIdentidad, int telefono, String correoElectronico, String paisProcedencia) {
        this.nombreCompleto = nombreCompleto;
        this.documentoIdentidad = documentoIdentidad;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.paisProcedencia = paisProcedencia;
        this.reservas = new ArrayList<>();
    }

    /**
     * agendar reserva, huesped frecuente
     * @param reserva
     */
    public void agregarReserva(Reserva reserva) {
        if (!this.reservas.contains(reserva)) {
            this.reservas.add(reserva);
        }
    }

    public boolean esHuespedFrecuente() {
        return this.reservas.size() > 2;
    }

    // Getters y Setters
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

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
