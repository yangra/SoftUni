package softuni.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.entities.*;
import softuni.repositories.ReducedBook;
import softuni.services.AuthorService;
import softuni.services.BookService;
import softuni.services.CategoryService;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        executeQueries();

    }


    private void executeQueries() throws IOException, ParseException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        1.Print titles of all books where their age restriction matches the given input
//        Ignore casing of the input.
//        String input = reader.readLine().trim().toUpperCase();
//        AgeRestriction ageRestriction = AgeRestriction.valueOf(input);
//        List<Book> books = this.bookService.getAllBooksWithAgeRestriction(ageRestriction);
//        books.forEach(b->System.out.printf("%s\n", b.getTitle()));

//        2. Print titles of the golden edition books and have less than 5000 copies

//        List<Book> books = this.bookService.getAllBooksByEditionTypeAndNumberOfCopies(EditionType.valueOf("GOLD"),5000);
//        for (Book book : books) {
//            System.out.println(book.getTitle());
//        }

//        3. Print titles and price of books with price lower than 5 and higher than 40
//        List<Book> books = this.bookService.getAllBooksWithPriceLessThanAndOver(BigDecimal.valueOf(5), BigDecimal.valueOf(40));
//        for (Book book : books) {
//            System.out.printf("%s - $%.2f\n", book.getTitle(), book.getPrice());
//        }

//        4.Print titles of all books that are NOT released on given year.
//        Integer year = Integer.parseInt(reader.readLine());
//        List<Book> books = this.bookService.getAllBooksNotReleasedIn(year);
//        for (Book book : books) {
//            System.out.println(book.getTitle());
//        }

//        5.Print titles of books by given list of categories.
//        String[] input = reader.readLine().split("\\s+");
//        List<Book> books = this.bookService.getBooksByCategories(input, (long)input.length);
//        for (Book book : books) {
//            System.out.println(book.getTitle());
//        }

//        6.Print title, edition type and price of books that are released before given date
//        String input = reader.readLine();
//        Date date = sdf.parse(input);
//        List<Book> books = this.bookService.getAllBooksReleasedBefore(date);
//        for (Book book : books) {
//            System.out.printf("%s - %s - $%.2f\n",book.getTitle(), book.getEditionType(), book.getPrice());
//        }

//        7.Print names of those authors whose first name end with given string
//        String input  = reader.readLine().trim();
//        List<Author> authors = this.authorService.getAuthorsFirstNameEndingWith(input);
//        for (Author author : authors) {
//            System.out.printf("%s %s\n", author.getFirstName() ,author.getLastName());
//        }

//        8.Print titles of books which contain given string
//        String input = reader.readLine();
//        List<Book> books = this.bookService.getBooksWithTitlesContaining(input);
//        for (Book book : books) {
//            System.out.printf("%s\n",book.getTitle());
//        }

//        9.Print titles of books which are written by authors whose last name start with given string.
//        String input = reader.readLine();
//        List<Book> books = this.bookService.getBooksAuthorsLastNameEndsWith(input);
//        for (Book book : books) {
//            System.out.printf("%s\n",book.getTitle());
//        }

//        10.Print number of books whose title is longer than a number given as an input.
//        Integer input = Integer.parseInt(reader.readLine());
//        Integer numberOfBooks = this.bookService.getAllBooksWithTitleLongerThan(input);
//        System.out.println(numberOfBooks);

//        11.Print the total number of book copies by author. Order the results descending by total book copies.
//        List<Object[]> authorsCopies = this.bookService.getAuthorsTotalCopies();
//        for (Object[] authorsCopy : authorsCopies) {
//            System.out.printf("%s %s - %s\n",authorsCopy[0], authorsCopy[1], authorsCopy[2]);
//        }

//        12.Print the total profit of all books by category.Order the results descending by total profit for
//        category and ascending by category name.
//        List<Object[]> categories = this.bookService.getProfitByCategory();
//        categories.forEach(c->System.out.printf("%s - $%.2f\n", c[0], c[1]));

//        13.Get the most recent books by categories.
//        StringBuilder result = new StringBuilder();
//        List<Category> categories = this.categoryService.getCategoriesWithBooksMoreThan(35L);
//        for (Category category : categories) {
//            result.append(String.format("--%s: %d books\n", category.getName(), category.getBooks().size()));
//            List<Object[]> books = this.bookService.getMostRecentByCategory(category.getName(), 3);
//            for (Object[] book : books) {
//                Date date = (Date) book[1];
//                Calendar cal = Calendar.getInstance();
//                cal.setTime(date);
//                int year = cal.get(Calendar.YEAR);
//                result.append(String.format("%s (%d)\n", book[0], year));
//            }
//        }
//        System.out.println(result);

//        14.Print information (title, edition type, age restriction and price) for book by given title.
//        String input = reader.readLine().trim();
//        ReducedBook book = this.bookService.getBookByTitle(input);
//        if (book!= null) {
//            System.out.printf("%s %s %s %.2f\n", book.getTitle(), book.getEditionType(), book.getAgeRestriction(), book.getPrice());
//        }else{
//            System.out.println("No such book!");
//        }

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

