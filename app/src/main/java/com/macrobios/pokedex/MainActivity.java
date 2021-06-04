package com.macrobios.pokedex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PokemonListFragment.OnPokemonSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }


    @Override
    public void onPokemonItemList(Pokemon pokemon) {
        Toast.makeText(this, pokemon.getName(), Toast.LENGTH_SHORT).show();

        DetailFragment fragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_fragment);

        fragment.setPokemonImage(pokemon.getImageID());
    }
}