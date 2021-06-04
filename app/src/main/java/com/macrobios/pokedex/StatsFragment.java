package com.macrobios.pokedex;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.macrobios.pokedex.databinding.FragmentStatsBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StatsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StatsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String POKEMON_STATS = "pokemon_stats";


    public StatsFragment() {
        // Required empty public constructor
    }


    public static StatsFragment newInstance(Stats pokemonStats) {
        StatsFragment fragment = new StatsFragment();
        Bundle args = new Bundle();
        args.putParcelable(POKEMON_STATS, pokemonStats);
        fragment.setArguments(args);
        return fragment;
    }

    private FragmentStatsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStatsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        if(getArguments() != null){
            Stats pokemonStats = getArguments().getParcelable(POKEMON_STATS);

            binding.txtHPStats.setText(pokemonStats.getHp());
            binding.txtAtkStats.setText(pokemonStats.getAttack());
            binding.txtDefStats.setText(pokemonStats.getDefense());
            binding.txtSpdStats.setText(pokemonStats.getSpeed());
        }

        // Inflate the layout for this fragment
        return view;
    }
}