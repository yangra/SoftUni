import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P012ToTheStars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String,Double[]> stars = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            String[] star = scanner.nextLine().split("\\s+");
            String name = star[0].toLowerCase();
            double X = Double.parseDouble(star[1]);
            double Y = Double.parseDouble(star[2]);
            Double[] bounds = new Double[4];
            bounds[0] = X-1;
            bounds[1] = X+1;
            bounds[2] = Y-1;
            bounds[3] = Y+1;
            stars.put(name,bounds);
        }

        double[] coords = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        double NormX = coords[0];
        double NormY = coords[1];
        boolean isLocated = false;
        int moves = Integer.parseInt(scanner.nextLine());

        do{
            for (String name : stars.keySet()) {
                if(NormX >= stars.get(name)[0] && NormX <= stars.get(name)[1] &&
                        NormY >= stars.get(name)[2] && NormY <= stars.get(name)[3]) {
                    isLocated = true;
                    System.out.println(name);
                }
            }

            if(!isLocated){
                System.out.println("space");
            }

            moves--;
            NormY++;
            isLocated = false;
        }while(moves>=0);

    }
}
