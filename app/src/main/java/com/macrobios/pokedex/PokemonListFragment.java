package com.macrobios.pokedex;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
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

    OnPokemonSelectedListener mCallback;

    public interface OnPokemonSelectedListener {
        void onPokemonItemList(Pokemon pokemon);
    }


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
        pokemonList.add(new Pokemon("1", "Bulbasaur",   R.drawable.bulbasaur,   Pokemon.Type.PLANT));
        pokemonList.add(new Pokemon("2", "Ivysaur",     R.drawable.ivysaur,     Pokemon.Type.PLANT));
        pokemonList.add(new Pokemon("3", "Venuasaur",   R.drawable.venusaur,    Pokemon.Type.PLANT));
        pokemonList.add(new Pokemon("4", "Charmander",  R.drawable.charmander,  Pokemon.Type.FIRE));
        pokemonList.add(new Pokemon("5", "Charmeleon",  R.drawable.charmeleon,  Pokemon.Type.FIRE));
        pokemonList.add(new Pokemon("6", "Charizard",   R.drawable.charizard,   Pokemon.Type.FIRE));
        pokemonList.add(new Pokemon("7", "Squirtle",    R.drawable.squirtle,    Pokemon.Type.WATER));
        pokemonList.add(new Pokemon("8", "Wartortle",   R.drawable.wartortle,   Pokemon.Type.WATER));
        pokemonList.add(new Pokemon("9", "Blastoise",   R.drawable.blastoise,   Pokemon.Type.WATER));
        pokemonList.add(new Pokemon("25", "Pikachu",    R.drawable.pikachu,     Pokemon.Type.ELECTRIC));
        pokemonList.add(new Pokemon("26", "Raichu",     R.drawable.raichu,      Pokemon.Type.ELECTRIC));

        binding.rclPokemon.setLayoutManager(new LinearLayoutManager(getActivity()));
        MainViewAdapter adapter = new MainViewAdapter(getActivity());

        binding.rclPokemon.setAdapter(adapter);

        adapter.submitList(pokemonList);

        adapter.setOnItemClickListener(pokemon -> {
            mCallback.onPokemonItemList(pokemon);
        });

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            mCallback = (OnPokemonSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implemente OnPekemonSelectedListener");
        }
    }
}