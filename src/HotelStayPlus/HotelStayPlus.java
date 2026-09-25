package HotelStayPlus;

import java.util.ArrayList;
import java.util.List;

public class HotelStayPlus {

    private String nombreComercial;
    private String nit;
    private String direccion;
    private String telefono;
    private String paginaweb;

    private List <Huesped> huespedes;
    private List <Habitacion> habitaciones;
    private List <Reserva> reservas;
    private List <ServicioAdicional> serviciosAdicionales;

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
    // registrar huesped
    public boolean registrarHuesped(Huesped huesped) {
        if (huesped == null && buscarHuespedPorDocumento(huesped.getDocumentoIdentidad()) == null) {
            huesped.add(huesped);
            return true;
        }
        return false;
    }
    // buscar huesped por documento
    public Huesped buscarHuespedPorDocumento(String documento) {
        for (Huesped h : huespedes) {
            if (h.getDocumentoIdentidad().equals(documento)) {
                return h;
            }
        }
        return null;
    }
    public Huesped buscarHuespedPorTelefono(int telefonoBusqueda) {
        for (Huesped h : huespedes) {
            if (h.getTelefono() == telefonoBusqueda) {
                return h;
            }
        }
        return null;
    }
    public boolean registrarHabitacion(Habitacion habitacion) {
        if (habitacion != null && buscarHabitacionPorNumero(habitacion.getNumero()) == null) {
            habitaciones.add(habitacion);
            return true;
        }
        return false;
    }

    public Habitacion buscarHabitacionPorNumero(String numero) {
        for (Habitacion hab : habitaciones) {
            if (hab.getNumero().equalsIgnoreCase(numero)) {
                return hab;
            }
        }
        return null;
    }
    public boolean registrarServicioAdicional(ServicioAdicional servicioAdicional) {
        if (servicio != null && buscarServicioPorCodigo(servicioAdicional.getCodigo()) == null) {
            serviciosAdicionales.add(servicio);
            return true;
        }
        return false;
    }
    public ServicioAdicional buscarServicioPorCodigo(String codigo) {
        for (ServicioAdicional s : serviciosAdicionales) {
            if (s.getCodigo().equalsIgnoreCase(codigo)) {
                return s;
            }
        }
        return null;
    }
    public boolean registrarReserva(Reserva reserva) {
        if (reserva != null && buscarReservaPorCodigo(reserva.getCodigoReserva()) == null) {
            reservas.add(reserva);
            return true;
        }
        return false;
    }
    public Reserva buscarReservaPorCodigo(String codigo) {
        for (Reserva r : reservas) {
            if (r.getCodigoReserva().equalsIgnoreCase(codigo)) {
                return r;
            }
        }
        return null;
    }

    /**
     * Determinar si es un numero perfecto = numero igual a la suma de sus divisores propios excluyendo el mismo número.
     * @param numero
     * @return
     */
    public static boolean esNumeroPerfecto(double numero){
        if (numero <= 1) return false;
        double sumaDivisores = 0;
        for(double i = 1; i <= numero / 2; i++){
            if (numero % i ==0){
                sumaDivisores += i;
            }
        }
        return sumaDivisores == numero;
    }



}
