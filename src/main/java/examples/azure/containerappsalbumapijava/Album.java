package examples.azure.containerappsalbumapijava;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "album")
public class Album implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name = "title")
    private String title;

    @NotBlank
    @Column(name = "artist")
    private String artist;

    @Column(name = "price")
    private double price;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "bookUrl")
    private String bookUrl;

    public Album() {
    }

    public Album(int id, String title, String artist, double price, String imageUrl)  {
        checkPrice(price);
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.price = price;
        this.imageUrl = imageUrl;
    }    

    public Album(int id, String title, String artist, double price, String imageUrl, String bookUrl) {
        checkPrice(price);
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.price = price;
        this.imageUrl = imageUrl;
        this.bookUrl = bookUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        checkPrice(price);
        this.price = price;
    }

    public String getImage_url() {
        return imageUrl;
    }

    public void setImage_url(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBook_url() {
        return bookUrl;
    }
    public void setBook_url(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    @Override 
    public int hashCode() {
        return id;
    }

    @Override 
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        else if (o != null && !(o instanceof Album)) {
            return false;
        }

        return (this.id == ((Album)o).getId());
    }


    private void checkPrice(double price) {
        if (price < 0)  {
            throw new IllegalArgumentException("The value is negative.");
        }
    }
}
