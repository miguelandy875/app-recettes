package com.upg.apprecettes.data.db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * Represents a single step in a recipe's preparation process.
 * Maps to the 'etapes' table in the local database.
 * References 'recettes' via foreign key.
 */
@Entity(
        tableName = "etapes",
        foreignKeys = @ForeignKey(
                entity = Recette.class,
                parentColumns = "id",
                childColumns = "recette_id",
                onDelete = ForeignKey.CASCADE
        ),
        indices = {@Index("recette_id")}
)
public class Etape {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "recette_id")
    private int recetteId;

    @ColumnInfo(name = "numero_etape")
    private int numeroEtape;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "image")
    private String image;

    // Constructor
    public Etape(int recetteId, int numeroEtape, String description, String image) {
        this.recetteId = recetteId;
        this.numeroEtape = numeroEtape;
        this.description = description;
        this.image = image;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getRecetteId() { return recetteId; }
    public void setRecetteId(int recetteId) { this.recetteId = recetteId; }

    public int getNumeroEtape() { return numeroEtape; }
    public void setNumeroEtape(int numeroEtape) { this.numeroEtape = numeroEtape; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}