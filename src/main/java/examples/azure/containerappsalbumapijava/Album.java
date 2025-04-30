package examples.azure.containerappsalbumapijava;

import java.io.Serializable;
import java.lang.annotation.Inherited;

import javax.annotation.processing.Generated;

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

    @Column(name = "image_url")
    private String image_url;

    @Column(name = "book_url")
    private String book_url;

    public Album() {
    }

    public Album(int id, String title, String artist, double price, String image_url) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.price = price;
        this.image_url = image_url;
    }    

    public Album(int id, String title, String artist, double price, String image_url, String book_url) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.price = price;
        this.image_url = image_url;
        this.book_url = book_url;
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

    public void setTitle(String title) {
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
        this.price = price;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getBook_url() {
        return book_url;
    }
    public void setBook_url(String book_url) {
        this.book_url = book_url;
    }
}
