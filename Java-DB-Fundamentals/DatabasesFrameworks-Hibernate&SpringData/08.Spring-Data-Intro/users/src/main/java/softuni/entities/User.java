package softuni.entities;

import softuni.validators.Email;
import softuni.validators.Password;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "users")
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private String profilePicturePath;
    private Date registeredOn;
    private Date lastTimeLoggedIn;
    private Integer age;
    private Boolean isDeleted;
    private Town bornTown;
    private Town livingTown;

    private Set<User> friends;
    private Set<Album> albums;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Transient
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username.length() < 4 || username.length() > 30) {
            throw new IllegalArgumentException("Username should be between 4 and 30 symbols long.");
        }
        this.username = username;
    }

    @Column(nullable = false)
    @Password(containsDigit = true,
            containsLowercase = true,
            containsSpecialSymbols = true,
            containsUppercase = true,
            maxLength = 50,
            message = "Password must contain 1 lowercase letter, 1 uppercase letter, " +
                    "1 digit, 1 special symbol (!, @, #, $, %, ^, &, *, (, ), _, +, <, >, ?)")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(nullable = false)
    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "profile_picture_path")
    public String getProfilePicturePath() {
        return profilePicturePath;
    }

    public void setProfilePicturePath(String profilePicturePath) {
//        if (profilePicture.length > 1024 * 1024) {
//            throw new IllegalArgumentException("Picture is too big!");
//        }
        this.profilePicturePath = profilePicturePath;
    }

    @Column(name = "registered_on")
    public Date getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(Date registeredOn) {
        this.registeredOn = registeredOn;
    }

    @Column(name = "last_time_logged_in")
    public Date getLastTimeLoggedIn() {
        return lastTimeLoggedIn;
    }

    public void setLastTimeLoggedIn(Date lastTimeLoggedIn) {
        this.lastTimeLoggedIn = lastTimeLoggedIn;
    }

    @Basic
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if (age < 1 || age > 120) {
            throw new IllegalArgumentException("Invalid age!");
        }
        this.age = age;
    }

    @Column(name = "is_deleted")
    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @ManyToOne
    @JoinColumn(name = "born_town_id", referencedColumnName = "id")
    public Town getBornTown() {
        return bornTown;
    }

    public void setBornTown(Town bornTown) {
        this.bornTown = bornTown;
    }

    @ManyToOne
    @JoinColumn(name = "living_town_id", referencedColumnName = "id")
    public Town getLivingTown() {
        return livingTown;
    }

    public void setLivingTown(Town livingTown) {
        this.livingTown = livingTown;
    }

    @ManyToMany
    @JoinTable(name = "users_friends",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id"))
    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
}
