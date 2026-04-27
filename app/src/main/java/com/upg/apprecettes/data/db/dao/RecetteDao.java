package com.upg.apprecettes.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.upg.apprecettes.data.db.entity.Recette;

import java.util.List;

/**
 * Data Access Object for Recette.
 * Provides all database operations for the 'recettes' table.
 * Includes filtering by category, difficulty, and favourites.
 */
@Dao
public interface RecetteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Recette recette);

    @Update
    void update(Recette recette);

    @Delete
    void delete(Recette recette);

    @Query("SELECT * FROM recettes ORDER BY titre ASC")
    LiveData<List<Recette>> getAllRecettes();

    @Query("SELECT * FROM recettes WHERE id = :id")
    LiveData<Recette> getRecetteById(int id);

    @Query("SELECT * FROM recettes WHERE categorie_id = :categorieId ORDER BY titre ASC")
    LiveData<List<Recette>> getRecettesByCategorie(int categorieId);

    @Query("SELECT * FROM recettes WHERE difficulte = :difficulte ORDER BY titre ASC")
    LiveData<List<Recette>> getRecettesByDifficulte(int difficulte);

    @Query("SELECT * FROM recettes WHERE est_favori = 1 ORDER BY titre ASC")
    LiveData<List<Recette>> getFavoris();

    @Query("SELECT * FROM recettes WHERE titre LIKE '%' || :search || '%' ORDER BY titre ASC")
    LiveData<List<Recette>> searchRecettes(String search);

    @Query("UPDATE recettes SET est_favori = :estFavori WHERE id = :id")
    void updateFavori(int id, boolean estFavori);

    @Query("SELECT COUNT(*) FROM recettes")
    LiveData<Integer> getTotalRecettes();

    @Query("SELECT COUNT(*) FROM recettes WHERE est_favori = 1")
    LiveData<Integer> getTotalFavoris();
}