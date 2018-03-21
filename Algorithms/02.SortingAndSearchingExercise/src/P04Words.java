import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class P04Words {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        char[] arr = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            arr[i] = input.charAt(i);
        }

        Arrays.sort(arr);
        int count = permuteRep(arr, 0, arr.length - 1);
        System.out.println(count);

//        Map<Character, Integer> repetitions = new HashMap<>();
//        for (int i = 0; i < input.length(); i++) {
//            char letter = input.charAt(i);
//            repetitions.putIfAbsent(letter, isEqual(input, letter, i + 1, 1));
//        }
//
//        if (repetitions.size() == input.length()) {
//            //no repeats permute n!
//            int result = factorial(input.length());
//            System.out.println(result);
//            return;
//        }
//
//        int maxRepeat = getMax(new ArrayList<>(repetitions.values()), 1, 0);
//
//        if (input.length() - maxRepeat < maxRepeat - 1) {
//            // no solution
//            System.out.println(0);
//            return;
//        }
//
//        if (input.length() - maxRepeat == maxRepeat - 1) {
//            //one solution only
//            System.out.println(1);
//            return;
//        }
//
//        //long start = System.nanoTime();
//        int result = findWords(repetitions, new ArrayList<>(repetitions.keySet()), 0, 0, new char[input.length()]);
//        System.out.println(result);
//        //long end = System.nanoTime() - start;
//        //System.out.println(end);
    }

    private static int permuteRep(char[] arr, int start, int end) {
        int count = 0;
        boolean valid = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                valid = false;
                break;
            }
        }
        if (valid) {
            count++;
        }

        for (int left = end - 1; left >= start; left--) {
            for (int right = left + 1; right <= end; right++) {
                if (arr[left] != arr[right]) {
                    swap(arr, left, right);
                   count += permuteRep(arr, left + 1, end);
                }
            }

            char firstElement = arr[left];
            for (int i = left; i <= end - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[end] = firstElement;
        }

        return count;

    }

    private static void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private static int findWords(Map<Character, Integer> original, List<Character> sublist, int vectorIndex, int count, char[] vector) {
        if (vectorIndex == vector.length) {
//            for (char c : vector) {
//                System.out.print(c);
//            }
//            System.out.println();
            return ++count;
        }

        for (int i = 0; i < sublist.size(); i++) {
            char currentLetter = sublist.get(i);
            vector[vectorIndex] = currentLetter;
            List<Character> sub = new ArrayList<>(original.keySet());
            int keyIndex = sub.indexOf(sublist.get(i));
            Collections.swap(sub, 0, keyIndex);
            List<Character> forSublist = sub.subList(1, sub.size());
            Iterator<Character> iterator = forSublist.iterator();

            while (iterator.hasNext()) {
                char character = iterator.next();
                if (original.get(character) == 0) {
                    iterator.remove();
                }
            }

            original.put(currentLetter, original.get(currentLetter) - 1);
            count = findWords(original, forSublist, vectorIndex + 1, count, vector);
            original.put(currentLetter, original.get(currentLetter) + 1);
        }

        return count;
    }

    private static int findWords2(Map<Character, Integer> original, List<Character> sublist, int vectorIndex, int count, char[] vector) {
        if (vectorIndex == vector.length) {
            return ++count;
        }

        for (int i = 0; i < sublist.size(); i++) {
            char currentLetter = sublist.get(i);
            vector[vectorIndex] = currentLetter;

            List<Character> subList = original.keySet().stream()
                    .filter(k -> original.get(k) != 0 && k != currentLetter).collect(Collectors.toList());

            original.put(currentLetter, original.get(currentLetter) - 1);
            count = findWords2(original, subList, vectorIndex + 1, count, vector);
            original.put(currentLetter, original.get(currentLetter) + 1);
        }

        return count;
    }

    private static int factorial(int num) {
        if (num == 0) {
            return 1;
        }

        return num * factorial(num - 1);
    }

    private static int getMax(List<Integer> values, int index, int max) {
        if (index == values.size()) {
            return max;
        }
        if (values.get(index - 1) >= values.get(index)) {
            max = values.get(index - 1);
        } else {
            max = values.get(index);
        }
        max = getMax(values, index + 1, max);
        return max;
    }

    private static int isEqual(String input, char letter, int start, int count) {
        if (start == input.length()) {
            return count;
        }

        if (letter == input.charAt(start)) {
            count++;
        }

        count = isEqual(input, letter, start + 1, count);

        return count;
    }

}
