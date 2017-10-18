import java.io.*;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) {

        try (BufferedReader in = new BufferedReader(new FileReader(P01ReadFile.input));
        PrintWriter out = new PrintWriter(new FileWriter(P01ReadFile.output))){
            int counter = 1;
            String line = in.readLine();
            while(line!=null){
                if(counter%3==0){
                    out.println(line);
                }

                counter++;
                line = in.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
