package P08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        Library library = new Library();
        for (int i = 0; i < count ; i++) {
            String[] bookInfo = reader.readLine().split("\\s");
            Book book = new Book(bookInfo[0], bookInfo[1], bookInfo[2], bookInfo[3], bookInfo[4],Double.parseDouble(bookInfo[5]));
            library.addBook(book);
        }
        library.getBooks()
                .stream().collect(Collectors.groupingBy(Book::getAuthor, Collectors.summingDouble(Book::getPrice)))
                .entrySet().stream().sorted((a,b)->{
            int result = Double.compare(b.getValue(), a.getValue());
            if (result == 0){
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(a-> System.out.printf("%s -> %.2f\n", a.getKey(), a.getValue()));
    }
}
