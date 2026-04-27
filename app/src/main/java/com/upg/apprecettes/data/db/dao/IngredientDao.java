package com.upg.apprecettes.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.upg.apprecettes.data.db.entity.Ingredient;

import java.util.List;

/**
 * Data Access Object for Ingredient.
 * Provides all database operations for the 'ingredients' table.
 */
@Dao
public interface IngredientDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Ingredient ingredient);

    @Update
    void update(Ingredient ingredient);

    @Delete
    void delete(Ingredient ingredient);

    @Query("SELECT * FROM ingredients ORDER BY nom ASC")
    LiveData<List<Ingredient>> getAllIngredients();

    @Query("SELECT * FROM ingredients WHERE id = :id")
    LiveData<Ingredient> getIngredientById(int id);

    @Query("SELECT * FROM ingredients WHERE nom LIKE '%' || :search || '%'")
    LiveData<List<Ingredient>> searchIngredients(String search);
}