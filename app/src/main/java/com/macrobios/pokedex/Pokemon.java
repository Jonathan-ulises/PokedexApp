package com.macrobios.pokedex;

import java.util.Objects;

public class Pokemon {

    private String id;
    private String name;
    private String imageUrl;
    private int soundID;
    private Type type;
    private Stats stats;

    public enum Type{
        FIRE, WATER, PLANT, ELECTRIC
    }

    public Pokemon(String id, String name, String imageUrl, int soundID, Type type, Stats stats) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.soundID = soundID;
        this.type = type;
        this.stats = stats;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getSoundID() {
        return soundID;
    }

    public Stats getStats() {
        return stats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return soundID == pokemon.soundID &&
                id.equals(pokemon.id) &&
                name.equals(pokemon.name) &&
                imageUrl.equals(pokemon.imageUrl) &&
                type == pokemon.type &&
                stats.equals(pokemon.stats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, imageUrl, soundID, type, stats);
    }
}
