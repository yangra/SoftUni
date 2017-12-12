package _03HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Class reflClass = Reflection.class;
        Field[] fields = Arrays.stream(reflClass.getDeclaredFields())
                .sorted(Comparator.comparing(Field::getName))
                .toArray(Field[]::new);
        for (Field field : fields) {
            if(!Modifier.isPrivate(field.getModifiers())){
                System.out.printf("%s must be private!\n", field.getName());
            }
        }

        Method[] getters = Arrays.stream(reflClass.getDeclaredMethods())
                .filter(m->m.getName().startsWith("get"))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);
        for (Method getter : getters) {
            if(!Modifier.isPublic(getter.getModifiers())){
                System.out.printf("%s have to be public!\n", getter.getName());
            }
        }

        Method[] setters = Arrays.stream(reflClass.getDeclaredMethods())
                .filter(m->m.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);
        for (Method setter : setters) {
            if(!Modifier.isPrivate(setter.getModifiers())){
                System.out.printf("%s have to be private!\n", setter.getName());
            }
        }
    }
}
