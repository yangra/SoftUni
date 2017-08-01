package softuni.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.entities.*;
import softuni.services.CourseService;
import softuni.services.HomeworkService;
import softuni.services.ResourceService;
import softuni.services.StudentService;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final StudentService studentService;
    private final ResourceService resourceService;
    private final CourseService courseService;
    private final HomeworkService homeworkService;

    @Autowired
    public ConsoleRunner(StudentService studentService, ResourceService resourceService, HomeworkService homeworkService, CourseService courseService) {
        this.studentService = studentService;
        this.resourceService = resourceService;
        this.homeworkService = homeworkService;
        this.courseService = courseService;
    }

    @Override
    public void run(String... strings) throws Exception {

        if (this.courseService.findAll().size() == 0) {
            seedDatabase();
        }

        queryingDatabase();

    }

    private void queryingDatabase() throws ParseException {

        StringBuilder result = new StringBuilder();


//      1. List all students and their homework submissions
//        List<Student> students = this.studentService.findAll();
//        for (Student student : students) {
//            result.append("Student:" + student.getName() + "\n");
//            List<Homework> homeworks = this.homeworkService.findByStudent(student);
//            if (homeworks.size() == 0) {
//                result.append("<no submissions>\n");
//            } else {
//                for (Homework homework : homeworks) {
//                    result.append(String.format("--- Content: %s, Content type: %s\n",
//                            homework.getContent(), homework.getContentType()));
//                }
//            }
//        }
//        System.out.println(result.toString());


//      2. List all courses with their corresponding resources
//        List<Course> courses = this.courseService.findAllOrderedByDates();
//        for (Course course : courses) {
//            result.append(String.format("Course: %s Description: %s\n",
//                    course.getName(), course.getDescription()!=null?course.getDescription():"no description"));
//            List<Resource> resources = this.resourceService.findByCourse(course);
//            if (resources.size() == 0) {
//                result.append("<no resources>\n");
//            } else {
//                for (Resource resource : resources) {
//                    result.append(String.format("--- Name: %s, Type: %s, URL: %s\n",
//                            resource.getName(), resource.getTypeOfResource(), resource.getURL()));
//                }
//            }
//        }
//        System.out.println(result.toString());


//      3. List all courses with more than 5 resources.
//        List<Object[]> courses = this.courseService.getAllCoursesWithResourcesMoreThan(5L);
//        courses.forEach(c->System.out.printf("Course name: %s - %s resources\n", c[0],c[1]));


//      4. List all courses which were active on a given date
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d.M.yyyy");
//        Date date = simpleDateFormat.parse("06.10.2017");
//        List<Object[]> activeCourses = this.courseService.getAllActiveOnDate(date);
//        activeCourses.forEach(c->System.out.printf("Name: %s, Start date: %s, End date: %s, Duration: %s days, Enrolled students: %s\n",
//                c[0],c[1],c[2],c[3],c[4]));


//      5. For each student, calculate the number of courses he/she has enrolled in, the total price of these courses
//         and the average price per course for the student

        List<Object[]> studentsCourses = this.studentService.getAllStudentsAndCalculateCoursePrices();
        studentsCourses
                .forEach(sc->System.out.printf("Student name: %s, Number of courses: %s, Total price: %s, Average price: %s\n",
                        sc[0], sc[1], sc[2], sc[3]));
    }


    private void seedDatabase() throws ParseException {
        Random random = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String[] regYears = new String[]{"2012", "2011", "2005", "2006", "2007", "2008", "2009", "2010"};
        String[] birthYears = new String[]{"1989", "1999", "1998", "1996", "1997", "1995", "1994", "2000", "2001", "1987"};
        String[] months = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        String[] dates = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"};
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d.M.yyyy");

        List<Student> students = new ArrayList<>();

//      Seed 30 students
        for (int i = 0; i < 30; i++) {
            StringBuilder studentNameBuilder = new StringBuilder();
            for (int j = 0; j < 14; j++) {
                if (j == 0 || j == 7) {
                    studentNameBuilder.append((char) (alphabet.charAt(random.nextInt(alphabet.length())) - 32));
                } else {
                    studentNameBuilder.append(alphabet.charAt(random.nextInt(alphabet.length())));
                }
                if (j == 6) {
                    studentNameBuilder.append(" ");
                }
            }
            String studentName = studentNameBuilder.toString();

            StringBuilder studentPhoneBuilder = new StringBuilder();
            for (int j = 0; j < 10; j++) {
                studentPhoneBuilder.append(numbers.charAt(random.nextInt(numbers.length())));
                if (j == 3 || j == 6) {
                    studentPhoneBuilder.append("-");
                }
            }
            String studentPhone = studentPhoneBuilder.toString();

            String regDate = "";
            regDate += dates[random.nextInt(dates.length)];
            regDate += ".";
            regDate += months[random.nextInt(months.length)];
            regDate += ".";
            regDate += regYears[random.nextInt(regYears.length)];
            Date registrationDate = simpleDateFormat.parse(regDate);

            String birthDate = "";
            birthDate += dates[random.nextInt(dates.length)];
            birthDate += ".";
            birthDate += months[random.nextInt(months.length)];
            birthDate += ".";
            birthDate += birthYears[random.nextInt(birthYears.length)];
            Date birthday = simpleDateFormat.parse(birthDate);

            Student student = new Student();
            student.setName(studentName);
            student.setPhoneNumber(studentPhone);
            student.setRegistrationDate(registrationDate);
            student.setBirthday(birthday);
            this.studentService.save(student);
            students.add(student);
        }

        List<Course> courses = new ArrayList<>();

//      Seed 10 courses
        for (int i = 0; i < 10; i++) {
            StringBuilder courseNameBuilder = new StringBuilder();
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    courseNameBuilder.append((char) (alphabet.charAt(random.nextInt(alphabet.length())) - 32));
                } else {
                    courseNameBuilder.append(alphabet.charAt(random.nextInt(alphabet.length())));
                }
            }
            String courseName = courseNameBuilder.toString();

            String startDate = "";
            startDate += dates[random.nextInt(dates.length)];
            startDate += ".";
            startDate += months[random.nextInt(months.length)];
            startDate += ".";
            startDate += "2017";
            Date courseStartDate = simpleDateFormat.parse(startDate);

            String endDate = "";
            endDate += dates[random.nextInt(dates.length)];
            endDate += ".";
            endDate += months[random.nextInt(months.length)];
            endDate += ".";
            endDate += "2018";
            Date courseEndDate = simpleDateFormat.parse(endDate);

            StringBuilder coursePriceBuilder = new StringBuilder();
            for (int j = 0; j < 5; j++) {
                coursePriceBuilder.append(numbers.charAt(random.nextInt(numbers.length())));
                if (j == 2) {
                    coursePriceBuilder.append(".");
                }
            }
            String coursePrice = coursePriceBuilder.toString();

            Set<Student> studentsSet = new HashSet<>();

            int limit = random.nextInt(students.size());
            for (int j = 0; j < limit; j++) {
                Integer studentIndex = random.nextInt(students.size());
                Student student = students.get(studentIndex);
                studentsSet.add(student);
            }

            Course course = new Course();
            course.setName(courseName);
            course.setStartDate(courseStartDate);
            course.setEndDate(courseEndDate);
            course.setPrice(new BigDecimal(coursePrice));
            course.setStudents(studentsSet);
            this.courseService.save(course);
            courses.add(course);
        }

