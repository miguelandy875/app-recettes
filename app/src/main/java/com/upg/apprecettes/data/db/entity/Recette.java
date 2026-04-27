package com.upg.apprecettes.data.db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * Represents a recipe created by a user.
 * Maps to the 'recettes' table in the local database.
 * References 'categories_recettes' via foreign key.
 */
@Entity(
        tableName = "recettes",
        foreignKeys = @ForeignKey(
                entity = CategorieRecette.class,
                parentColumns = "id",
                childColumns = "categorie_id",
                onDelete = ForeignKey.CASCADE
        ),
        indices = {@Index("categorie_id")}
)
public class Recette {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "titre")
    private String titre;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "temps_preparation")
    private int tempsPreparation;

    @ColumnInfo(name = "temps_cuisson")
    private int tempsCuisson;

    @ColumnInfo(name = "difficulte")
    private int difficulte; // 1 to 5

    @ColumnInfo(name = "nombre_personnes")
    private int nombrePersonnes;

    @ColumnInfo(name = "categorie_id")
    private int categorieId;

    @ColumnInfo(name = "image")
    private String image;

    @ColumnInfo(name = "est_favori")
    private boolean estFavori;

    // Constructor
    public Recette(String titre, String description, int tempsPreparation,
                   int tempsCuisson, int difficulte, int nombrePersonnes,
                   int categorieId, String image) {
        this.titre = titre;
        this.description = description;
        this.tempsPreparation = tempsPreparation;
        this.tempsCuisson = tempsCuisson;
        this.difficulte = difficulte;
        this.nombrePersonnes = nombrePersonnes;
        this.categorieId = categorieId;
        this.image = image;
        this.estFavori = false;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getTempsPreparation() { return tempsPreparation; }
    public void setTempsPreparation(int tempsPreparation) {
        this.tempsPreparation = tempsPreparation;
    }

    public int getTempsCuisson() { return tempsCuisson; }
    public void setTempsCuisson(int tempsCuisson) {
        this.tempsCuisson = tempsCuisson;
    }

    public int getDifficulte() { return difficulte; }
    public void setDifficulte(int difficulte) { this.difficulte = difficulte; }

    public int getNombrePersonnes() { return nombrePersonnes; }
    public void setNombrePersonnes(int nombrePersonnes) {
        this.nombrePersonnes = nombrePersonnes;
    }

    public int getCategorieId() { return categorieId; }
    public void setCategorieId(int categorieId) { this.categorieId = categorieId; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public boolean isEstFavori() { return estFavori; }
    public void setEstFavori(boolean estFavori) { this.estFavori = estFavori; }
}