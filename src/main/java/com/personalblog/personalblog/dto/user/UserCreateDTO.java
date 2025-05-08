package com.personalblog.personalblog.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserCreateDTO {

    @NotNull(message = "The Name attribute is required!")
    private String name;

    @NotNull(message = "The Email attribute is required!")
    @Email(message = "The Email attribute must be a valid email address!")
    private String email;

    @NotBlank(message = "The Password attribute is required!")
    @Size(min = 8, message = "The Password must be at least 8 characters long")
    private String password;

    @Size(max = 5000, message = "The photo link cannot exceed 5000 characters")
    private String photo;

    public UserCreateDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}