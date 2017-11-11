package Kermen.models;

import Kermen.models.homes.Home;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class City {
    List<Home> homes;

    public City() {
        this.homes = new ArrayList<>();
    }

    public void addHome(Home home){
        this.homes.add(home);
    }

    public void paySalaries() {
        for (Home home : homes) {
            home.payIncome();
        }
    }

    public double calculateConsumption() {
        double result = 0;
        for (Home home : homes) {
            result+=home.getConsumption();
        }
        return result;
    }

    public void payAllBills() {
        for (Home home : homes) {
            home.payBills();
        }

        Iterator<Home> iterator = this.homes.iterator();
        while (iterator.hasNext()){
            if(iterator.next().getBudget()<0){
                iterator.remove();
            }
        }
    }

    public int getPopulation(){
        int population = 0;
        for (Home home : homes) {
           population += home.getNumberOfPeople();
        }
        return population;
    }

}
