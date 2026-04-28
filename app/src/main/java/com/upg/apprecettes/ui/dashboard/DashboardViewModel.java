package com.upg.apprecettes.ui.dashboard;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.upg.apprecettes.data.repository.RecetteRepository;

public class DashboardViewModel extends AndroidViewModel {

    public final LiveData<Integer> totalRecettes;
    public final LiveData<Integer> totalFavoris;

    public DashboardViewModel(Application application) {
        super(application);
        RecetteRepository repository = new RecetteRepository(application);
        totalRecettes = repository.getTotalRecettes();
        totalFavoris = repository.getTotalFavoris();
    }
}
