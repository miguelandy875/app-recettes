package com.upg.apprecettes.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.upg.apprecettes.data.db.entity.RecetteIngredient;

import java.util.List;

/**
 * Data Access Object for RecetteIngredient.
 * Provides all database operations for the 'recette_ingredients' junction table.
 */
@Dao
public interface RecetteIngredientDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(RecetteIngredient recetteIngredient);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<RecetteIngredient> recetteIngredients);

    @Delete
    void delete(RecetteIngredient recetteIngredient);

    @Query("SELECT * FROM recette_ingredients WHERE recette_id = :recetteId")
    LiveData<List<RecetteIngredient>> getIngredientsByRecette(int recetteId);

    @Query("DELETE FROM recette_ingredients WHERE recette_id = :recetteId")
    void deleteIngredientsByRecette(int recetteId);
}