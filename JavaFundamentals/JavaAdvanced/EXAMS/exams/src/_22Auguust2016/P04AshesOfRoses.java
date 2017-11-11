package _22Auguust2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P04AshesOfRoses {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String,Map<String,Long>> roses = new TreeMap<>();
        while(true){
            String input = reader.readLine();
            if("icarus, ignite!".equalsIgnoreCase(input)){
                break;
            }

            Pattern regex = Pattern.compile("^Grow\\s<([A-Z][a-z]+)>\\s<([A-Za-z0-9]+)>\\s([0-9]+)$");
            Matcher matcher = regex.matcher(input);
            if(matcher.find()){
                String region = matcher.group(1);
                String color = matcher.group(2);
                Long numberOfRoses = Long.valueOf(matcher.group(3));

                Map<String, Long> colors = new TreeMap<>();
                if(roses.containsKey(region)){
                    colors = roses.get(region);
                    if(colors.containsKey(color)){
                        colors.put(color,colors.get(color)+numberOfRoses);
                    }else{
                        colors.put(color,numberOfRoses);
                    }
                }else{
                    colors.put(color,numberOfRoses);
                }
                roses.put(region,colors);
            }
        }

        roses = roses.entrySet().stream().sorted((a,b)->{
            Long op1 = a.getValue().entrySet().stream().mapToLong(Map.Entry::getValue).sum();
            Long op2 = b.getValue().entrySet().stream().mapToLong(Map.Entry::getValue).sum();
            return op2.compareTo(op1);
        }).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(o,n)->o, LinkedHashMap::new));

        for (Map.Entry<String, Map<String, Long>> entry : roses.entrySet()) {
            System.out.println(entry.getKey());

            Map<String,Long> colors = entry.getValue().entrySet().stream()
                    .sorted(Comparator.comparing(Map.Entry::getValue))
                    .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(o,n)->o, LinkedHashMap::new));

            for (Map.Entry<String, Long> color : colors.entrySet()) {
                System.out.printf("*--%s | %d\n",color.getKey(),color.getValue());
            }
        }
    }
}
