package _08May2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04RoyalAccounting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


       Map<String, Map<String,Double[]>> employees = new TreeMap<>();
        Pattern regex = Pattern.compile("^([a-zA-Z]+?);([0-9]+?);([0-9]*(.[0-9]*));([a-zA-Z])$");
        while(true){
            String input = reader.readLine();
            if("Pishi kuf i da si hodim".equals(input)){
                break;
            }
            Matcher matcher = regex.matcher(input);
            if(matcher.matches()){
                String employee = matcher.group(1);
                Double workHoursPerDay = Double.parseDouble(matcher.group(2));
                Double dailyPayment = Double.parseDouble(matcher.group(3));
                String team = matcher.group(5);
                if(!employees.containsKey(employee)){
                    Double[] employeeStats = new Double[2];
                    employeeStats[0] = workHoursPerDay;
                    employeeStats[1] = dailyPayment;

                    //employees.put(employee,employeeStats);

                }
            }

        }
    }
}
