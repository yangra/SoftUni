package _04Telephony;

public class Smartphone implements Callable,Browsable {
    @Override
    public String browse(String site) {
        if(!site.matches("([^0-9]*)")){
            return "Invalid URL!";
        }

        return String.format("Browsing: %s!",site);
    }

    @Override
    public String call(String number) {
        if(!number.matches("\\d+")){
            return "Invalid number!";
        }

        return String.format("Calling... %s", number);
    }
}
