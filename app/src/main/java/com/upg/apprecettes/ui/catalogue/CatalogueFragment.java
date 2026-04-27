package com.upg.apprecettes.ui.catalogue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.upg.apprecettes.R;

/**
 * Displays the full list of recipes in a grid layout.
 * Entry point of the app via bottom navigation.
 */
public class CatalogueFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_catalogue, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recycler = view.findViewById(R.id.recycler_recettes);
        recycler.setLayoutManager(new GridLayoutManager(requireContext(), 2));

        FloatingActionButton fab = view.findViewById(R.id.fab_add);
        fab.setOnClickListener(v ->
            Navigation.findNavController(v)
                .navigate(R.id.action_catalogue_to_ajout)
        );
    }
}