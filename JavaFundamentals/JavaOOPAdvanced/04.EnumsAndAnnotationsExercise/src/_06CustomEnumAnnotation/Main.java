package _06CustomEnumAnnotation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String ENUM_PATH_PACKAGE = "_06CustomEnumAnnotation.";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String token = reader.readLine();
        Class<?> enumClass = Class.forName(ENUM_PATH_PACKAGE +token);
        TypeInfo annotation = enumClass.getAnnotation(TypeInfo.class);
        System.out.printf("Type = %s, Description = %s\n", annotation.type(), annotation.description());

    }
}
