package softuni.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "homeworks")
public class Homework {
    private Long id;
    private String content;
    private ContentType contentType;
    private Date submissionDate;

    private Student student;
    private Course course;

    public Homework() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "content_type", nullable = false)
    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    @Column(name = "submission_date", nullable = false)
    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id",nullable = false)
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id",nullable = false)
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
