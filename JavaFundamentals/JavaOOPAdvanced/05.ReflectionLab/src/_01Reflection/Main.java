package _01Reflection;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        Class reflClass = Reflection.class;
        System.out.println("class " + reflClass.getSimpleName());
        System.out.println(reflClass.getSuperclass());
        for (Class inerfaze : reflClass.getInterfaces()) {
            System.out.println(inerfaze);
        }

        Reflection instance = (Reflection) reflClass.newInstance();
        System.out.println(instance);
    }
}
