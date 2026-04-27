package com.upg.apprecettes.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.upg.apprecettes.data.db.AppDatabase;
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

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Repository acting as the single source of truth for all data operations.
 * Abstracts the database layer from the ViewModel.
 * All write operations run on a background thread via ExecutorService.
 */
public class RecetteRepository {

    private final RecetteDao recetteDao;
    private final CategorieRecetteDao categorieRecetteDao;
    private final IngredientDao ingredientDao;
    private final EtapeDao etapeDao;
    private final RecetteIngredientDao recetteIngredientDao;

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public RecetteRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        recetteDao = db.recetteDao();
        categorieRecetteDao = db.categorieRecetteDao();
        ingredientDao = db.ingredientDao();
        etapeDao = db.etapeDao();
        recetteIngredientDao = db.recetteIngredientDao();
    }

    // ─── Recettes ────────────────────────────────────────────────

    public LiveData<List<Recette>> getAllRecettes() {
        return recetteDao.getAllRecettes();
    }

    public LiveData<Recette> getRecetteById(int id) {
        return recetteDao.getRecetteById(id);
    }

    public LiveData<List<Recette>> getRecettesByCategorie(int categorieId) {
        return recetteDao.getRecettesByCategorie(categorieId);
    }

    public LiveData<List<Recette>> getRecettesByDifficulte(int difficulte) {
        return recetteDao.getRecettesByDifficulte(difficulte);
    }

    public LiveData<List<Recette>> getFavoris() {
        return recetteDao.getFavoris();
    }

    public LiveData<List<Recette>> searchRecettes(String search) {
        return recetteDao.searchRecettes(search);
    }

    public LiveData<Integer> getTotalRecettes() {
        return recetteDao.getTotalRecettes();
    }

    public LiveData<Integer> getTotalFavoris() {
        return recetteDao.getTotalFavoris();
    }

    public void insert(Recette recette) {
        executor.execute(() -> recetteDao.insert(recette));
    }

    public void update(Recette recette) {
        executor.execute(() -> recetteDao.update(recette));
    }

    public void delete(Recette recette) {
        executor.execute(() -> recetteDao.delete(recette));
    }

    public void updateFavori(int id, boolean estFavori) {
        executor.execute(() -> recetteDao.updateFavori(id, estFavori));
    }

    // ─── Categories ──────────────────────────────────────────────

    public LiveData<List<CategorieRecette>> getAllCategories() {
        return categorieRecetteDao.getAllCategories();
    }

    public void insert(CategorieRecette categorie) {
        executor.execute(() -> categorieRecetteDao.insert(categorie));
    }

    // ─── Ingredients ─────────────────────────────────────────────

    public LiveData<List<Ingredient>> getAllIngredients() {
        return ingredientDao.getAllIngredients();
    }

    public LiveData<List<Ingredient>> searchIngredients(String search) {
        return ingredientDao.searchIngredients(search);
    }

    public void insert(Ingredient ingredient) {
        executor.execute(() -> ingredientDao.insert(ingredient));
    }

    // ─── Etapes ──────────────────────────────────────────────────

    public LiveData<List<Etape>> getEtapesByRecette(int recetteId) {
        return etapeDao.getEtapesByRecette(recetteId);
    }

    public void insertAllEtapes(List<Etape> etapes) {
        executor.execute(() -> etapeDao.insertAll(etapes));
    }

    public void deleteEtapesByRecette(int recetteId) {
        executor.execute(() -> etapeDao.deleteEtapesByRecette(recetteId));
    }

    // ─── RecetteIngredients ──────────────────────────────────────

    public LiveData<List<RecetteIngredient>> getIngredientsByRecette(int recetteId) {
        return recetteIngredientDao.getIngredientsByRecette(recetteId);
    }

    public void insertAllRecetteIngredients(List<RecetteIngredient> recetteIngredients) {
        executor.execute(() -> recetteIngredientDao.insertAll(recetteIngredients));
    }

    public void deleteIngredientsByRecette(int recetteId) {
        executor.execute(() -> recetteIngredientDao.deleteIngredientsByRecette(recetteId));
    }
}