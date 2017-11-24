package _02GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {


    @SuppressWarnings("unchecked")
    public static <T> T[] create(int length, T item){
        Object[] objects = new Object[length];

        for (int i = 0; i < length; i++) {
            objects[i] = item;
        }

        return (T[])objects;
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] create(Class<T> cl, int length, T item){

        T[] objects = (T[]) Array.newInstance(cl,length);

        for (int i = 0; i < length; i++) {
            objects[i] = item;
        }

        return objects;
    }

}
