/**
 * Interface estándar CRUD para la base de datos Sakila.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.data;

import java.util.List;

public interface IDataPost<T> {

    /** Inserta un nuevo registro */
    boolean post(T obj);

    /** Actualiza un registro existente */
    boolean put(T obj);

    /** Elimina un registro por ID */
    boolean delete(int id);

    /** Obtiene un registro por ID */
    T get(int id);

    /** Obtiene todos los registros */
    List<T> getAll();
}