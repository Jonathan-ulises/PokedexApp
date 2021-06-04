package com.macrobios.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;

import com.macrobios.pokedex.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements PokemonListFragment.OnPokemonSelectedListener{

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnImage.setBackgroundColor(ContextCompat.getColor(this, R.color.option_button_selected));
        binding.btnStats.setBackgroundColor(ContextCompat.getColor(this, R.color.option_button_not_selected));

        binding.btnImage.setOnClickListener(v -> {
            changeColorButton(v.getId());
        });

        binding.btnStats.setOnClickListener(v -> {
            changeColorButton(v.getId());
        });
    }

    private void changeColorButton(int viewID){
        switch (viewID){
            case R.id.btnImage:
                binding.btnImage.setBackgroundColor(ContextCompat.getColor(this, R.color.option_button_selected));
                binding.btnStats.setBackgroundColor(ContextCompat.getColor(this, R.color.option_button_not_selected));
                break;
            case R.id.btnStats:
                binding.btnImage.setBackgroundColor(ContextCompat.getColor(this, R.color.option_button_not_selected));
                binding.btnStats.setBackgroundColor(ContextCompat.getColor(this, R.color.option_button_selected));
                break;
        }
    }

    @Override
    public void onPokemonItemList(Pokemon pokemon) {
        DetailFragment fragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_fragment);

        
    }
}