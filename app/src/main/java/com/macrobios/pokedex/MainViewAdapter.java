package com.macrobios.pokedex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.macrobios.pokedex.databinding.PokemonListItemBinding;

public class MainViewAdapter extends ListAdapter<Pokemon, MainViewAdapter.MainViewViewHolder> {

    private Context ctx;

    public static final DiffUtil.ItemCallback<Pokemon> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Pokemon>() {
                //Compara si los items de la lista son iguales
                @Override
                public boolean areItemsTheSame(
                        @NonNull Pokemon oldEarthquake, @NonNull  Pokemon newEarthquake) {
                    return oldEarthquake.getId().equals(newEarthquake.getId());
                }

                //Compara si el contenido de un item es el mismo que otro
                @Override
                public boolean areContentsTheSame(
                        @NonNull Pokemon oldEarthquake, @NonNull Pokemon newEarthquake) {
                    return oldEarthquake.equals(newEarthquake);
                }
            };


    protected MainViewAdapter(Context ctx) {
        super(DIFF_CALLBACK);

        this.ctx = ctx;
    }

    @NonNull
    @Override
    public MainViewAdapter.MainViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PokemonListItemBinding binding = PokemonListItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new MainViewViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewAdapter.MainViewViewHolder holder, int position) {
        Pokemon pokemon = getItem(position);

        holder.bind(pokemon);
    }

    class MainViewViewHolder extends RecyclerView.ViewHolder{
        private final PokemonListItemBinding binding;

        public MainViewViewHolder(@NonNull PokemonListItemBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        public void bind(Pokemon pokemon){
            binding.txtPokeID.setText(pokemon.getId());
            binding.txtPokeName.setText(pokemon.getName());
            switch (pokemon.getType()){
                case FIRE:
                    binding.imgPokeType.setImageDrawable(ctx.getDrawable(R.drawable.fire));
                    break;
                case PLANT:
                    binding.imgPokeType.setImageDrawable(ctx.getDrawable(R.drawable.plant));
                    break;
                case WATER:
                    binding.imgPokeType.setImageDrawable(ctx.getDrawable(R.drawable.water));
                    break;
                case ELECTRIC:
                    binding.imgPokeType.setImageDrawable(ctx.getDrawable(R.drawable.electric));
            }

            binding.executePendingBindings();
        }
    }
}
