package HotelStayPlus;

import java.time.LocalDate;
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

    /**
     * Consulta a un huesped por su telefono y analiza si los digitos de telefono son numero perfecto
     * @param telefono
     * @return
     */
    public String consultarTelefonoPerfectoHuesped(String telefono) {
        Huesped h = buscarHuespedPorTelefono(telefono);
        if (h == null) {
            return "No se encontró ningún huésped registrado con el teléfono: " + telefono;
        }
    }
        try {
        double numeroTel = double.parseDouble(soloDigitos);
        boolean esPerfecto = esNumeroPerfecto(numeroTel);
        if (esPerfecto) {
            return "El huésped " + h.getNombreCompleto() + " tiene el teléfono " + h.getTelefono() +
                    " (valor numérico " + numeroTel + "). ¡SI ES UN NÚMERO PERFECTO!";
        } else {
            return "El huésped " + h.getNombreCompleto() + " tiene el teléfono " + h.getTelefono() +
                    " (valor numérico " + numeroTel + "). NO es un número perfecto.";
        }
    } catch (NumberFormatException e) {
        return "El número de teléfono de " + h.getNombreCompleto() + " (" + soloDigitos + ") es demasiado grande para evaluarlo numéricamente.";
    }

    /**
     * recorrer reservas registradas
     * @param fechaConsulta
     * @return
     */
    public double calcularIngresosPorFechaRealizacion(LocalDate fechaConsulta) {
        if (fechaConsulta == null) return 0.0;
        double ingresosAcumulados = 0.0;
        for (Reserva r : reservas) {
            // Se toman en cuenta las reservas que no estén canceladas
            if (r.getFechaRealizacion().equals(fechaConsulta) && r.getEstado() != EstadoReserva.CANCELADA) {
                ingresosAcumulados += r.getValorTotal();
            }
        }
        return ingresosAcumulados;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPaginaweb() {
        return paginaweb;
    }

    public void setPaginaweb(String paginaweb) {
        this.paginaweb = paginaweb;
    }

    public List<Huesped> getHuespedes() {
        return huespedes;
    }

    public void setHuespedes(List<Huesped> huespedes) {
        this.huespedes = huespedes;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<ServicioAdicional> getServiciosAdicionales() {
        return serviciosAdicionales;
    }

    public void setServiciosAdicionales(List<ServicioAdicional> serviciosAdicionales) {
        this.serviciosAdicionales = serviciosAdicionales;
    }

    public NumberFormatException getE() {
        return e;
    }

    public void setE(NumberFormatException e) {
        this.e = e;
    }
}






}
