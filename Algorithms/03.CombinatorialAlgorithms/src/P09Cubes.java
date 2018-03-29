import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P09Cubes {
    private static Set<String> allRotations = new HashSet<>();
    private static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        permute(0, input);
        System.out.println(count);
    }


    private static void permute(int index, String[] elements) {
        if (index == elements.length) {
            String perm = String.join(" ",elements);
            if(!allRotations.contains(perm)){
                count++;
                allRotations.add(perm);
                String[] permutation = Arrays.copyOf(elements,elements.length);

                for (int i = 0; i < 4; i++) {
                    permutation = rotateY(permutation);
                    allRotations.add(String.join(" ", permutation));
                }

                for (int i = 0; i < 3; i++) {
                    permutation = rotateX(permutation);
                    for (int j = 0; j < 4; j++) {
                        permutation = rotateY(permutation);
                        allRotations.add(String.join(" ", permutation));
                    }
                }
                permutation = rotateX(permutation);
                permutation = rotateZ(permutation);
                for (int i = 0; i < 4; i++) {
                    permutation = rotateY(permutation);
                    allRotations.add(String.join(" ", permutation));

                }
                for (int i = 0; i < 2; i++) {
                    permutation = rotateZ(permutation);
                }
                for (int i = 0; i < 4; i++) {
                    permutation = rotateY(permutation);
                    allRotations.add(String.join(" ", permutation));
                }
            }
            return;
        }

        Set<String> swapped = new HashSet<>();
        for (int i = index; i < elements.length; i++) {
            if (!swapped.contains(elements[i])) {
                swap(index, i, elements);
                permute(index + 1, elements);
                swap(index, i, elements);
                swapped.add(elements[i]);
            }
        }
    }

    private static String[] rotateZ(String[] permutation) {
        String[] rotated = new String[permutation.length];
        rotated[0] = permutation[1];
        rotated[1] = permutation[2];
        rotated[2] = permutation[3];
        rotated[3] = permutation[0];
        rotated[4] = permutation[5];
        rotated[5] = permutation[6];
        rotated[6] = permutation[7];
        rotated[7] = permutation[4];
        rotated[8] = permutation[9];
        rotated[9] = permutation[10];
        rotated[10] = permutation[11];
        rotated[11] = permutation[8];
        return rotated;
    }

    private static String[] rotateY(String[] permutation) {
        String[] rotated = new String[permutation.length];
        rotated[0] = permutation[8];
        rotated[1] = permutation[4];
        rotated[2] = permutation[0];
        rotated[3] = permutation[7];
        rotated[4] = permutation[9];
        rotated[5] = permutation[1];
        rotated[6] = permutation[3];
        rotated[7] = permutation[11];
        rotated[8] = permutation[10];
        rotated[9] = permutation[5];
        rotated[10] = permutation[2];
        rotated[11] = permutation[6];
        return rotated;
    }

    private static String[] rotateX(String[] permutation) {
        String[] rotated = new String[permutation.length];
        rotated[0] = permutation[4];
        rotated[1] = permutation[9];
        rotated[2] = permutation[5];
        rotated[3] = permutation[1];
        rotated[4] = permutation[8];
        rotated[5] = permutation[10];
        rotated[6] = permutation[2];
        rotated[7] = permutation[0];
        rotated[8] = permutation[7];
        rotated[9] = permutation[11];
        rotated[10] = permutation[6];
        rotated[11] = permutation[3];
        return rotated;
    }

    private static void swap(int i, int index, String[] values) {
        String temp = values[i];
        values[i] = values[index];
        values[index] = temp;
    }
}

