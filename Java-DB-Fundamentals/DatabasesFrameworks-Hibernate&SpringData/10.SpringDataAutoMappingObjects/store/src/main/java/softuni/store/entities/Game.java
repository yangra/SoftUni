package softuni.store.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name="games")
public class Game {
    private Long id;
    private String title;
    private String trailer;
    private String thumbnailURL;
    private Double size;
    private BigDecimal price;
    private String description;
    private Date releaseDate;

    private Set<User> gameOwners;
    private Set<User> gameBuyers;

    public Game() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    @Column(name = "thumbnail_url")
    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    @Basic
    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    @Basic
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "release_date")
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @ManyToMany(mappedBy = "boughtGames")
    public Set<User> getGameOwners() {
        return gameOwners;
    }

    public void setGameOwners(Set<User> gameOwners) {
        this.gameOwners = gameOwners;
    }
    @ManyToMany(mappedBy = "shoppingCartGames")
    public Set<User> getGameBuyers() {
        return gameBuyers;
    }

    public void setGameBuyers(Set<User> gameBuyers) {
        this.gameBuyers = gameBuyers;
    }
}
