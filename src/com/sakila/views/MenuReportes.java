/**
 * Menú de reportes y estadísticas.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.views;

import com.sakila.reports.ReporteGeneral;
import java.util.Scanner;

public class MenuReportes {

    static Scanner scanner = new Scanner(System.in);
    static ReporteGeneral reporte = new ReporteGeneral();

    /**
     * Muestra el menú de reportes.
     */
    public static void mostrar() {
        int opcion = 0;
        do {
            System.out.println("\n=== REPORTES Y ESTADÍSTICAS ===");
            System.out.println("1. Listar tabla y exportar CSV");
            System.out.println("2. Listar tabla y exportar JSON");
            System.out.println("3. Top 10 películas en inventario");
            System.out.println("4. Top 10 clientes con más rentas");
            System.out.println("5. Top 10 clientes por pagos");
            System.out.println("6. Top 10 actores con más películas");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: exportarCSV(); break;
                case 2: exportarJSON(); break;
                case 3: reporte.estadisticasInventario(); break;
                case 4: reporte.estadisticasRentasPorCliente(); break;
                case 5: reporte.estadisticasPagosPorCliente(); break;
                case 6: reporte.estadisticasActores(); break;
                case 0: break;
                default: System.out.println("Opción no válida."); break;
            }
        } while (opcion != 0);
    }

    /** Exporta una tabla a CSV */
    private static void exportarCSV() {
        scanner.nextLine();
        System.out.print("Nombre de la tabla: ");
        String tabla = scanner.nextLine();
        reporte.listarTabla(tabla);
        reporte.exportarCSV(tabla);
    }

    /** Exporta una tabla a JSON */
    private static void exportarJSON() {
        scanner.nextLine();
        System.out.print("Nombre de la tabla: ");
        String tabla = scanner.nextLine();
        reporte.listarTabla(tabla);
        reporte.exportarJSON(tabla);
    }
}