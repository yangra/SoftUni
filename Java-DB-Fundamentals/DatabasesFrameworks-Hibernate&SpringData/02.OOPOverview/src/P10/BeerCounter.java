package P10;

public class BeerCounter {
    public static int beerInStock = 0;
    public static int beersDrankCount = 0;

    public static void buyBeer(int bottlesCount){
        beerInStock += bottlesCount;
    }

    public static void drinkBeer(int bottlesCount){
        beerInStock -= bottlesCount;
        beersDrankCount += bottlesCount;
    }
}
