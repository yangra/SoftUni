package _12InfernoInfinityCompareTo;

import _12InfernoInfinityCompareTo.enums.Gem;

public interface Weapon{
   void addGem(Gem gem, int index);
   void removeGem(int index);
   Weapon compare(Weapon other);
   String print();
}
