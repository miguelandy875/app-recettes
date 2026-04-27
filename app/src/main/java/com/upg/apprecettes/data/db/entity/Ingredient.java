package com.upg.apprecettes.data.db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Represents a cooking ingredient.
 * Maps to the 'ingredients' table in the local database.
 */
@Entity(tableName = "ingredients")
public class Ingredient {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "nom")
    private String nom;

    @ColumnInfo(name = "unite")
    private String unite;

    @ColumnInfo(name = "calories_par_unite")
    private float caloriesParUnite;

    // Constructor
    public Ingredient(String nom, String unite, float caloriesParUnite) {
        this.nom = nom;
        this.unite = unite;
        this.caloriesParUnite = caloriesParUnite;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getUnite() { return unite; }
    public void setUnite(String unite) { this.unite = unite; }

    public float getCaloriesParUnite() { return caloriesParUnite; }
    public void setCaloriesParUnite(float caloriesParUnite) {
        this.caloriesParUnite = caloriesParUnite;
    }
}