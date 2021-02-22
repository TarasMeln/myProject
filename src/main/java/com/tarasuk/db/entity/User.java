package com.tarasuk.db.entity;

import java.util.Objects;

public class User {
    private String password;
    private String email;
    private boolean isAdmin;

    public boolean getAdmin() {
        return isAdmin;
    }

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isAdmin == user.isAdmin &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, email, isAdmin);
    }
}
