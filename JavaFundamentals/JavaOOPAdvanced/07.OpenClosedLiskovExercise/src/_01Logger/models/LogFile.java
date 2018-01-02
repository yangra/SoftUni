package _01Logger.models;


import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogFile implements _01Logger.models.interfaces.File{

    private BigInteger size;

    public LogFile() {
        //super("D:\\SoftUni\\IdeaProjects\\JavaFundamentals\\JavaOOPAdvanced\\07.OpenClosedLiskovExercise\\src\\_01Logger\\log.txt");
        this.size = BigInteger.ZERO;
    }

    @Override
    public BigInteger getSize(){
//        BigInteger size = BigInteger.ZERO;
//        Pattern pattern = Pattern.compile("[a-zA-Z]");
//        Matcher matcher = pattern.matcher(this.getContent());
//        while(matcher.find()){
//            size = size.add(BigInteger.valueOf((int)matcher.group().charAt(0)));
//        }
        return this.size;
    }

    @Override
    public void write(String log) {
//        Path file = Paths.get(this.toURI());
//        try {
//            Files.write(file, log, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        increaseSize(log);
    }

    private void increaseSize(String log) {
        BigInteger size = BigInteger.ZERO;
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(log);
        while(matcher.find()){
            size = size.add(BigInteger.valueOf((int)matcher.group().charAt(0)));
        }
        this.size = this.size.add(size);
    }

//    private String getContent() throws IOException {
//        List<String> lines = Files.readAllLines(this.toPath());
//        return String.join(" ", lines);
//    }
}
