package com.macrobios.pokedex;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.macrobios.pokedex.databinding.FragmentDetailBinding;
import com.macrobios.pokedex.databinding.FragmentPokemonListBinding;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    private Bitmap bitmap;


    private static final String POKEMON_IMAGE_URL = "pokemon_image_url";
    private static final String POKEMON_SOUND_ID = "pokemon_sound_id";


    public DetailFragment() {
        // Required empty public constructor
    }


    public static DetailFragment newInstance(String pokemonImageURL, int pokemonSoundID) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(POKEMON_IMAGE_URL, pokemonImageURL);
        args.putInt(POKEMON_SOUND_ID, pokemonSoundID);
        fragment.setArguments(args);
        return fragment;
    }


    private FragmentDetailBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentDetailBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        if(getArguments() != null){
            String pokemonImageUrl = getArguments().getString(POKEMON_IMAGE_URL);
            int pokemonSoundID = getArguments().getInt(POKEMON_SOUND_ID);

            setPokemonImage(pokemonImageUrl);
            playPokemonSound(pokemonSoundID);
        }
        // Inflate the layout for this fragment
        return view;
    }

    private void setPokemonImage(String imgageUrl){
        Picasso.get().load(imgageUrl).into(binding.pokemonDetailFragment);
    }

    private void playPokemonSound(int soundID) {
        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(), soundID);
        mediaPlayer.start();
    }
}