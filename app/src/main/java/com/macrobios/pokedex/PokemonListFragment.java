package com.macrobios.pokedex;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.macrobios.pokedex.databinding.FragmentPokemonListBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PokemonListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PokemonListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PokemonListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PokemonListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PokemonListFragment newInstance(String param1, String param2) {
        PokemonListFragment fragment = new PokemonListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    FragmentPokemonListBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentPokemonListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(new Pokemon("1", "Bulbasaur", Pokemon.Type.PLANT));
        pokemonList.add(new Pokemon("2", "Ivysaur", Pokemon.Type.PLANT));
        pokemonList.add(new Pokemon("3", "Venuasaur", Pokemon.Type.PLANT));
        pokemonList.add(new Pokemon("4", "Charmander", Pokemon.Type.FIRE));
        pokemonList.add(new Pokemon("5", "Charmeleon", Pokemon.Type.FIRE));
        pokemonList.add(new Pokemon("6", "Charizard", Pokemon.Type.FIRE));
        pokemonList.add(new Pokemon("7", "Squirtle", Pokemon.Type.WATER));
        pokemonList.add(new Pokemon("8", "Wartortle", Pokemon.Type.WATER));
        pokemonList.add(new Pokemon("9", "Blastoise", Pokemon.Type.WATER));
        pokemonList.add(new Pokemon("25", "Pikachu", Pokemon.Type.ELECTRIC));
        pokemonList.add(new Pokemon("26", "Raichu", Pokemon.Type.ELECTRIC));

        binding.rclPokemon.setLayoutManager(new LinearLayoutManager(getActivity()));
        MainViewAdapter adapter = new MainViewAdapter(getActivity());

        binding.rclPokemon.setAdapter(adapter);

        adapter.submitList(pokemonList);


        // Inflate the layout for this fragment
        return view;
    }
}