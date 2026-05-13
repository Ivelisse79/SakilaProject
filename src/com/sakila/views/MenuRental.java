/**
 * Menú de gestión de Rentas.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.views;

import com.sakila.controllers.RentalController;
import com.sakila.models.Rental;
import java.util.List;
import java.util.Scanner;

public class MenuRental {

    static Scanner scanner = new Scanner(System.in);
    static RentalController controller = new RentalController();

    /**
     * Muestra el menú de rentas.
     */
    public static void mostrar() {
        int opcion = 0;
        do {
            System.out.println("\n=== GESTIÓN DE RENTAS ===");
            System.out.println("1. Listar todas las rentas");
            System.out.println("2. Buscar renta por ID");
            System.out.println("3. Agregar renta");
            System.out.println("4. Eliminar renta");
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

    /** Lista todas las rentas */
    private static void listarTodos() {
        List<Rental> lista = controller.listarTodos();
        System.out.println("\n--- LISTA DE RENTAS ---");
        for (Rental r : lista) {
            System.out.println(r);
        }
        System.out.println("Total: " + lista.size() + " rentas");
    }

    /** Busca una renta por ID */
    private static void buscar() {
        System.out.print("Ingrese el ID de la renta: ");
        int id = scanner.nextInt();
        Rental rental = controller.buscar(id);
        if (rental != null) {
            System.out.println("Encontrada: " + rental);
        } else {
            System.out.println("Renta no encontrada.");
        }
    }

    /** Agrega una nueva renta */
    private static void agregar() {
        scanner.nextLine();
        System.out.print("Fecha de renta (YYYY-MM-DD): ");
        String fechaRenta = scanner.nextLine();
        System.out.print("ID del inventario: ");
        int inventarioId = scanner.nextInt();
        System.out.print("ID del cliente: ");
        int clienteId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Fecha de devolución (YYYY-MM-DD): ");
        String fechaDevolucion = scanner.nextLine();
        System.out.print("ID del empleado: ");
        int staffId = scanner.nextInt();

        boolean resultado = controller.agregar(fechaRenta, inventarioId,
                                              clienteId, fechaDevolucion, staffId);
        if (resultado) {
            System.out.println("✅ Renta agregada exitosamente!");
        } else {
            System.out.println("❌ Error al agregar renta.");
        }
    }

    /** Elimina una renta por ID */
    private static void eliminar() {
        System.out.print("ID de la renta a eliminar: ");
        int id = scanner.nextInt();
        boolean resultado = controller.eliminar(id);
        if (resultado) {
            System.out.println("✅ Renta eliminada exitosamente!");
        } else {
            System.out.println("❌ Error al eliminar renta.");
        }
    }
}