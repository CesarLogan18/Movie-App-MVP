
package com.rappi.rappitest.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;


@Entity(nameInDb = "movie")
public class Movie {

    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "name")
    private String name;

    @Property(nameInDb = "language")
    private String language;

    @Property(nameInDb = "vote_avg")
    private double voteAvg;

    @Property(nameInDb = "created_at")
    private String createdAt;

    @Property(nameInDb = "updated_at")
    private String updatedAt;


    @Generated(hash = 551405841)
    public Movie(Long id, String name, String language, double voteAvg, String createdAt, String updatedAt) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.voteAvg = voteAvg;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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
}