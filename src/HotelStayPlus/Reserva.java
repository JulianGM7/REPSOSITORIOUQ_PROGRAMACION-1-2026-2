package HotelStayPlus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private String codigoReserva;
    private LocalDate fechaRealizacion;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private String estadoReserva;
    private String metodoPago;
    private double valorTotal;
    private Huesped huesped;
    private List<Habitacion> habitaciones;
    private List<ServicioAdicional> serviciosAdicionales;

    public Reserva(String codigoReserva, LocalDate fechaRealizacion, LocalDate fechaEntrada, LocalDate fechaSalida, String metodoPago, Huesped huesped) {
        this.codigoReserva = codigoReserva;
        this.fechaRealizacion = fechaRealizacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.estadoReserva = "Pendiente";
        this.metodoPago = metodoPago;
        this.huesped = huesped;
        this.habitaciones = new ArrayList<>();
        this.serviciosAdicionales = new ArrayList<>();
        this.valorTotal = 0.0;

        // Asignar reserva al huésped si existe
        if (huesped != null) {
            huesped.agregarReserva(this);
        }
    }

    /**
     * Valida y asigna habitación a la reserva.
     * @param habitacion Habitación a agregar
     * @return true si se agregó correctamente, false si no está disponible
     */
    public boolean agregarHabitacion(Habitacion habitacion) {
        if (habitacion == null) return false;

        // Validar que la habitación se encuentre disponible
        if (!habitacion.estaDisponible()) {
            System.out.println("Error: La habitación no se encuentra disponible.");
            return false;
        }

        if (!habitaciones.contains(habitacion)) {
            habitaciones.add(habitacion);
            recalcularValorTotal();
            return true;
        }
        return false;
    }

    /**
     * Agrega un servicio adicional a la reserva.
     * @param servicioAdicional Servicio a agregar
     * @return true si se agregó, false en caso contrario
     */
    public boolean agregarServicioAdicional(ServicioAdicional servicioAdicional) {
        if (servicioAdicional != null && servicioAdicional.isDisponible()) {
            serviciosAdicionales.add(servicioAdicional);
            recalcularValorTotal();
            return true;
        }
        return false;
    }

    /**
     * Calcula la cantidad de noches de alojamiento.
     * @return cantidad de noches de la estadía (mínimo 1)
     */
    public int calcularCantidadNoches() {
        if (fechaEntrada != null && fechaSalida != null) {
            int noches = fechaSalida.getDayOfMonth() - fechaEntrada.getDayOfMonth();
            if (noches <= 0) {
                return 1;
            }
            return noches;
        }
        return 0;
    }

    /**
     * Recalcula el valor total de la reserva teniendo en cuenta las noches,
     * el precio de las habitaciones, los servicios adicionales y un 10% de descuento
     * si el huésped es cliente frecuente.
     * @return valor total de la reserva
     */
    public double recalcularValorTotal() {
        int noches = calcularCantidadNoches();
        double costoHabitacionesPorNoche = 0.0;

        for (Habitacion habitacion : habitaciones) {
            costoHabitacionesPorNoche += habitacion.getPrecioPorNoche();
        }

        double subtotalHabitaciones = costoHabitacionesPorNoche * noches;
        double subtotalServicios = 0.0;

        for (ServicioAdicional servicioAdicional : serviciosAdicionales) {
            subtotalServicios += servicioAdicional.getPrecio();
        }

        double total = subtotalHabitaciones + subtotalServicios;

        // Descuento a huésped frecuente (10%)
        if (huesped != null && huesped.esHuespedFrecuente()) {
            total *= 0.90;
        }

        this.valorTotal = total;
        return this.valorTotal;
    }

    /**
     * Confirma la reserva y actualiza la disponibilidad de las habitaciones correspondientes.
     * @return true si se confirmó la reserva
     */
    public boolean confirmarReserva() {
        if ("Cancelada".equalsIgnoreCase(this.estadoReserva) || "Finalizada".equalsIgnoreCase(this.estadoReserva)) {
            System.out.println("Error: No se puede confirmar una reserva que está " + this.estadoReserva);
            return false;
        }

        this.estadoReserva = "Confirmada";
        for (Habitacion habitacion : habitaciones) {
            habitacion.setEstadoDisponibilidad("Reservada");
        }
        return true;
    }

    /**
     * Cancela la reserva y libera las habitaciones correspondientes.
     */
    public void cancelarReserva() {
        this.estadoReserva = "Cancelada";
        for (Habitacion habitacion : habitaciones) {
            habitacion.setEstadoDisponibilidad("Disponible");
        }
    }

    // --- Getters y Setters ---

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public LocalDate getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(LocalDate fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getValorTotal() {
        recalcularValorTotal();
        return valorTotal;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public List<ServicioAdicional> getServiciosAdicionales() {
        return serviciosAdicionales;
    }

    @Override
    public String toString() {
        return "Reserva [" + codigoReserva + "] | Realizada: " + fechaRealizacion +
               " | Entrada: " + fechaEntrada + " | Salida: " + fechaSalida +
               " (" + calcularCantidadNoches() + " noches) | Estado: " + estadoReserva +
               " | Total: $" + String.format("%.2f", getValorTotal());
    }
}
