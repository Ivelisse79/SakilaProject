/**
 * Controlador que gestiona las operaciones de Film.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.controllers;

import com.sakila.data.FilmDAO;
import com.sakila.models.Film;
import java.util.List;

public class FilmController {

    private FilmDAO filmDAO;

    /** Constructor */
    public FilmController() {
        this.filmDAO = new FilmDAO();
    }

    /**
     * Agrega una nueva película.
     * @param title Título
     * @param description Descripción
     * @param releaseYear Año de lanzamiento
     * @param languageId ID del idioma
     * @param rentalDuration Duración de renta
     * @param rentalRate Precio de renta
     * @param replacementCost Costo de reemplazo
     * @param rating Clasificación
     * @return true si fue exitoso
     */
    public boolean agregar(String title, String description, int releaseYear,
                           int languageId, int rentalDuration, double rentalRate,
                           double replacementCost, String rating) {
        Film film = new Film();
        film.setTitle(title);
        film.setDescription(description);
        film.setReleaseYear(releaseYear);
        film.setLanguageId(languageId);
        film.setRentalDuration(rentalDuration);
        film.setRentalRate(rentalRate);
        film.setReplacementCost(replacementCost);
        film.setRating(rating);
        return filmDAO.post(film);
    }

    /**
     * Actualiza una película existente.
     * @param film objeto Film a actualizar
     * @return true si fue exitoso
     */
    public boolean actualizar(Film film) {
        return filmDAO.put(film);
    }

    /**
     * Elimina una película por su ID.
     * @param id ID de la película
     * @return true si fue exitoso
     */
    public boolean eliminar(int id) {
        return filmDAO.delete(id);
    }

    /**
     * Busca una película por su ID.
     * @param id ID de la película
     * @return Film encontrado o null
     */
    public Film buscar(int id) {
        return filmDAO.get(id);
    }

    /**
     * Obtiene todas las películas.
     * @return Lista de películas
     */
    public List<Film> listarTodos() {
        return filmDAO.getAll();
    }
}