package com.upg.apprecettes.ui.ajout;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.upg.apprecettes.data.db.entity.Recette;
import com.upg.apprecettes.data.repository.RecetteRepository;

public class AjoutRecetteViewModel extends AndroidViewModel {

    private final RecetteRepository repository;

    public AjoutRecetteViewModel(Application application) {
        super(application);
        repository = new RecetteRepository(application);
    }

    public void saveRecette(String titre, String description, int tempsPrep,
                             int tempsCuisson, int difficulte,
                             int personnes, int categorieId) {
        Recette recette = new Recette(titre, description, tempsPrep,
                tempsCuisson, difficulte, personnes, categorieId, null);
        repository.insert(recette);
    }
}
