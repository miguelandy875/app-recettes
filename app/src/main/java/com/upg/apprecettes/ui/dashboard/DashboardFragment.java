package com.upg.apprecettes.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.upg.apprecettes.R;

public class DashboardFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DashboardViewModel viewModel =
            new ViewModelProvider(this).get(DashboardViewModel.class);

        TextView textTotal = view.findViewById(R.id.text_total_recettes);
        TextView textFavoris = view.findViewById(R.id.text_total_favoris);

        viewModel.totalRecettes.observe(getViewLifecycleOwner(), count ->
            textTotal.setText(count != null ? String.valueOf(count) : "0")
        );

        viewModel.totalFavoris.observe(getViewLifecycleOwner(), count ->
            textFavoris.setText(count != null ? String.valueOf(count) : "0")
        );
    }
}
