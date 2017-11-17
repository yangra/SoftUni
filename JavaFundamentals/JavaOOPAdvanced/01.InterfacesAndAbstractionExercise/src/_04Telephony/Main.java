package _04Telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Smartphone smartphone = new Smartphone();
        String[] numbers = reader.readLine().split("\\s+");
        for (String number : numbers) {
            System.out.println(smartphone.call(number));
        }
        String[] sites = reader.readLine().split("\\s+");
        for (String site : sites) {
            System.out.println(smartphone.browse(site));
        }
    }
}
