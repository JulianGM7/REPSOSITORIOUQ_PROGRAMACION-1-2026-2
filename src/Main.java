import HotelStayPlus.HotelStayPlus;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        HotelStayPlus hotel = new HotelStayPlus("Stayplus","4587","diagonal a la circunvalar","5874856","www.stayplus.com");




        int opcion;

        do {

            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "========== selecionar una opcion de acuerdo con su nesecidad ==========\n" +
                            "1. registrar nuevo huesped\n" +
                            "2. registrar nueva habitacion \n" +
                            "3. registrar nuevo servicio \n" +
                            "4. crear nueva reserva \n" +
                            "5. confirmar reserva existente\n"+
                            "6. consultar telefono \n"+
                            "7. consultar ingresos por fechas\n"+
                            "8 mostrar informacion general del huesped\n"+
                            "0. Salir\n" +
                            "==========================\n" +
                            "Seleccione una opción:"
            ));

            switch (opcion) {

                case 1:
                    JOptionPane.showMessageDialog(null,
                            "Seleccionaste Agregar número");
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null,
                            "Seleccionaste Mostrar cantidad");
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null,
                            "Seleccionaste Calcular suma");
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null,
                            "Seleccionaste Calcular promedio");
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null,
                            "Seleccionaste Calcur promedio");
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null,
                            "Seleccionaste Calcular promedio");
                    break;

                case 7:JOptionPane.showMessageDialog(null,
                        "Seleccionaste Calcular promedio");
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null,
                            "Seleccionaste Calcular promedio");
                    break;


                case 0:
                    JOptionPane.showMessageDialog(null,
                            "Saliendo del programa...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Opción no válida");
            }

        } while (opcion != 0);
    }
}


}

