package dev.ridhoy.model;

import jakarta.persistence.*;

@Entity
public class GalleryImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;
    private String alt;

    // Default constructor
    public GalleryImage() {}

    // constructor to quickly create instances.
    public GalleryImage(String url, String alt) {
        this.url = url;
        this.alt = alt;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }
}