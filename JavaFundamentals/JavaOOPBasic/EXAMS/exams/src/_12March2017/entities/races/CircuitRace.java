package _12March2017.entities.races;

import _12March2017.entities.cars.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CircuitRace extends Race {
    private int laps;

    public CircuitRace(int length, String route, int prizePool, int laps) {
        super(length, route, prizePool);
        this.laps = laps;
    }

    @Override
    public String start() {
        this.getParticipants().forEach(c->c.decreaseDurability(this.laps*super.getLength()*super.getLength()));
        List<Car> winners = this.getParticipants().stream()
                .sorted((a, b) -> Integer.compare(b.getOverallPerformance(), a.getOverallPerformance()))
                .limit(4).collect(Collectors.toList());

        return this.toString() +
                this.stringifyWinners(winners);
    }

    private int getPrize(int place) {
        switch (place) {
            case 1:
                return (this.getPrizePool() * 4) / 10;
            case 2:
                return (this.getPrizePool() * 3) / 10;
            case 3:
                return (this.getPrizePool() * 2) / 10;
            default:
                return this.getPrizePool() / 10;
        }
    }

    private String stringifyWinners(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        for (Car car : winners) {
            sb.append(String.format("%d. %s %s %dPP - $%d", counter, car.getBrand(), car.getModel(),
                    car.getOverallPerformance(),
                    this.getPrize(counter)));
            if (counter != 4 && !winners.get(winners.size() - 1).equals(car)) {
                sb.append(System.lineSeparator());
            }
            counter++;
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %d\n", this.getRoute(), this.getLength()*this.laps));
        return sb.toString();
    }
}
