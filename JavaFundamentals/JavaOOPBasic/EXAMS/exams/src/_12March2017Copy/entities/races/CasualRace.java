package _12March2017Copy.entities.races;

import _12March2017Copy.entities.cars.Car;
import _12March2017Copy.entities.races.Race;

import java.util.List;
import java.util.stream.Collectors;

public class CasualRace extends Race {
    public CasualRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public String start() {
        if (this.getParticipants().size() < 1) {
            throw new IllegalArgumentException("Cannot start the race with zero participants.");
        }

        List<Car> result = this.getParticipants().stream().sorted((c1, c2) -> {
            int value1 = (c1.getHorsepower() / c1.getAcceleration()) + (c1.getSuspension() + c1.getDurability());
            int value2 = (c2.getHorsepower() / c2.getAcceleration()) + (c2.getSuspension() + c2.getDurability());
            return Integer.compare(value2, value1);
        }).limit(3).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %d\n", this.getRoute(), this.getLength()));
        int counter = 1;
        for (Car car : result) {
            sb.append(String.format("%d. %s %s %dPP - $%d", counter, car.getBrand(), car.getModel(),
                    (car.getHorsepower() / car.getAcceleration()) + (car.getSuspension() + car.getDurability()),
                    counter == 1 ? this.getPrizePool() / 2 : counter == 2 ?
                            (this.getPrizePool() * 3) / 10 : counter == 3 ?
                            this.getPrizePool() / 5 : 0));
            if (counter != 3 && !result.get(result.size() - 1).equals(car)) {
                sb.append(System.lineSeparator());
            }
            counter++;
        }
        return sb.toString();
    }

}
