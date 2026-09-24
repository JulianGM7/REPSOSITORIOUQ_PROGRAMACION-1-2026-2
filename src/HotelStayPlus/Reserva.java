package HotelStayPlus;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

  }

}
