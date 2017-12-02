package _05CodingTracker;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tracker {
    @Author(name = "Pesho")
    private void print(){}

    @Author(name = "Gosho")
    private void read(){}

    public static void printMethodsByAuthor(Class<?> cl){
        Map<String,List<String>> methodsByAuthor = new HashMap<>();
        Method[] methods = cl.getDeclaredMethods();
        for (Method method : methods) {
            if(method.isAnnotationPresent(Author.class)){
                Author author = method.getAnnotation(Author.class);
                methodsByAuthor.putIfAbsent(author.name(), new ArrayList<>());
                methodsByAuthor.get(author.name()).add(method.getName());
            }
        }

        for (Map.Entry<String, List<String>> entry : methodsByAuthor.entrySet()) {
            System.out.printf("%s: %s()\n", entry.getKey(), String.join(", ", entry.getValue()));
        }

    }
}
