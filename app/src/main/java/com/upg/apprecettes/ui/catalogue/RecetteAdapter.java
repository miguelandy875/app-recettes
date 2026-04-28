package com.upg.apprecettes.ui.catalogue;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.upg.apprecettes.R;
import com.upg.apprecettes.data.db.entity.Recette;

/**
 * RecyclerView adapter for displaying recipe cards in the catalogue.
 * Uses ListAdapter with DiffUtil for efficient list updates.
 */
public class RecetteAdapter extends ListAdapter<Recette, RecetteAdapter.RecetteViewHolder> {

    public interface OnRecetteClickListener {
        void onRecetteClick(Recette recette);
    }

    private final OnRecetteClickListener listener;

    public RecetteAdapter(OnRecetteClickListener listener) {
        super(DIFF_CALLBACK);
        this.listener = listener;
    }

    private static final DiffUtil.ItemCallback<Recette> DIFF_CALLBACK =
        new DiffUtil.ItemCallback<Recette>() {
            @Override
            public boolean areItemsTheSame(@NonNull Recette oldItem,
                                           @NonNull Recette newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull Recette oldItem,
                                              @NonNull Recette newItem) {
                return oldItem.getTitre().equals(newItem.getTitre())
                    && oldItem.isEstFavori() == newItem.isEstFavori()
                    && oldItem.getDifficulte() == newItem.getDifficulte();
            }
        };

    @NonNull
    @Override
    public RecetteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recette, parent, false);
        return new RecetteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecetteViewHolder holder, int position) {
        holder.bind(getItem(position), listener);
    }

    static class RecetteViewHolder extends RecyclerView.ViewHolder {

        private final TextView textTitre;
        private final TextView textTemps;
        private final RatingBar ratingDifficulte;
        private final ImageView iconFavori;

        public RecetteViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitre = itemView.findViewById(R.id.text_titre);
            textTemps = itemView.findViewById(R.id.text_temps);
            ratingDifficulte = itemView.findViewById(R.id.rating_difficulte);
            iconFavori = itemView.findViewById(R.id.icon_favori);
        }

        public void bind(Recette recette, OnRecetteClickListener listener) {
            textTitre.setText(recette.getTitre());

            int totalTemps = recette.getTempsPreparation() + recette.getTempsCuisson();
            textTemps.setText(totalTemps + " min");

            ratingDifficulte.setRating(recette.getDifficulte());

            iconFavori.setImageResource(recette.isEstFavori()
                ? android.R.drawable.btn_star_big_on
                : android.R.drawable.btn_star_big_off);

            itemView.setOnClickListener(v -> listener.onRecetteClick(recette));
        }
    }
}