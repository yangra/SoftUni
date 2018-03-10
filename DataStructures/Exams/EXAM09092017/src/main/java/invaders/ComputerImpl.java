package invaders;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class ComputerImpl implements Computer {

    private int energy;
    private Map<Invader, Integer> byAppearance;


    public ComputerImpl(int energy) {

        if (energy < 0) {
            throw new IllegalArgumentException();
        }
        this.energy = energy;
        this.byAppearance = new LinkedHashMap<>();
    }

    public int getEnergy() {
        return this.energy;
    }

    public void addInvader(Invader invader) {
        this.byAppearance.put(invader, invader.getDistance());
    }

    public void skip(int turns) {
        Iterator iterator = this.byAppearance.keySet().iterator();
        while (iterator.hasNext()) {
            Invader invader = (Invader) iterator.next();
            invader.setDistance(invader.getDistance() - turns);
            if (invader.getDistance() <= 0) {
                this.energy -= invader.getDamage();
                iterator.remove();
                this.byAppearance.remove(invader);
            }
        }
        if (this.energy < 0) {
            this.energy = 0;
        }
    }

    public void destroyTargetsInRadius(int radius) {
        Iterator iterator = this.byAppearance.keySet().iterator();
        while (iterator.hasNext()) {
            Invader invader = (Invader) iterator.next();
            if (invader.getDistance() <= radius) {
                iterator.remove();
                this.byAppearance.remove(invader);
            }
        }
    }

    public void destroyHighestPriorityTargets(int n) {
        if (n >= byAppearance.size()) {
            byAppearance = new LinkedHashMap<>();
            return;
        }
        PriorityQueue<Invader> byPriority = new PriorityQueue<>();
        for (Invader invader : byAppearance.keySet()) {
            byPriority.enqueue(invader);
        }

        for (int i = 0; i < n; i++) {
            Invader invader = byPriority.dequeue();
            byAppearance.remove(invader);
        }
    }

    public Iterable<Invader> invaders() {
        return this.byAppearance.keySet();
    }
}
