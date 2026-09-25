package HotelStayPlus;

import java.util.ArrayList;
import java.util.List;

public class Habitacion {
    private String numero;
    private int piso;
    private String TipoHabitacion;
    private int capacidadMaxima;
    private double precioPorNoche;
    private String EstadoHabitacion;


    private List<Reserva> reservas;

    public Habitacion(String numero, int piso, String tipoHabitacion, int capacidadMaxima, double precioPorNoche, String estadoHabitacion) {
        this.numero = numero;
        this.piso = piso;
        TipoHabitacion = tipoHabitacion;
        this.capacidadMaxima = capacidadMaxima;
        this.precioPorNoche = precioPorNoche;
        EstadoHabitacion = estadoHabitacion;


        public boolean estaDisponible () {
            return this.getEstadoHabitacion() == estaDisponible();

            public String toString () {
                String tipo;
                return "Habitacion N° " + numero + " (" + tipo + ") - Piso: " + piso +
                        " | Cap: " + capacidadMaxima + " | Precio/noche: $" + precioPorNoche +
                        " | Estado: " + estado;
            }
        }

        public String getNumero () {
            return numero;
        }

        public void setNumero (String numero){
            this.numero = numero;
        }

        public int getPiso () {
            return piso;
        }

        public void setPiso ( int piso){
            this.piso = piso;
        }

        public String getTipoHabitacion () {
            return TipoHabitacion;
        }

        public void setTipoHabitacion (String tipoHabitacion){
            TipoHabitacion = tipoHabitacion;
        }

        public int getCapacidadMaxima () {
            return capacidadMaxima;
        }

        public void setCapacidadMaxima ( int capacidadMaxima){
            this.capacidadMaxima = capacidadMaxima;
        }

        public double getPrecioPorNoche () {
            return precioPorNoche;
        }

        public void setPrecioPorNoche ( double precioPorNoche){
            this.precioPorNoche = precioPorNoche;
        }

        public String getEstadoHabitacion () {
            return EstadoHabitacion;
        }

        public void setEstadoHabitacion (String estadoHabitacion){
            EstadoHabitacion = estadoHabitacion;
        }
    }

    private Object getEstadoHabitacion() {
    }
}