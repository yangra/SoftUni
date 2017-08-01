package softuni.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.entities.User;
import softuni.services.UserService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Component
public class Terminal implements CommandLineRunner {
    private final UserService userService;

    @Autowired
    public Terminal(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... strings) throws Exception {

        if (this.userService.findAll().size() == 0) {
            seedDatabase();
        }

//      16. Print all usernames and emails of users by given email provider
//        printUsersByEmailProvider("yahoo.com");

//      17.Count the users with pictures bigger than given width
//        printCountOfUsersWithPicturesWiderThanGivenWidth(240);

//      18. Set is_deleted field to true for all users that have not been logged in after given date
//        and after that delete these users
//        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
//        Date date = sdf.parse("13 Jul 2015");
//        deleteUsersInactiveAfter(date);

    }

    private void deleteUsersInactiveAfter(Date date) {
        List<User> users = this.userService.getAllUsersInactiveAfter(date);
        for (User user : users) {
            user.setDeleted(true);
            this.userService.save(user);
        }

        if (users.size() > 1) {
            System.out.printf("%d users have been deleted", users.size());
        } else if (users.size() == 1) {
            System.out.println("1 user has been deleted");
        } else {
            System.out.println("No users have been deleted");
        }

        for (User user : users) {
           this.userService.remove(user);
        }
    }

    private void printCountOfUsersWithPicturesWiderThanGivenWidth(int width) throws IOException {
        List<User> users = this.userService.getAllUsersWithPictures();
        int counter = 0;
        for (User user : users) {
            BufferedImage bimg = ImageIO.read(new File(user.getProfilePicturePath()));
            int picWidth = bimg.getWidth();
            if (picWidth > width) {
                counter++;
            }
        }

        if (counter > 1) {
            System.out.printf("%d users have profile pictures wider than %d pixels\n", counter, width);
        } else if (counter == 1) {
            System.out.printf("%d user has profile picture wider than %d pixels\n", counter, width);
        } else {
            System.out.printf("No users have profile picture wider than %d pixels\n", width);
        }


    }

    private void printUsersByEmailProvider(String provider) {
        List<User> users = this.userService.getAllUsersByEmailProvider(provider);
        if (users.size() > 0) {
            users.forEach(u -> System.out.printf("%s %s\n", u.getUsername(), u.getEmail()));
        } else {
            System.out.println("<no users with that email provider>");
        }
    }

    private void seedDatabase() throws ParseException {

        List<User> users = new ArrayList<>();

        Random random = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String special = "!@#$%^&*()_+<>?";
        String[] mails = new String[]{"abv.bg", "gmail.com", "yahoo.com"};
        String[] regYears = new String[]{"2012", "2011", "2005", "2006", "2007", "2008", "2009", "2010"};
        String[] loginYears = new String[]{"2017", "2016", "2015"};
        String[] months = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        String[] dates = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"};
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d.M.yyyy");

        for (int i = 0; i < 20; i++) {
            StringBuilder usernameBuilder = new StringBuilder();

            for (int j = 0; j < 8; j++) {
                usernameBuilder.append(alphabet.charAt(random.nextInt(alphabet.length())));
            }
            String username = usernameBuilder.toString();

            String email = username + "@" + mails[random.nextInt(mails.length)];

            StringBuilder passwordBuilder = new StringBuilder();
            for (int j = 0; j < 2; j++) {
                passwordBuilder.append(alphabet.charAt(random.nextInt(alphabet.length())));
            }
            for (int j = 0; j < 2; j++) {
                passwordBuilder.append(upperCase.charAt(random.nextInt(upperCase.length())));
            }
            for (int j = 0; j < 2; j++) {
                passwordBuilder.append(numbers.charAt(random.nextInt(numbers.length())));
            }
            for (int j = 0; j < 2; j++) {
                passwordBuilder.append(special.charAt(random.nextInt(special.length())));
            }
            String password = passwordBuilder.toString();

            Integer age = random.nextInt(100) + 12;

            String regDate = "";
            regDate += dates[random.nextInt(dates.length)];
            regDate += ".";
            regDate += months[random.nextInt(months.length)];
            regDate += ".";
            regDate += regYears[random.nextInt(regYears.length)];

            String loginDate = "";
            loginDate += dates[random.nextInt(dates.length)];
            loginDate += ".";
            loginDate += months[random.nextInt(months.length)];
            loginDate += ".";
            loginDate += loginYears[random.nextInt(loginYears.length)];


            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            user.setAge(age);
            Date lastLoggedIn = simpleDateFormat.parse(loginDate);
            user.setLastTimeLoggedIn(lastLoggedIn);
            Date regOn = simpleDateFormat.parse(regDate);
            user.setRegisteredOn(regOn);
            user.setDeleted(false);
            this.userService.save(user);
            users.add(user);
        }

        for (int i = 0; i < users.size() - 3; i++) {
            String path = "src/main/resources/static/images/p";
            path += users.get(i).getId().toString();
            if (users.get(i).getId() == 1 || users.get(i).getId() == 5 || users.get(i).getId() == 6 || users.get(i).getId() == 7 ||
                    users.get(i).getId() == 8 || users.get(i).getId() == 10 || users.get(i).getId() == 11 || users.get(i).getId() == 14) {
                path += ".png";
            } else {
                path += ".jpg";
            }
            users.get(i).setProfilePicturePath(path);
            this.userService.save(users.get(i));
        }
    }
}
