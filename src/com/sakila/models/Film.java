/**
 * Modelo que representa la tabla film de Sakila.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.models;

public class Film {

    private int filmId;
    private String title;
    private String description;
    private int releaseYear;
    private int languageId;
    private int originalLanguageId;
    private int rentalDuration;
    private double rentalRate;
    private int length;
    private double replacementCost;
    private String rating;
    private String specialFeatures;
    private String lastUpdate;

    /** Constructor vacío */
    public Film() {}

    /** Constructor con parámetros */
    public Film(int filmId, String title, String description, int releaseYear,
                int languageId, int originalLanguageId, int rentalDuration,
                double rentalRate, int length, double replacementCost,
                String rating, String specialFeatures, String lastUpdate) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.languageId = languageId;
        this.originalLanguageId = originalLanguageId;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.length = length;
        this.replacementCost = replacementCost;
        this.rating = rating;
        this.specialFeatures = specialFeatures;
        this.lastUpdate = lastUpdate;
    }

    // Getters y Setters
    public int getFilmId() { return filmId; }
    public void setFilmId(int filmId) { this.filmId = filmId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getReleaseYear() { return releaseYear; }
    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }

    public int getLanguageId() { return languageId; }
    public void setLanguageId(int languageId) { this.languageId = languageId; }

    public int getOriginalLanguageId() { return originalLanguageId; }
    public void setOriginalLanguageId(int originalLanguageId) { this.originalLanguageId = originalLanguageId; }

    public int getRentalDuration() { return rentalDuration; }
    public void setRentalDuration(int rentalDuration) { this.rentalDuration = rentalDuration; }

    public double getRentalRate() { return rentalRate; }
    public void setRentalRate(double rentalRate) { this.rentalRate = rentalRate; }

    public int getLength() { return length; }
    public void setLength(int length) { this.length = length; }

    public double getReplacementCost() { return replacementCost; }
    public void setReplacementCost(double replacementCost) { this.replacementCost = replacementCost; }

    public String getRating() { return rating; }
    public void setRating(String rating) { this.rating = rating; }

    public String getSpecialFeatures() { return specialFeatures; }
    public void setSpecialFeatures(String specialFeatures) { this.specialFeatures = specialFeatures; }

    public String getLastUpdate() { return lastUpdate; }
    public void setLastUpdate(String lastUpdate) { this.lastUpdate = lastUpdate; }

    /** @return String con los datos de la película */
    @Override
    public String toString() {
        return "Film [ID=" + filmId + ", Titulo=" + title + ", Rating=" + rating + "]";
    }
}