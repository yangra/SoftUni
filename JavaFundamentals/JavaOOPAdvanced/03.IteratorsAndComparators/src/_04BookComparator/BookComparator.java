package _04BookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book>{
    @Override
    public int compare(Book b1, Book b2) {
        if(b1.getTitle().compareTo(b2.getTitle())== 0){
            return Integer.compare(b1.getYear(),b2.getYear());
        }

        return b1.getTitle().compareTo(b2.getTitle());
    }
}
