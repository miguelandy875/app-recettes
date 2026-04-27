package com.upg.apprecettes.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.upg.apprecettes.data.db.entity.Etape;

import java.util.List;

/**
 * Data Access Object for Etape.
 * Provides all database operations for the 'etapes' table.
 */
@Dao
public interface EtapeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Etape etape);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Etape> etapes);

    @Update
    void update(Etape etape);

    @Delete
    void delete(Etape etape);

    @Query("SELECT * FROM etapes WHERE recette_id = :recetteId ORDER BY numero_etape ASC")
    LiveData<List<Etape>> getEtapesByRecette(int recetteId);

    @Query("DELETE FROM etapes WHERE recette_id = :recetteId")
    void deleteEtapesByRecette(int recetteId);
}