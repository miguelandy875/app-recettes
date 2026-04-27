package com.upg.apprecettes.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.upg.apprecettes.data.db.entity.CategorieRecette;

import java.util.List;

/**
 * Data Access Object for CategorieRecette.
 * Provides all database operations for the 'categories_recettes' table.
 */
@Dao
public interface CategorieRecetteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CategorieRecette categorie);

    @Update
    void update(CategorieRecette categorie);

    @Delete
    void delete(CategorieRecette categorie);

    @Query("SELECT * FROM categories_recettes ORDER BY nom ASC")
    LiveData<List<CategorieRecette>> getAllCategories();

    @Query("SELECT * FROM categories_recettes WHERE id = :id")
    LiveData<CategorieRecette> getCategorieById(int id);
}