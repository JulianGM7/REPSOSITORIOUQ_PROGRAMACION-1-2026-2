import HotelStayPlus.*;
import javax.swing.JOptionPane;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        HotelStayPlus hotel = new HotelStayPlus("StayPlus", "900123456", "Diagonal a la circunvalar", "5874856", "www.stayplus.com");

        int opcion;

        do {
            String menu = "========== MENU HOTEL STAYPLUS ==========\n" +
                          "1. Registrar nuevo huesped\n" +
                          "2. Registrar nueva habitacion\n" +
                          "3. Registrar nuevo servicio\n" +
                          "4. Crear nueva reserva\n" +
                          "5. Confirmar reserva existente\n" +
                          "6. Consultar telefono (Numero Perfecto)\n" +
                          "7. Consultar ingresos por fecha\n" +
                          "8. Mostrar informacion general del huesped\n" +
                          "0. Salir\n" +
                          "========================================\n" +
                          "Seleccione una opcion:";

            String input = JOptionPane.showInputDialog(null, menu);
            if (input == null) {
                break;
            }

            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    String nom = JOptionPane.showInputDialog("Ingrese el nombre completo:");
                    int doc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el documento de identidad:"));
                    int tel = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el telefono:"));
                    String email = JOptionPane.showInputDialog("Ingrese el correo:");
                    String pais = JOptionPane.showInputDialog("Ingrese el pais de procedencia:");

                    Huesped nuevoHuesped = new Huesped(nom, doc, tel, email, pais);
                    if (hotel.registrarHuesped(nuevoHuesped)) {
                        JOptionPane.showMessageDialog(null, "Huesped registrado con exito.");
                    } else {
                        JOptionPane.showMessageDialog(null, "El huesped ya esta registrado.");
                    }
                    break;

                case 2:
                    String numHab = JOptionPane.showInputDialog("Ingrese el numero de habitacion:");
                    int piso = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el piso:"));
                    String tipo = JOptionPane.showInputDialog("Tipo (Individual, Doble, Suite):");
                    int cap = Integer.parseInt(JOptionPane.showInputDialog("Capacidad de personas:"));
                    double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio por noche:"));

                    Habitacion nuevaHab = new Habitacion(numHab, piso, tipo, cap, precio);
                    if (hotel.registrarHabitacion(nuevaHab)) {
                        JOptionPane.showMessageDialog(null, "Habitacion registrada con exito.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo registrar la habitacion.");
                    }
                    break;

                case 3:
                    int codSrv = Integer.parseInt(JOptionPane.showInputDialog("Codigo del servicio:"));
                    String nomSrv = JOptionPane.showInputDialog("Nombre del servicio:");
                    String descSrv = JOptionPane.showInputDialog("Descripcion del servicio:");
                    double precioSrv = Double.parseDouble(JOptionPane.showInputDialog("Precio del servicio:"));

                    ServicioAdicional nuevoSrv = new ServicioAdicional(codSrv, nomSrv, descSrv, precioSrv, true);
                    if (hotel.registrarServicioAdicional(nuevoSrv)) {
                        JOptionPane.showMessageDialog(null, "Servicio registrado con exito.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo registrar el servicio.");
                    }
                    break;

                case 4:
                    int docHuesped = Integer.parseInt(JOptionPane.showInputDialog("Documento del huesped para la reserva:"));
                    Huesped h = hotel.buscarHuespedPorDocumento(docHuesped);
                    if (h == null) {
                        JOptionPane.showMessageDialog(null, "Huesped no encontrado.");
                        break;
                    }

                    String codRes = JOptionPane.showInputDialog("Codigo para la reserva:");
                    int dias = Integer.parseInt(JOptionPane.showInputDialog("Dias de estadia:"));
                    LocalDate hoy = LocalDate.now();

                    Reserva nuevaRes = new Reserva(codRes, hoy, hoy, hoy.plusDays(dias), "Efectivo", h);

                    String numHabAsignar = JOptionPane.showInputDialog("Numero de habitacion a asignar:");
                    Habitacion habAsignar = hotel.buscarHabitacionPorNumero(numHabAsignar);

                    if (nuevaRes.agregarHabitacion(habAsignar)) {
                        hotel.registrarReserva(nuevaRes);
                        JOptionPane.showMessageDialog(null, "Reserva creada con exito.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo asignar la habitacion.");
                    }
                    break;

                case 5:
                    String codConfirmar = JOptionPane.showInputDialog("Codigo de la reserva a confirmar:");
                    Reserva resConfirmar = hotel.buscarReservaPorCodigo(codConfirmar);

                    if (resConfirmar != null && resConfirmar.confirmarReserva()) {
                        JOptionPane.showMessageDialog(null, "Reserva confirmada con exito.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo confirmar la reserva.");
                    }
                    break;

                case 6:
                    int telConsultar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el telefono a consultar:"));
                    String resTelefono = hotel.consultarTelefonoPerfectoHuesped(telConsultar);
                    JOptionPane.showMessageDialog(null, resTelefono);
                    break;

                case 7:
                    double ingresosHoy = hotel.calcularIngresosPorFechaRealizacion(LocalDate.now());
                    JOptionPane.showMessageDialog(null, "Ingresos acumulados de hoy (" + LocalDate.now() + "): $" + ingresosHoy);
                    break;

                case 8:
                    int docBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese documento del huesped:"));
                    Huesped hEncontrado = hotel.buscarHuespedPorDocumento(docBuscar);
                    if (hEncontrado != null) {
                        JOptionPane.showMessageDialog(null, "Huesped: " + hEncontrado.getNombreCompleto() + "\nCorreo: " + hEncontrado.getCorreoElectronico() + "\nPais: " + hEncontrado.getPaisProcedencia() + "\nReservas realizadas: " + hEncontrado.getReservas().size());
                    } else {
                        JOptionPane.showMessageDialog(null, "Huesped no encontrado.");
                    }
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida.");
            }

        } while (opcion != 0);
    }
}
