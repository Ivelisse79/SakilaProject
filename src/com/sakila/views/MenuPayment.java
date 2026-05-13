/**
 * Menú de gestión de Pagos.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.views;

import com.sakila.controllers.PaymentController;
import com.sakila.models.Payment;
import java.util.List;
import java.util.Scanner;

public class MenuPayment {

    static Scanner scanner = new Scanner(System.in);
    static PaymentController controller = new PaymentController();

    /**
     * Muestra el menú de pagos.
     */
    public static void mostrar() {
        int opcion = 0;
        do {
            System.out.println("\n=== GESTIÓN DE PAGOS ===");
            System.out.println("1. Listar todos los pagos");
            System.out.println("2. Buscar pago por ID");
            System.out.println("3. Agregar pago");
            System.out.println("4. Eliminar pago");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: listarTodos(); break;
                case 2: buscar(); break;
                case 3: agregar(); break;
                case 4: eliminar(); break;
                case 0: break;
                default: System.out.println("Opción no válida."); break;
            }
        } while (opcion != 0);
    }

    /** Lista todos los pagos */
    private static void listarTodos() {
        List<Payment> lista = controller.listarTodos();
        System.out.println("\n--- LISTA DE PAGOS ---");
        for (Payment p : lista) {
            System.out.println(p);
        }
        System.out.println("Total: " + lista.size() + " pagos");
    }

    /** Busca un pago por ID */
    private static void buscar() {
        System.out.print("Ingrese el ID del pago: ");
        int id = scanner.nextInt();
        Payment payment = controller.buscar(id);
        if (payment != null) {
            System.out.println("Encontrado: " + payment);
        } else {
            System.out.println("Pago no encontrado.");
        }
    }

    /** Agrega un nuevo pago */
    private static void agregar() {
        System.out.print("ID del cliente: ");
        int clienteId = scanner.nextInt();
        System.out.print("ID del empleado: ");
        int staffId = scanner.nextInt();
        System.out.print("ID de la renta: ");
        int rentalId = scanner.nextInt();
        System.out.print("Monto: ");
        double monto = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Fecha de pago (YYYY-MM-DD): ");
        String fecha = scanner.nextLine();

        boolean resultado = controller.agregar(clienteId, staffId,
                                              rentalId, monto, fecha);
        if (resultado) {
            System.out.println("✅ Pago agregado exitosamente!");
        } else {
            System.out.println("❌ Error al agregar pago.");
        }
    }

    /** Elimina un pago por ID */
    private static void eliminar() {
        System.out.print("ID del pago a eliminar: ");
        int id = scanner.nextInt();
        boolean resultado = controller.eliminar(id);
        if (resultado) {
            System.out.println("✅ Pago eliminado exitosamente!");
        } else {
            System.out.println("❌ Error al eliminar pago.");
        }
    }
}