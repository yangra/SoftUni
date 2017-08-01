package softuni.Terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.entities.*;
import softuni.services.AuthorService;
import softuni.services.BookService;
import softuni.services.CategoryService;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class Terminal implements CommandLineRunner {
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;

    @Autowired
    public Terminal(AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }


    @Override
    public void run(String... strings) throws Exception {

//        seedDatabase();

//        executeQueries();

        relateBooks();

    }

    private void relateBooks() {
        List<Book> books = this.bookService.findAll();
        List<Book> threeBooks = books.subList(0, 3);

        threeBooks.get(0).getRelatedBooks().add(threeBooks.get(1));
        threeBooks.get(1).getRelatedBooks().add(threeBooks.get(0));
        threeBooks.get(0).getRelatedBooks().add(threeBooks.get(2));
        threeBooks.get(2).getRelatedBooks().add(threeBooks.get(0));

        //save related books to the database
        for (Book book : threeBooks) {
            this.bookService.save(book);
        }

        for (Book book : threeBooks) {
            System.out.printf("--%s\n", book.getTitle());
            for (Book relatedBook : book.getRelatedBooks()) {
                System.out.println(relatedBook.getTitle());
            }
        }
    }


    private void executeQueries() {
//        1. Get all books after the year 2000. Print only their titles.
//        List<String> titles = this.bookService.getAllTitlesAfterYear(2000);
//        titles.forEach(System.out::println);

//        2. Get all authors with at least one book with release date before 1990
//        List<Author> authors = this.authorService.getAuthorsWithBookReleaseDateBefore(1990);
//        authors.forEach(a->System.out.printf("%s %s\n",a.getFirstName(),a.getLastName()));

//        3. Get all authors, ordered by the number of their books (descending).
//        List<Object[]> authorsBooks = this.authorService.getAllAuthorsByTheNumberOfTheirBooks();
//        authorsBooks.forEach(a->System.out.printf("%s %s Number of books: %d\n",a[0], a[1], a[2]));

//        4. Get all books from author George Powell, ordered by their release date (descending),
//        then by book title (ascending)
        List<Book> books = this.bookService.getAllBooksByAuthor("George Powell");
        books.forEach(b -> System.out.printf("Title: %s, Release date: %s, Number of copies: %d\n",
                b.getTitle(), b.getReleaseDate(), b.getCopies()));
    }

    private void seedDatabase() throws IOException, ParseException {
        List<Author> authors = new ArrayList<>();

        BufferedReader authorsReader = new BufferedReader(new FileReader("src/authors.txt"));
        String authorLine = authorsReader.readLine();
        while ((authorLine = authorsReader.readLine()) != null) {
            String[] authorName = authorLine.split("\\s+");
            String firstName = authorName[0];
            String lastName = authorName[1];
            Author author = new Author();
            author.setFirstName(firstName);
            author.setLastName(lastName);
            this.authorService.save(author);
            authors.add(author);
        }

        List<Category> allCategories = new ArrayList<>();

        BufferedReader categoriesReader = new BufferedReader(new FileReader("src/categories.txt"));
        String categoryLine = "";
        while ((categoryLine = categoriesReader.readLine()) != null) {
            String name = categoryLine.trim();
            Category category = new Category();
            category.setName(name);
            this.categoryService.save(category);
            allCategories.add(category);
        }

        Random random = new Random();

        BufferedReader booksReader = new BufferedReader(new FileReader("src/books.txt"));
        String line = booksReader.readLine();
        while ((line = booksReader.readLine()) != null) {
            String[] data = line.split("\\s+");

            int authorIndex = random.nextInt(authors.size());
            Author author = authors.get(authorIndex);
            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
            Date releaseDate = formatter.parse(data[1]);
            int copies = Integer.parseInt(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            StringBuilder titleBuilder = new StringBuilder();
            for (int i = 5; i < data.length; i++) {
                titleBuilder.append(data[i]).append(" ");
            }
            titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
            String title = titleBuilder.toString();
            Set<Category> bookCategories = new HashSet<>();
            int limit = random.nextInt(5);
            for (int i = 0; i < limit ; i++) {
                int categoryIndex = random.nextInt(allCategories.size());
                Category category = allCategories.get(categoryIndex);
                bookCategories.add(category);
            }

            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);
            book.setCategories(bookCategories);
            this.bookService.save(book);
        }
    }
}

