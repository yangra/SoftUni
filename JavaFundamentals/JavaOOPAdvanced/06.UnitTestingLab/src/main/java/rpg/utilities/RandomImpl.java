package rpg.utilities;

import java.util.Random;

public class RandomImpl implements RandomProvider {

    private Random random;

    public RandomImpl() {
        this.random = new Random();
    }

    @Override
    public int nextInt(int max) {
        return this.random.nextInt(max);
    }
}
