package com.personalblog.personalblog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "The title attribute is required.")
    @Size(min = 5, max = 100, message = "The title attribute must contain a minimum of 5 and a maximum of 100 characters.")
    private String title;

    @NotBlank(message = "The text attribute is required.")
    @Size(min = 10, max = 1000, message = "The text attribute must contain a minimum of 10 and a maximum of 1000 characters.")
    private String text;

    @UpdateTimestamp
    private LocalDateTime date;

    @ManyToOne
    @JsonIgnoreProperties("post")
    private Theme theme;

    @ManyToOne
    @JsonIgnoreProperties("post")
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }
}
