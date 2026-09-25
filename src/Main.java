import HotelStayPlus.HotelStayPlus;

<<<<<<< HEAD
public class Main {
    public static void main(String[] args) {
=======
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        HotelStayPlus hotel = new HotelStayPlus("Stayplus","4587","diagonal a la circunvalar","5874856","www.stayplus.com");
>>>>>>> 990af1821f3090be169ba06e9195c1a27f309f58


        int opcion;

        do {

            System.out.println("\n===== SISTEMA DEVPLUS =====");
            System.out.println("1.  Registrar cliente");
            System.out.println("2.  Registrar desarrollador");
            System.out.println("3.  Registrar servicio adicional");
            System.out.println("4.  Registrar proyecto");
            System.out.println("5.  Asignar desarrollador a proyecto");
            System.out.println("6.  Agregar servicio adicional a un proyecto");
            System.out.println("7.  Confirmar proyecto (calcula valor total)");
            System.out.println("8.  Consultar si el telefono de un cliente es numero perfecto");
            System.out.println("9.  Consultar ingresos por fecha de solicitud");
            System.out.println("10. Listar clientes");
            System.out.println("11. Listar desarrolladores");
            System.out.println("12. Listar proyectos");
            System.out.println("13. Listar servicios adicionales");
            System.out.println("0.  Salir");
        } while (opcion != 0);

        System.out.println("Fin del programa. Gracias por usar DevPlus.");
    }


<<<<<<< HEAD
=======
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


>>>>>>> 990af1821f3090be169ba06e9195c1a27f309f58
}

