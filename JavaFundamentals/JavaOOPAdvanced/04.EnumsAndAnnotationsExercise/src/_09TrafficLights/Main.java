package _09TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<TrafficLight> trafficLights = new ArrayList<>();

        String[] input = reader.readLine().split("\\s+");
        for (String s : input) {
            TrafficLight trafficLight = new TrafficLight(s);
            trafficLights.add(trafficLight);
        }

        int numberOfChanges = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfChanges; i++) {
            changeLights(trafficLights);
            System.out.println(String.join(" ", trafficLights.stream()
                    .map(tl -> tl.getState().name())
                    .collect(Collectors.toList())));
        }
    }

    private static void changeLights(List<TrafficLight> trafficLights) {
        for (TrafficLight trafficLight : trafficLights) {
            trafficLight.changeState();
        }
    }
}
