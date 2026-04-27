package com.upg.apprecettes.data.db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * Junction table linking recipes to their ingredients with quantities.
 * Implements the many-to-many relationship between Recette and Ingredient.
 * Maps to the 'recette_ingredients' table in the local database.
 */
@Entity(
        tableName = "recette_ingredients",
        foreignKeys = {
                @ForeignKey(
                        entity = Recette.class,
                        parentColumns = "id",
                        childColumns = "recette_id",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = Ingredient.class,
                        parentColumns = "id",
                        childColumns = "ingredient_id",
                        onDelete = ForeignKey.CASCADE
                )
        },
        indices = {
                @Index("recette_id"),
                @Index("ingredient_id")
        }
)
public class RecetteIngredient {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "recette_id")
    private int recetteId;

    @ColumnInfo(name = "ingredient_id")
    private int ingredientId;

    @ColumnInfo(name = "quantite")
    private float quantite;

    @ColumnInfo(name = "optionnel")
    private boolean optionnel;

    // Constructor
    public RecetteIngredient(int recetteId, int ingredientId,
                             float quantite, boolean optionnel) {
        this.recetteId = recetteId;
        this.ingredientId = ingredientId;
        this.quantite = quantite;
        this.optionnel = optionnel;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getRecetteId() { return recetteId; }
    public void setRecetteId(int recetteId) { this.recetteId = recetteId; }

    public int getIngredientId() { return ingredientId; }
    public void setIngredientId(int ingredientId) { this.ingredientId = ingredientId; }

    public float getQuantite() { return quantite; }
    public void setQuantite(float quantite) { this.quantite = quantite; }

    public boolean isOptionnel() { return optionnel; }
    public void setOptionnel(boolean optionnel) { this.optionnel = optionnel; }
}