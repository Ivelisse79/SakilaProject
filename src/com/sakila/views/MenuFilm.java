/**
 * Menú de gestión de Películas.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.views;

import com.sakila.controllers.FilmController;
import com.sakila.models.Film;
import java.util.List;
import java.util.Scanner;

public class MenuFilm {

    static Scanner scanner = new Scanner(System.in);
    static FilmController controller = new FilmController();

    /**
     * Muestra el menú de películas.
     */
    public static void mostrar() {
        int opcion = 0;
        do {
            System.out.println("\n=== GESTIÓN DE PELÍCULAS ===");
            System.out.println("1. Listar todas las películas");
            System.out.println("2. Buscar película por ID");
            System.out.println("3. Agregar película");
            System.out.println("4. Eliminar película");
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

    /** Lista todas las películas */
    private static void listarTodos() {
        List<Film> lista = controller.listarTodos();
        System.out.println("\n--- LISTA DE PELÍCULAS ---");
        for (Film f : lista) {
            System.out.println(f);
        }
        System.out.println("Total: " + lista.size() + " películas");
    }

    /** Busca una película por ID */
    private static void buscar() {
        System.out.print("Ingrese el ID de la película: ");
        int id = scanner.nextInt();
        Film film = controller.buscar(id);
        if (film != null) {
            System.out.println("Encontrada: " + film);
        } else {
            System.out.println("Película no encontrada.");
        }
    }

    /** Agrega una nueva película */
    private static void agregar() {
        scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Año de lanzamiento: ");
        int anio = scanner.nextInt();
        System.out.print("ID del idioma: ");
        int idIdioma = scanner.nextInt();
        System.out.print("Duración de renta (días): ");
        int duracion = scanner.nextInt();
        System.out.print("Precio de renta: ");
        double precio = scanner.nextDouble();
        System.out.print("Costo de reemplazo: ");
        double costo = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Clasificación (G/PG/PG-13/R/NC-17): ");
        String clasificacion = scanner.nextLine();

        boolean resultado = controller.agregar(titulo, descripcion, anio,
                           idIdioma, duracion, precio, costo, clasificacion);
        if (resultado) {
            System.out.println("✅ Película agregada exitosamente!");
        } else {
            System.out.println("❌ Error al agregar película.");
        }
    }

    /** Elimina una película por ID */
    private static void eliminar() {
        System.out.print("ID de la película a eliminar: ");
        int id = scanner.nextInt();
        boolean resultado = controller.eliminar(id);
        if (resultado) {
            System.out.println("✅ Película eliminada exitosamente!");
        } else {
            System.out.println("❌ Error al eliminar película.");
        }
    }
}