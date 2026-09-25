import HotelStayPlus.HotelStayPlus;

public class Main {
    public static void main(String[] args) {


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


}

