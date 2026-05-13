/**
 * Menú de gestión de Actores.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.views;

import com.sakila.controllers.ActorController;
import com.sakila.models.Actor;
import java.util.List;
import java.util.Scanner;

public class MenuActor {

    static Scanner scanner = new Scanner(System.in);
    static ActorController controller = new ActorController();

    /**
     * Muestra el menú de actores.
     */
    public static void mostrar() {
        int opcion = 0;
        do {
            System.out.println("\n=== GESTIÓN DE ACTORES ===");
            System.out.println("1. Listar todos los actores");
            System.out.println("2. Buscar actor por ID");
            System.out.println("3. Agregar actor");
            System.out.println("4. Actualizar actor");
            System.out.println("5. Eliminar actor");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: listarTodos(); break;
                case 2: buscar(); break;
                case 3: agregar(); break;
                case 4: actualizar(); break;
                case 5: eliminar(); break;
                case 0: break;
                default: System.out.println("Opción no válida."); break;
            }
        } while (opcion != 0);
    }

    /** Lista todos los actores */
    private static void listarTodos() {
        List<Actor> lista = controller.listarTodos();
        System.out.println("\n--- LISTA DE ACTORES ---");
        for (Actor a : lista) {
            System.out.println(a);
        }
        System.out.println("Total: " + lista.size() + " actores");
    }

    /** Busca un actor por ID */
    private static void buscar() {
        System.out.print("Ingrese el ID del actor: ");
        int id = scanner.nextInt();
        Actor actor = controller.buscar(id);
        if (actor != null) {
            System.out.println("Encontrado: " + actor);
        } else {
            System.out.println("Actor no encontrado.");
        }
    }

    /** Agrega un nuevo actor */
    private static void agregar() {
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        boolean resultado = controller.agregar(nombre, apellido);
        if (resultado) {
            System.out.println("✅ Actor agregado exitosamente!");
        } else {
            System.out.println("❌ Error al agregar actor.");
        }
    }

    /** Actualiza un actor existente */
    private static void actualizar() {
        System.out.print("ID del actor a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Nuevo apellido: ");
        String apellido = scanner.nextLine();
        boolean resultado = controller.actualizar(id, nombre, apellido);
        if (resultado) {
            System.out.println("✅ Actor actualizado exitosamente!");
        } else {
            System.out.println("❌ Error al actualizar actor.");
        }
    }

    /** Elimina un actor por ID */
    private static void eliminar() {
        System.out.print("ID del actor a eliminar: ");
        int id = scanner.nextInt();
        boolean resultado = controller.eliminar(id);
        if (resultado) {
            System.out.println("✅ Actor eliminado exitosamente!");
        } else {
            System.out.println("❌ Error al eliminar actor.");
        }
    }
}