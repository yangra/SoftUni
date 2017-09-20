import java.util.Scanner;

public class P09ByteParty {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        int[] nums = new int[count];
        for (int i = 0; i < count ; i++) {
            nums[i] = Integer.parseInt(scanner.nextLine());
        }

        while(true){
            String[] command = scanner.nextLine().split("\\s+");
            if(command[0].equals("party")){
                break;
            }

            int action = Integer.parseInt(command[0]);
            int position = Integer.parseInt(command[1]);


            switch (action){
                case -1:
                    for (int i = 0; i < nums.length ; i++) {
                        nums[i] = nums[i]^(1<<position);
                    }
                    break;
                case 1:
                    for (int i = 0; i < nums.length ; i++) {
                        nums[i] = nums[i]|(1<<position);
                    }
                    break;
                case 0:
                    int mask = ~(1<<position);
                    for (int i = 0; i < nums.length ; i++) {
                        nums[i] = nums[i]&mask;
                    }
                    break;
            }
        }

        for (int num : nums) {
            System.out.println(num);
        }
    }
}
