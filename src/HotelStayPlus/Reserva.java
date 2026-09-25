package HotelStayPlus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.List;


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

  public Reserva(String codigoReserva, LocalDate fechaRealizacion, LocalDate fechaEntrada,LocalDate fechaSalida, String metodoPago, Huesped huesped){
      this.codigoReserva = codigoReserva;
      this.fechaRealizacion = fechaRealizacion;
      this.fechaEntrada = fechaEntrada;
      this.fechaSalida = fechaSalida;
      this.metodoPago = metodoPago;
      this.huesped = huesped;
      this.habitaciones = new ArrayList<>();
      this.serviciosAdicionales = new ArrayList<>();
      this.valorTotal =0.0;

      // asignar reserva al huesped
      if (huesped != null) {
          huesped.agregarReserva(this);
       }
      }

    /**
     * valida y asigna habitación a la reserva.
     * @param habitacion agregar
     * @return true si se agregó correctamente, false si no esta disponible
     */
      public boolean agregarHabitacion(Habitacion habitacion) {
        if (habitacion == null) retun false;
        if (habitacion.estaDisponible()) {
            System.out.println("Error: La Habitacón N°" + habitacion.getNumero() + "no se encuentra disponible.");
            return false;
        }
        if (!habitaciones.contains(habitacion)) {
            habitaciones.add(habitacion);
            return true;
        }
        return false;
  }

    /**
     * Agregar servicio adicional
     * @param servicioAdicional
     * @return true si se agregó, false si no se agregó
     */
    public boolean agregarServicioAdicional(ServicioAdicional servicioAdicional) {
          if (servicio != null && servicio.isDisponible()){
              servicioAdicionales.add(servicio);
              recalcularValorTotal();
              return true;
          }
          return false;
    }

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


}
