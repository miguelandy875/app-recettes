package com.upg.apprecettes.ui.catalogue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.upg.apprecettes.R;

public class CatalogueFragment extends Fragment {

    private CatalogueViewModel viewModel;
    private RecetteAdapter adapter;

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

        viewModel = new ViewModelProvider(this).get(CatalogueViewModel.class);

        adapter = new RecetteAdapter(recette ->
            Navigation.findNavController(view)
                .navigate(R.id.action_catalogue_to_detail)
        );

        RecyclerView recycler = view.findViewById(R.id.recycler_recettes);
        recycler.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        recycler.setAdapter(adapter);

        View emptyView = view.findViewById(R.id.text_empty);

        viewModel.allRecettes.observe(getViewLifecycleOwner(), recettes -> {
            adapter.submitList(recettes);
            emptyView.setVisibility(
                recettes.isEmpty() ? View.VISIBLE : View.GONE
            );
        });

        FloatingActionButton fab = view.findViewById(R.id.fab_add);
        fab.setOnClickListener(v ->
            Navigation.findNavController(v)
                .navigate(R.id.action_catalogue_to_ajout)
        );
    }
}
