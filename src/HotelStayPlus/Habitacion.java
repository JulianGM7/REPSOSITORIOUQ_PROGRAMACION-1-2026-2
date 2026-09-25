package HotelStayPlus;

import java.util.ArrayList;

public class Habitacion {
     private  int codigo;
     private String fechaEntrada;
     private String fechaSalida;
     private String estadoDisponibilidad;

     private list <Reserva> reservas;

    public Habitacion(int codigo, String fechaEntrada, String fechaSalida, String estadoDisponibilidad) {
        this.codigo = codigo;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.estadoDisponibilidad = estadoDisponibilidad;

        this.reservas = new ArrayList<>();

    }
}
