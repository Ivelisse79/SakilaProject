/**
 * Menú principal de la aplicación Sakila.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.views;

import java.util.Scanner;

public class MenuPrincipal {

    static Scanner scanner = new Scanner(System.in);

    /**
     * Método principal que inicia la aplicación.
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        int opcion = 0;
        do {
            System.out.println("\n========================================");
            System.out.println("   SISTEMA DE RENTA DE PELICULAS SAKILA");
            System.out.println("========================================");
            System.out.println("1. Gestión de Actores");
            System.out.println("2. Gestión de Películas");
            System.out.println("3. Gestión de Clientes");
            System.out.println("4. Gestión de Rentas");
            System.out.println("5. Gestión de Inventario");
            System.out.println("6. Gestión de Pagos");
            System.out.println("7. Reportes y Estadísticas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: MenuActor.mostrar(); break;
                case 2: MenuFilm.mostrar(); break;
                case 3: MenuCustomer.mostrar(); break;
                case 4: MenuRental.mostrar(); break;
                case 5: MenuInventory.mostrar(); break;
                case 6: MenuPayment.mostrar(); break;
                case 7: MenuReportes.mostrar(); break;
                case 0: System.out.println("¡Hasta luego!"); break;
                default: System.out.println("Opción no válida."); break;
            }
        } while (opcion != 0);
    }
}