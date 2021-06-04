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

        Stats bulbasaurStats = new Stats("45", "49", "49", "45");
        Stats inysaurStats = new Stats("60", "62", "63", "60");
        Stats venuasaurStats = new Stats("80", "82", "83", "80");
        Stats charmadnderStats = new Stats("39", "52", "43", "65");
        Stats charmeleonStats = new Stats("58", "64", "58", "80");
        Stats charizardStats = new Stats("78", "84", "78", "100");
        Stats squirtleStats= new Stats("44", "48", "65", "43");
        Stats wartortleStats = new Stats("59", "63", "80", "58");
        Stats blastoiseStats = new Stats("79", "83", "100", "78");
        Stats pikachuStats = new Stats("35", "55", "40", "90");
        Stats raichuStats = new Stats("60", "90", "55", "110");


        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(new Pokemon("1", "Bulbasaur",
                "https://static.wikia.nocookie.net/espokemon/images/4/43/Bulbasaur.png/revision/latest?cb=20170120032346", R.raw.bulbasaur, Pokemon.Type.PLANT, bulbasaurStats));
        pokemonList.add(new Pokemon("2", "Ivysaur",
                "https://static.wikia.nocookie.net/espokemon/images/8/86/Ivysaur.png/revision/latest?cb=20140207202404", R.raw.inysaur, Pokemon.Type.PLANT, inysaurStats));
        pokemonList.add(new Pokemon("3", "Venuasaur",
                "https://static.wikia.nocookie.net/espokemon/images/b/be/Venusaur.png/revision/latest?cb=20160309230456", R.raw.venusaur, Pokemon.Type.PLANT, venuasaurStats));
        pokemonList.add(new Pokemon("4", "Charmander",
                "https://static.wikia.nocookie.net/espokemon/images/5/56/Charmander.png/revision/latest?cb=20140207202456", R.raw.charmander, Pokemon.Type.FIRE, charmadnderStats));
        pokemonList.add(new Pokemon("6", "Charizard",
                "https://static.wikia.nocookie.net/espokemon/images/9/95/Charizard.png/revision/latest?cb=20180325003352", R.raw.charizard, Pokemon.Type.FIRE, charizardStats));
        pokemonList.add(new Pokemon("7", "Squirtle",
                "https://static.wikia.nocookie.net/espokemon/images/e/e3/Squirtle.png/revision/latest?cb=20160309230820", R.raw.squirtle, Pokemon.Type.WATER, squirtleStats));
        pokemonList.add(new Pokemon("5", "Charmeleon",
                "https://static.wikia.nocookie.net/espokemon/images/f/fb/Charmeleon.png/revision/latest/scale-to-width-down/260?cb=20140207202536", R.raw.charmeleon, Pokemon.Type.FIRE, charmeleonStats));
        pokemonList.add(new Pokemon("8", "Wartortle",
                "https://static.wikia.nocookie.net/espokemon/images/d/d7/Wartortle.png/revision/latest?cb=20140207202657", R.raw.wartotle, Pokemon.Type.WATER, wartortleStats));
        pokemonList.add(new Pokemon("9", "Blastoise",
                "https://static.wikia.nocookie.net/espokemon/images/4/41/Blastoise.png/revision/latest?cb=20140207202720", R.raw.blastoise, Pokemon.Type.WATER, blastoiseStats));
        pokemonList.add(new Pokemon("25", "Pikachu",
                "https://static.wikia.nocookie.net/espokemon/images/7/77/Pikachu.png/revision/latest?cb=20150621181250", R.raw.pikachu, Pokemon.Type.ELECTRIC, pikachuStats));
        pokemonList.add(new Pokemon("26", "Raichu",
                "https://static.wikia.nocookie.net/espokemon/images/3/34/Raichu.png/revision/latest/scale-to-width-down/1000?cb=20160815220038", R.raw.raichu, Pokemon.Type.ELECTRIC, raichuStats));

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