//      Seed 50 homeworks
        for (int i = 0; i < 50; i++) {
            ContentType contentType = ContentType.values()[random.nextInt(2)];
            String content = "src/resources/homeworks/";
            content += UUID.randomUUID().toString();
            if (contentType == ContentType.PDF) {
                content += ".pdf";
            } else {
                content += ".zip";
            }

            String subDate = "";
            subDate += dates[random.nextInt(dates.length)];
            subDate += ".";
            subDate += months[random.nextInt(months.length)];
            subDate += ".";
            subDate += regYears[random.nextInt(regYears.length)];
            Date submissionDate = simpleDateFormat.parse(subDate);

            int studentIndex = random.nextInt(students.size());
            Student student = students.get(studentIndex);

            int courseIndex = random.nextInt(courses.size());
            Course course = courses.get(courseIndex);

            Homework homework = new Homework();
            homework.setContent(content);
            homework.setContentType(contentType);
            homework.setSubmissionDate(submissionDate);
            homework.setCourse(course);
            homework.setStudent(student);
            this.homeworkService.save(homework);
        }

//      Seed 50 resources
        for (int i = 0; i < 50; i++) {

            String resourceName = UUID.randomUUID().toString();

            TypeOfResource typeOfResource = TypeOfResource.values()[random.nextInt(4)];

            int courseIndex = random.nextInt(courses.size());
            Course course = courses.get(courseIndex);

            String URL = "http://softuni.bg/";
            URL += course.getName() + "/" + resourceName;


            Resource resource = new Resource();
            resource.setName(resourceName);
            resource.setTypeOfResource(typeOfResource);
            resource.setCourse(course);
            resource.setURL(URL);
            this.resourceService.save(resource);
        }

    }
}
