package _08PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges = 0;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void receiveBadge(){
        this.numberOfBadges++;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d",this.name, this.numberOfBadges, this.pokemons.size());
    }
}
