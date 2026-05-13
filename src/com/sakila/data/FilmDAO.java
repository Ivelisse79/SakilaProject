/**
 * Clase hija concreta que gestiona el CRUD de la tabla film.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.data;

import com.sakila.models.Film;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class FilmDAO extends DataContext implements IDataPost<Film> {

    /**
     * Inserta una nueva película.
     * @param film objeto Film a insertar
     * @return true si fue exitoso
     */
    @Override
    public boolean post(Film film) {
        String sql = "INSERT INTO film (title, description, release_year, language_id, " +
                     "rental_duration, rental_rate, replacement_cost, rating) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return ejecutarActualizacion(sql,
            film.getTitle(), film.getDescription(), film.getReleaseYear(),
            film.getLanguageId(), film.getRentalDuration(), film.getRentalRate(),
            film.getReplacementCost(), film.getRating());
    }

    /**
     * Actualiza una película existente.
     * @param film objeto Film a actualizar
     * @return true si fue exitoso
     */
    @Override
    public boolean put(Film film) {
        String sql = "UPDATE film SET title=?, description=?, release_year=?, " +
                     "rental_duration=?, rental_rate=?, replacement_cost=?, rating=? " +
                     "WHERE film_id=?";
        return ejecutarActualizacion(sql,
            film.getTitle(), film.getDescription(), film.getReleaseYear(),
            film.getRentalDuration(), film.getRentalRate(),
            film.getReplacementCost(), film.getRating(), film.getFilmId());
    }

    /**
     * Elimina una película por su ID.
     * @param id ID de la película
     * @return true si fue exitoso
     */
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM film WHERE film_id=?";
        return ejecutarActualizacion(sql, id);
    }

    /**
     * Obtiene una película por su ID.
     * @param id ID de la película
     * @return Film encontrado o null
     */
    @Override
    public Film get(int id) {
        String sql = "SELECT * FROM film WHERE film_id=?";
        ResultSet rs = ejecutarConsulta(sql, id);
        try {
            if (rs != null && rs.next()) {
                return new Film(
                    rs.getInt("film_id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getInt("release_year"),
                    rs.getInt("language_id"),
                    rs.getInt("original_language_id"),
                    rs.getInt("rental_duration"),
                    rs.getDouble("rental_rate"),
                    rs.getInt("length"),
                    rs.getDouble("replacement_cost"),
                    rs.getString("rating"),
                    rs.getString("special_features"),
                    rs.getString("last_update")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    /**
     * Obtiene todas las películas.
     * @return Lista de películas
     */
    @Override
    public List<Film> getAll() {
        String sql = "SELECT * FROM film";
        ResultSet rs = ejecutarConsulta(sql);
        List<Film> lista = new ArrayList<>();
        try {
            while (rs != null && rs.next()) {
                lista.add(new Film(
                    rs.getInt("film_id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getInt("release_year"),
                    rs.getInt("language_id"),
                    rs.getInt("original_language_id"),
                    rs.getInt("rental_duration"),
                    rs.getDouble("rental_rate"),
                    rs.getInt("length"),
                    rs.getDouble("replacement_cost"),
                    rs.getString("rating"),
                    rs.getString("special_features"),
                    rs.getString("last_update")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }
}