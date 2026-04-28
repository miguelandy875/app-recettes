package com.upg.apprecettes.ui.ajout;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.upg.apprecettes.R;

public class AjoutRecetteFragment extends Fragment {

    private AjoutRecetteViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ajout_recette, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(AjoutRecetteViewModel.class);

        TextInputEditText editTitre = view.findViewById(R.id.edit_titre);
        TextInputEditText editDescription = view.findViewById(R.id.edit_description);
        TextInputEditText editTempsPrep = view.findViewById(R.id.edit_temps_prep);
        TextInputEditText editTempsCuisson = view.findViewById(R.id.edit_temps_cuisson);
        TextInputEditText editPersonnes = view.findViewById(R.id.edit_personnes);
        RatingBar ratingDifficulte = view.findViewById(R.id.rating_difficulte);
        MaterialButton btnSave = view.findViewById(R.id.btn_save);

        btnSave.setOnClickListener(v -> {
            String titre = editTitre.getText() != null
                ? editTitre.getText().toString().trim() : "";
            String description = editDescription.getText() != null
                ? editDescription.getText().toString().trim() : "";
            String prepStr = editTempsPrep.getText() != null
                ? editTempsPrep.getText().toString().trim() : "";
            String cuissonStr = editTempsCuisson.getText() != null
                ? editTempsCuisson.getText().toString().trim() : "";
            String personnesStr = editPersonnes.getText() != null
                ? editPersonnes.getText().toString().trim() : "";

            if (TextUtils.isEmpty(titre)) {
                editTitre.setError("Le titre est obligatoire");
                return;
            }
            if (TextUtils.isEmpty(prepStr)) {
                editTempsPrep.setError("Champ obligatoire");
                return;
            }
            if (TextUtils.isEmpty(cuissonStr)) {
                editTempsCuisson.setError("Champ obligatoire");
                return;
            }
            if (TextUtils.isEmpty(personnesStr)) {
                editPersonnes.setError("Champ obligatoire");
                return;
            }

            int difficulte = (int) ratingDifficulte.getRating();
            if (difficulte == 0) difficulte = 1;

            viewModel.saveRecette(
                titre, description,
                Integer.parseInt(prepStr),
                Integer.parseInt(cuissonStr),
                difficulte,
                Integer.parseInt(personnesStr),
                1 // default category for now
            );

            Toast.makeText(requireContext(),
                "Recette enregistrée", Toast.LENGTH_SHORT).show();

            Navigation.findNavController(v).navigateUp();
        });
    }
}
