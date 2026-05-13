/**
 * Menú de gestión de Clientes.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.views;

import com.sakila.controllers.CustomerController;
import com.sakila.models.Customer;
import java.util.List;
import java.util.Scanner;

public class MenuCustomer {

    static Scanner scanner = new Scanner(System.in);
    static CustomerController controller = new CustomerController();

    /**
     * Muestra el menú de clientes.
     */
    public static void mostrar() {
        int opcion = 0;
        do {
            System.out.println("\n=== GESTIÓN DE CLIENTES ===");
            System.out.println("1. Listar todos los clientes");
            System.out.println("2. Buscar cliente por ID");
            System.out.println("3. Agregar cliente");
            System.out.println("4. Eliminar cliente");
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

    /** Lista todos los clientes */
    private static void listarTodos() {
        List<Customer> lista = controller.listarTodos();
        System.out.println("\n--- LISTA DE CLIENTES ---");
        for (Customer c : lista) {
            System.out.println(c);
        }
        System.out.println("Total: " + lista.size() + " clientes");
    }

    /** Busca un cliente por ID */
    private static void buscar() {
        System.out.print("Ingrese el ID del cliente: ");
        int id = scanner.nextInt();
        Customer customer = controller.buscar(id);
        if (customer != null) {
            System.out.println("Encontrado: " + customer);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    /** Agrega un nuevo cliente */
    private static void agregar() {
        scanner.nextLine();
        System.out.print("ID de la tienda: ");
        int storeId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("ID de dirección: ");
        int addressId = scanner.nextInt();

        boolean resultado = controller.agregar(storeId, nombre, apellido,
                                              email, addressId, true);
        if (resultado) {
            System.out.println("✅ Cliente agregado exitosamente!");
        } else {
            System.out.println("❌ Error al agregar cliente.");
        }
    }

    /** Elimina un cliente por ID */
    private static void eliminar() {
        System.out.print("ID del cliente a eliminar: ");
        int id = scanner.nextInt();
        boolean resultado = controller.eliminar(id);
        if (resultado) {
            System.out.println("✅ Cliente eliminado exitosamente!");
        } else {
            System.out.println("❌ Error al eliminar cliente.");
        }
    }
}