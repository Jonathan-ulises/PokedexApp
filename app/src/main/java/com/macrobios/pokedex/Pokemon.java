package com.macrobios.pokedex;

import java.util.Objects;

public class Pokemon {

    private String id;
    private String name;
    private int imageID;
    private int soundID;
    private Type type;

    public enum Type{
        FIRE, WATER, PLANT, ELECTRIC
    }

    public Pokemon(String id, String name, int imageID, int soundID, Type type) {
        this.id = id;
        this.name = name;
        this.imageID = imageID;
        this.soundID = soundID;
        this.type = type;
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

    public int getImageID() {
        return imageID;
    }

    public int getSoundID() {
        return soundID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return imageID == pokemon.imageID &&
                soundID == pokemon.soundID &&
                id.equals(pokemon.id) &&
                name.equals(pokemon.name) &&
                type == pokemon.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, imageID, soundID, type);
    }
}
