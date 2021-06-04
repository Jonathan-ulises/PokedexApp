package com.macrobios.pokedex;

import java.util.Objects;

public class Pokemon {

    private String id;
    private String name;
    private Type type;

    public enum Type{
        FIRE, WATER, PLANT, ELECTRIC
    }

    public Pokemon(String id, String name, Type type) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return id.equals(pokemon.id) &&
                name.equals(pokemon.name) &&
                type == pokemon.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type);
    }
}
