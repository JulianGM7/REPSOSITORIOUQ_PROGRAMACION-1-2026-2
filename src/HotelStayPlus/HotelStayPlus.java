package HotelStayPlus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelStayPlus {
    private String nombreComercial;
    private String nit;
    private String direccion;
    private String telefono;
    private String paginaWeb;

    private List<Huesped> huespedes;
    private List<Habitacion> habitaciones;
    private List<Reserva> reservas;
    private List<ServicioAdicional> serviciosAdicionales;

    public HotelStayPlus(String nombreComercial, String nit, String direccion, String telefono, String paginaWeb) {
        this.nombreComercial = nombreComercial;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;

        this.huespedes = new ArrayList<>();
        this.habitaciones = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.serviciosAdicionales = new ArrayList<>();
    }

    public boolean registrarHuesped(Huesped huesped) {
        if (huesped != null && buscarHuespedPorDocumento(huesped.getDocumentoIdentidad()) == null) {
            huespedes.add(huesped);
            return true;
        }
        return false;
    }

    public Huesped buscarHuespedPorDocumento(int documento) {
        for (Huesped h : huespedes) {
            if (h.getDocumentoIdentidad() == documento) {
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

    public boolean registrarServicioAdicional(ServicioAdicional servicio) {
        if (servicio != null && buscarServicioPorCodigo(servicio.getCodigo()) == null) {
            serviciosAdicionales.add(servicio);
            return true;
        }
        return false;
    }

    public ServicioAdicional buscarServicioPorCodigo(int codigo) {
        for (ServicioAdicional s : serviciosAdicionales) {
            if (s.getCodigo() == codigo) {
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
     * // Metodo para verificar si un numero es perfecto (suma de divisores propios)
     * @param numero
     * @return
     */
    public boolean esNumeroPerfecto(long numero) {
        if (numero <= 1) return false;
        long suma = 0;
        for (long i = 1; i <= numero / 2; i++) {
            if (numero % i == 0) {
                suma += i;
            }
        }
        return suma == numero;
    }

    /**
     * Consulta de telefono perfecto
     * @param telefono
     * @return
     */
    public String consultarTelefonoPerfectoHuesped(int telefono) {
        Huesped h = buscarHuespedPorTelefono(telefono);
        if (h == null) {
            return "No se encontro huesped registrado con el telefono: " + telefono;
        }

        long numTel = h.getTelefono();
        if (esNumeroPerfecto(numTel)) {
            return "El huesped " + h.getNombreCompleto() + " tiene el telefono " + numTel + ". Es un numero perfecto!";
        } else {
            return "El huesped " + h.getNombreCompleto() + " tiene el telefono " + numTel + ". No es un numero perfecto.";
        }
    }

    // Calcular ingresos acumulados por fecha
    public double calcularIngresosPorFechaRealizacion(LocalDate fechaConsulta) {
        if (fechaConsulta == null) return 0.0;
        double acumulado = 0.0;
        for (Reserva r : reservas) {
            if (r.getFechaRealizacion().equals(fechaConsulta) && !"Cancelada".equalsIgnoreCase(r.getEstadoReserva())) {
                acumulado += r.getValorTotal();
            }
        }
        return acumulado;
    }

    // Getters
    public String getNombreComercial() { return nombreComercial; }
    public String getNit() { return nit; }
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }
    public String getPaginaWeb() { return paginaWeb; }

    public List<Huesped> getHuespedes() { return huespedes; }
    public List<Habitacion> getHabitaciones() { return habitaciones; }
    public List<Reserva> getReservas() { return reservas; }
    public List<ServicioAdicional> getServiciosAdicionales() { return serviciosAdicionales; }
}
