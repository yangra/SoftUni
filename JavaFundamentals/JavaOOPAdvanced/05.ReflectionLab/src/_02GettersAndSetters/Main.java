package _02GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class reflClass = Reflection.class;

        Arrays.stream(reflClass.getDeclaredMethods()).filter(m -> m.getName().startsWith("get"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(m.getName() + " will return " + m.getReturnType()));

        Arrays.stream(reflClass.getDeclaredMethods()).filter(m -> m.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(m.getName() + " and will set field of " + m.getParameterTypes()[0]));
    }
}
