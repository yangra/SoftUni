package softuni.store.models.viewModels.game;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GameDetailsView implements Serializable {
    private String title;
    private BigDecimal price;
    private Double size;
    private String trailer;
    private String thumbnailURL;
    private String description;
    private Date releaseDate;

    public GameDetailsView() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\n" +
                "Price: " + price + "\n" +
                "Size: " + size + "\n" +
                "Trailer: https://www.youtube.com/watch?v=" + trailer + "\n" +
                "ThumbnailURL: " + thumbnailURL + "\n" +
                "Description: " + description + "\n" +
                "ReleaseDate: " + releaseDate + "\n";

    }
}
