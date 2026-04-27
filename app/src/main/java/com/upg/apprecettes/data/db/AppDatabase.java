package com.upg.apprecettes.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.upg.apprecettes.data.db.dao.CategorieRecetteDao;
import com.upg.apprecettes.data.db.dao.EtapeDao;
import com.upg.apprecettes.data.db.dao.IngredientDao;
import com.upg.apprecettes.data.db.dao.RecetteDao;
import com.upg.apprecettes.data.db.dao.RecetteIngredientDao;
import com.upg.apprecettes.data.db.entity.CategorieRecette;
import com.upg.apprecettes.data.db.entity.Etape;
import com.upg.apprecettes.data.db.entity.Ingredient;
import com.upg.apprecettes.data.db.entity.Recette;
import com.upg.apprecettes.data.db.entity.RecetteIngredient;

/**
 * Main database class for the application.
 * Singleton pattern ensures only one database instance exists across the app.
 * Version must be incremented whenever the schema changes.
 */
@Database(
        entities = {
                CategorieRecette.class,
                Ingredient.class,
                Recette.class,
                Etape.class,
                RecetteIngredient.class
        },
        version = 1,
        exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "app_recettes.db";
    private static volatile AppDatabase instance;

    // DAOs
    public abstract CategorieRecetteDao categorieRecetteDao();
    public abstract IngredientDao ingredientDao();
    public abstract RecetteDao recetteDao();
    public abstract EtapeDao etapeDao();
    public abstract RecetteIngredientDao recetteIngredientDao();

    /**
     * Returns the singleton instance of the database.
     * Creates it if it doesn't exist yet.
     */
    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (AppDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            DATABASE_NAME
                    ).build();
                }
            }
        }
        return instance;
    }
}