package _14InfernoInfinityRefactoring.models.contracts;

import _14InfernoInfinityRefactoring.enums.Gem;

public interface Weapon {
    String getName();

    void addGem(Gem gem, int index);

    void removeGem(int index);

    Weapon compare(Weapon other);

    String print();
}
