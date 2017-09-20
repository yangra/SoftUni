import java.util.Scanner;

public class P11GameOfNames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int maxScore = Integer.MIN_VALUE;
        String winner = "";

        for (int i = 0; i < n ; i++) {
            String name = scanner.nextLine();
            int score = Integer.parseInt(scanner.nextLine());
            for (int j = 0; j < name.length(); j++) {
                if(name.charAt(j)%2==0){
                    score += name.charAt(j);
                }else{
                    score -= name.charAt(j);
                }
            }

            if(score > maxScore){
                maxScore = score;
                winner = name;
            }
        }

        System.out.printf("The winner is %s - %d points", winner, maxScore);
    }
}
