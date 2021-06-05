package com.macrobios.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.macrobios.pokedex.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements PokemonListFragment.OnPokemonSelectedListener{

    private final int OPTION_DETAIL = 0;
    private final int OPTION_STATS = 1;

    private Pokemon selectedPokemon;
    private int selectedOption;

    private Fragment currentFragment;

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
            selFragmentAndContent();
        });

        binding.btnStats.setOnClickListener(v -> {
            changeColorButton(v.getId());
            selFragmentAndContent();
        });
    }

    private void changeColorButton(int viewID){
        switch (viewID){
            case R.id.btnImage:
                binding.btnImage.setBackgroundColor(ContextCompat.getColor(this, R.color.option_button_selected));
                binding.btnStats.setBackgroundColor(ContextCompat.getColor(this, R.color.option_button_not_selected));
                selectedOption = OPTION_DETAIL;
                break;
            case R.id.btnStats:
                binding.btnImage.setBackgroundColor(ContextCompat.getColor(this, R.color.option_button_not_selected));
                binding.btnStats.setBackgroundColor(ContextCompat.getColor(this, R.color.option_button_selected));
                selectedOption = OPTION_STATS;
                break;
        }
    }

    @Override
    public void onPokemonItemList(Pokemon pokemon) {
        selectedPokemon = pokemon;
        selFragmentAndContent();
    }

    private void selFragmentAndContent(){
        if(selectedPokemon != null){
            if(selectedOption == OPTION_DETAIL) {
                currentFragment = DetailFragment.newInstance(selectedPokemon.getImageUrl(), selectedPokemon.getSoundID());
            } else if (selectedOption == OPTION_STATS) {
                currentFragment = StatsFragment.newInstance(selectedPokemon.getStats());
            }


            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.detail_fragment_container, currentFragment);
            fragmentTransaction.commit();
        } else {
            Toast.makeText(this, "You have not selected a pokemon", Toast.LENGTH_SHORT).show();
        }

    }
}