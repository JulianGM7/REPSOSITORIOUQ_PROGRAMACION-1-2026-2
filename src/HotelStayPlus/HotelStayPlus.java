package HotelStayPlus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HotelStayPlus {

    private String nombreComercial;
    private String nit;
    private String direccion;
    private String telefono;
    private String paginaweb;

    private List<Huesped> huespedes;
    private List<Habitacion> habitaciones;
    private List<Reserva> reservas;
    private List<ServicioAdicional> serviciosAdicionales;

    public HotelStayPlus(String nombreComercial, String nit, String direccion, String telefono, String paginaweb) {
        this.nombreComercial = nombreComercial;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
        this.paginaweb = paginaweb;

        this.huespedes = new ArrayList<>();
        this.habitaciones = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.serviciosAdicionales = new ArrayList<>();

    }
    public boolean registrarHuesped(Huesped huesped) {
        if (huesped != null && buscarHuespedPorDocumento(huesped.getDocumentoIdentidad())) == null) {
            huespedes.add(huesped);
            return true;
        }
        return false;
    }

    public Huesped buscarHuespedPorDocumento(String documento) {
        for (Huesped h : huespedes) {
            if (h.getDocumentoIdentidad().equalsIgnoreCase(documento)) {
                return h;
            }
        }
        return null;
    }
    /**
     * Busca un huésped en la lista a partir de su número de teléfono.
     * @param telefono Número de teléfono a buscar
     * @return El huésped encontrado, o null si no existe
     */
    public Huesped buscarHuespedPorTelefono(String telefono) {
        for (int i = 0; i < huespedes.size(); i++) {
            Huesped h = huespedes.get(i);
            if (Objects.equals(h.getTelefono(), telefono)) {
                return h;
            }
        }
        return null;
    }


}
