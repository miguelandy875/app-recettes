package com.upg.apprecettes.data.db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Represents a recipe category (e.g. starter, main course, dessert).
 * Maps to the 'categories_recettes' table in the local database.
 */
@Entity(tableName = "categories_recettes")
public class CategorieRecette {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "nom")
    private String nom;

    @ColumnInfo(name = "image")
    private String image;

    // Constructor
    public CategorieRecette(String nom, String image) {
        this.nom = nom;
        this.image = image;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}