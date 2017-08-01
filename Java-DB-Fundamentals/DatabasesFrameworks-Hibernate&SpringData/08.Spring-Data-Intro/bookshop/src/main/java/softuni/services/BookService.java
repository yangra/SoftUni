package softuni.services;


import java.util.List;

public interface BookService<Book,Long> extends ServiceInterface<Book,Long> {
      List<String> getAllTitlesAfterYear(Integer year);

      List<Book> getAllBooksByAuthor(String author);

}
