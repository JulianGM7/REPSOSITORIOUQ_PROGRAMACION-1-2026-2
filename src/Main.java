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
                            "Usted ha sido registrado exitosamente");
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null,
                            "su habitacion ha sido registrada exitosamente");
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null,
                            "su sericio ha sido registrado exitosamente");
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null,
                            "su reserva ha sido registrada exitosamente");
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null,
                            "Su confirmacion de su reserva ha sido exitosa ");
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null,
                            "Seleccionaste Calcular promedio");
                    break;

                case 7:JOptionPane.showMessageDialog(null,
                        "El numero total de ingresos a la fecha es de ");
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null,
                            "la infromacion general del huesped es ");
                    break;


                case 0:
                    JOptionPane.showMessageDialog(null,
                            "te damos las gracias por acogerte ");
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Opción no válida");
            }

        } while (opcion != 0);
    }
}




