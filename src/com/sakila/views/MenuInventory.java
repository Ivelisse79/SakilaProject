/**
 * Menú de gestión de Inventario.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.views;

import com.sakila.controllers.InventoryController;
import com.sakila.models.Inventory;
import java.util.List;
import java.util.Scanner;

public class MenuInventory {

    static Scanner scanner = new Scanner(System.in);
    static InventoryController controller = new InventoryController();

    /**
     * Muestra el menú de inventario.
     */
    public static void mostrar() {
        int opcion = 0;
        do {
            System.out.println("\n=== GESTIÓN DE INVENTARIO ===");
            System.out.println("1. Listar todo el inventario");
            System.out.println("2. Buscar inventario por ID");
            System.out.println("3. Agregar inventario");
            System.out.println("4. Eliminar inventario");
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

    /** Lista todo el inventario */
    private static void listarTodos() {
        List<Inventory> lista = controller.listarTodos();
        System.out.println("\n--- LISTA DE INVENTARIO ---");
        for (Inventory i : lista) {
            System.out.println(i);
        }
        System.out.println("Total: " + lista.size() + " registros");
    }

    /** Busca un inventario por ID */
    private static void buscar() {
        System.out.print("Ingrese el ID del inventario: ");
        int id = scanner.nextInt();
        Inventory inventory = controller.buscar(id);
        if (inventory != null) {
            System.out.println("Encontrado: " + inventory);
        } else {
            System.out.println("Inventario no encontrado.");
        }
    }

    /** Agrega un nuevo inventario */
    private static void agregar() {
        System.out.print("ID de la película: ");
        int filmId = scanner.nextInt();
        System.out.print("ID de la tienda: ");
        int storeId = scanner.nextInt();

        boolean resultado = controller.agregar(filmId, storeId);
        if (resultado) {
            System.out.println("✅ Inventario agregado exitosamente!");
        } else {
            System.out.println("❌ Error al agregar inventario.");
        }
    }

    /** Elimina un inventario por ID */
    private static void eliminar() {
        System.out.print("ID del inventario a eliminar: ");
        int id = scanner.nextInt();
        boolean resultado = controller.eliminar(id);
        if (resultado) {
            System.out.println("✅ Inventario eliminado exitosamente!");
        } else {
            System.out.println("❌ Error al eliminar inventario.");
        }
    }
}