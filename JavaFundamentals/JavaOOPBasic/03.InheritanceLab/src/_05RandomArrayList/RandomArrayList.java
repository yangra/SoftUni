package _05RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

class RandomArrayList extends ArrayList {

    Object getRandomElement(){
        Random rnd = new Random();
        int index = rnd.nextInt(super.size());
        Object element = super.get(index);
        super.set(index, super.remove(super.size()-1));
        return element;
    }
}
