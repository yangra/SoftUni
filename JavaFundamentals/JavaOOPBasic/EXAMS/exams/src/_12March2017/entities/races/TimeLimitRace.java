package _12March2017.entities.races;

import _12March2017.entities.cars.Car;

public class TimeLimitRace extends Race {
    private int goldTime;

    public TimeLimitRace(int length, String route, int prizePool, int goldTime) {
        super(length, route, prizePool);
        this.goldTime = goldTime;
    }


    private int getTimePerformance(Car car) {
        return this.getLength() * car.getTimePerformanceIndex();
    }

    private String getParticipantEarnedTime(Car car) {
        int timePerformance = this.getTimePerformance(car);
        if (timePerformance <= this.goldTime) {
            return "Gold";
        } else if (timePerformance <= this.goldTime + 15) {
            return "Silver";
        } else {
            return "Bronze";
        }
    }

    private int getPrize(Car car) {
        int timePerformance = this.getTimePerformance(car);
        if (timePerformance <= this.goldTime) {
            return super.getPrizePool();
        } else if (timePerformance <= this.goldTime + 15) {
            return super.getPrizePool() / 2;
        } else {
            return (super.getPrizePool() * 3) / 10;
        }
    }

    @Override
    public String start() {
        if (this.getParticipants().size() < 1) {
            throw new IllegalArgumentException("Cannot start the race with zero participants.");
        }

        return this.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Car car = this.getParticipants().get(0);
        sb.append(String.format("%s - %d\n", this.getRoute(), this.getLength()));
        sb.append(String.format("%s %s - %d s.\n", car.getBrand(), car.getModel(), this.getTimePerformance(car)));
        sb.append(String.format("%s Time, $%d.", this.getParticipantEarnedTime(car), this.getPrize(car)));
        return sb.toString();
    }
}
