package _02PrivateClassFiddling;

import _02PrivateClassFiddling.com.peshoslav.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, NoSuchFieldException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Class blackBoxClass = Class.forName(BlackBoxInt.class.getName());
        Constructor blackBoxConstructor = blackBoxClass.getDeclaredConstructor();
        blackBoxConstructor.setAccessible(true);
        BlackBoxInt blackBox = (BlackBoxInt) blackBoxConstructor.newInstance();

        while (true) {
            String[] command = reader.readLine().split("_");
            if ("end".equalsIgnoreCase(command[0])) {
                break;
            }

            Method method = blackBoxClass.getDeclaredMethod(command[0], int.class);
            method.setAccessible(true);
            method.invoke(blackBox, Integer.parseInt(command[1]));
            Field field = blackBox.getClass().getDeclaredField("innerValue");
            field.setAccessible(true);
            System.out.println(field.get(blackBox));
        }
    }
}

