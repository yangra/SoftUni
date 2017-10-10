import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P05SoftUniParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Set<String> setOfGuests = new TreeSet<>();

        boolean isParty = false;
        while(true){
            String invitation = scanner.nextLine();
           if(invitation.equals("END")){
               break;
           }
           if (invitation.equals("PARTY")){
               isParty=true;
           }
           if(isParty){
               setOfGuests.remove(invitation);
           }else{
               setOfGuests.add(invitation);
           }
        }

        System.out.println(setOfGuests.size());
        for (String guest : setOfGuests) {
            System.out.println(guest);
        }
    }
}
