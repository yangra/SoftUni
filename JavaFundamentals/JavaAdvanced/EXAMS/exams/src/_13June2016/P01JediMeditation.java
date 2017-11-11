package _13June2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01JediMeditation {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfRows = Integer.parseInt(reader.readLine());

        Deque<String> masterQueue = new ArrayDeque<>();
        Deque<String> knightQueue = new ArrayDeque<>();
        Deque<String> padawanQueue = new ArrayDeque<>();
        Deque<String> toshkoSlavQueue = new ArrayDeque<>();

        Pattern master = Pattern.compile("m[0-9]+");
        Pattern knight = Pattern.compile("k[0-9]+");
        Pattern padawan = Pattern.compile("p[0-9]+");
        Pattern toshko = Pattern.compile("t[0-9]+");
        Pattern slav = Pattern.compile("s[0-9]+");
        Pattern yoda = Pattern.compile("y[0-9]+");


        boolean yodaAppeared = false;
        for (int i = 0; i < numberOfRows; i++) {
            String[] input = reader.readLine().split(" ");
            for (String s : input) {
                Matcher masterMatcher = master.matcher(s);
                Matcher knightMatcher = knight.matcher(s);
                Matcher padawanMatcher = padawan.matcher(s);
                Matcher toshkoMatcher = toshko.matcher(s);
                Matcher slavMatcher = slav.matcher(s);
                Matcher yodaMatcher = yoda.matcher(s);
                if (masterMatcher.matches()) {
                    masterQueue.offer(s);
                }
                if (knightMatcher.matches()) {
                    knightQueue.offer(s);
                }
                if (padawanMatcher.matches()) {
                    padawanQueue.offer(s);
                }
                if (toshkoMatcher.matches()) {
                    toshkoSlavQueue.offer(s);
                }
                if (slavMatcher.matches()) {
                    toshkoSlavQueue.offer(s);
                }
                if (yodaMatcher.matches()) {
                    yodaAppeared = true;
                }
            }
        }


        StringBuilder result = new StringBuilder();
        if (yodaAppeared) {
            while (masterQueue.size() > 0) {
                result.append(masterQueue.poll() + " ");
            }
            while (knightQueue.size() > 0) {
                result.append(knightQueue.poll() + " ");
            }
            while (toshkoSlavQueue.size() > 0) {
                result.append(toshkoSlavQueue.poll() + " ");
            }
            while (padawanQueue.size() > 0) {
                result.append(padawanQueue.poll() + " ");
            }
        } else {
            while (toshkoSlavQueue.size() > 0) {
                result.append(toshkoSlavQueue.poll() + " ");
            }
            while (masterQueue.size() > 0) {
                result.append(masterQueue.poll() + " ");
            }
            while (knightQueue.size() > 0) {
                result.append(knightQueue.poll() + " ");
            }
            while (padawanQueue.size() > 0) {
                result.append(padawanQueue.poll() + " ");
            }
        }
        System.out.println(result.toString());
    }
}
