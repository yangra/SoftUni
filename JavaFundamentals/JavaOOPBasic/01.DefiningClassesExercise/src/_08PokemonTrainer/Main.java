package _08PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Trainer> trainers = new ArrayList<>();
        while (true) {
            String[] caught = reader.readLine().split("\\s+");
            if ("tournament".equalsIgnoreCase(caught[0])) {
                break;
            }

            Pokemon pokemon = new Pokemon(caught[1], caught[2], Integer.parseInt(caught[3]));
            Trainer trainer = null;
            for (Trainer t : trainers) {
                if (t.getName().equals(caught[0])) {
                    trainer = t;
                }
            }
            if(trainer==null){
                trainer = new Trainer(caught[0]);
                trainers.add(trainer);
            }
            trainer.getPokemons().add(pokemon);

        }

        while (true) {
            String command = reader.readLine();
            if ("end".equalsIgnoreCase(command)) {
                break;
            }

            for (Trainer trainer : trainers) {
                if (trainer.getPokemons().stream().filter(p -> p.getElement().equals(command)).count() > 0) {
                    trainer.receiveBadge();
                } else {
                    trainer.getPokemons().forEach(Pokemon::decreaseHealth);
                    trainer.getPokemons().removeIf(p -> p.getHealth() <= 0);
                }
            }
        }

        trainers.stream()
                .sorted(Comparator.comparing(Trainer::getNumberOfBadges).reversed())
                .forEach(System.out::println);
    }
}
