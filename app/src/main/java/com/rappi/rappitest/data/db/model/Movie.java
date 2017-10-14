
package com.rappi.rappitest.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;


@Entity(nameInDb = "movie")
public class Movie implements Serializable {

    private static final long serialVersionUID = 7526472295622776147L;

    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "name")
    private String name;

    @Property(nameInDb = "language")
    private String language;

    @Property(nameInDb = "vote_avg")
    private double voteAvg;

    @Property(nameInDb = "image")
    private String imageUrl;

    @Property(nameInDb = "date")
    private String date;

    @Property(nameInDb = "created_at")
    private String createdAt;

    @Property(nameInDb = "updated_at")
    private String updatedAt;

    @Property(nameInDb = "category")
    private int category;

    @Property(nameInDb = "overview")
    private String overview;

    @Property(nameInDb = "adult_contemt")
    private boolean adultContent;

    @Property(nameInDb = "popularity")
    private double popularity;

    @Generated(hash = 218898591)
    public Movie(Long id, String name, String language, double voteAvg, String imageUrl, String date,
            String createdAt, String updatedAt, int category, String overview, boolean adultContent,
            double popularity) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.voteAvg = voteAvg;
        this.imageUrl = imageUrl;
        this.date = date;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.category = category;
        this.overview = overview;
        this.adultContent = adultContent;
        this.popularity = popularity;
    }

    @Generated(hash = 1263461133)
    public Movie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getVoteAvg() {
        return voteAvg;
    }

    public void setVoteAvg(double voteAvg) {
        this.voteAvg = voteAvg;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public boolean isAdultContent() {
        return adultContent;
    }

    public void setAdultContent(boolean adultContent) {
        this.adultContent = adultContent;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public boolean getAdultContent() {
        return this.adultContent;
    }
}