package P04;

import java.util.regex.Pattern;

public class SmartPhone implements Callable,Browsable {

    @Override
    public void call(String number) {
        if(!Pattern.matches("\\d*", number)) {
            System.out.println("Invalid number!");
        }else{
            System.out.printf("Calling... %s\n", number);
        }
    }

    @Override
    public void browse(String site) {
        if(!Pattern.matches("\\D*", site)){
            System.out.println("Invalid URL!");
        }else{
            System.out.printf("Browsing: %s!\n", site);
        }
    }
}
