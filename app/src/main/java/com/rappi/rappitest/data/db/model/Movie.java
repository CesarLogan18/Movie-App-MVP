package com.rappi.rappitest.data.db.model;

import android.support.annotation.NonNull;

import com.rappi.rappitest.utils.ErrorHandlerUtils;

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

    @Property(nameInDb = "adult_content")
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

    @NonNull
    public String getName() {
        return ErrorHandlerUtils.checkIfStringNullReturnEmpty(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    public String getLanguage() {
        return ErrorHandlerUtils.checkIfStringNullReturnEmpty(language);
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

    @NonNull
    public String getCreatedAt() {
        return ErrorHandlerUtils.checkIfStringNullReturnEmpty(createdAt);
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @NonNull
    public String getUpdatedAt() {
        return ErrorHandlerUtils.checkIfStringNullReturnEmpty(updatedAt);
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @NonNull
    public String getImageUrl() {
        return ErrorHandlerUtils.checkIfStringNullReturnEmpty(imageUrl);
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @NonNull
    public String getDate() {
        return ErrorHandlerUtils.checkIfStringNullReturnEmpty(date);
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

    @NonNull
    public String getOverview() {
        return ErrorHandlerUtils.checkIfStringNullReturnEmpty(overview);
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