package com.upg.apprecettes.ui.catalogue;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.upg.apprecettes.data.db.entity.Recette;
import com.upg.apprecettes.data.repository.RecetteRepository;

import java.util.List;

public class CatalogueViewModel extends AndroidViewModel {

    private final RecetteRepository repository;
    public final LiveData<List<Recette>> allRecettes;

    public CatalogueViewModel(Application application) {
        super(application);
        repository = new RecetteRepository(application);
        allRecettes = repository.getAllRecettes();
    }

    public LiveData<List<Recette>> search(String query) {
        return repository.searchRecettes(query);
    }

    public void updateFavori(int id, boolean estFavori) {
        repository.updateFavori(id, estFavori);
    }
}
