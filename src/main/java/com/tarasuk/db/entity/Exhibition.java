package com.tarasuk.db.entity;

import java.sql.Timestamp;
import java.util.Objects;

public class Exhibition {
    private long id;
    private String theme;
    private long hall;
    private Timestamp date;
    private double ticketPrice;

    public Exhibition() {
    }

    public Exhibition(String theme, long hall, Timestamp date, double ticketPrice) {
        this.theme = theme;
        this.hall = hall;
        this.date = date;
        this.ticketPrice = ticketPrice;
    }

    public Exhibition(long id, String theme, long hall, Timestamp date, double ticketPrice) {
        this.id = id;
        this.theme = theme;
        this.hall = hall;
        this.date = date;
        this.ticketPrice = ticketPrice;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public long getHall() {
        return hall;
    }

    public void setHall(long hall) {
        this.hall = hall;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Exhibition{" +
                "theme='" + theme + '\'' +
                ", hall=" + hall +
                ", date=" + date +
                ", ticketPrice=" + ticketPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exhibition that = (Exhibition) o;
        return hall == that.hall &&
                Double.compare(that.ticketPrice, ticketPrice) == 0 &&
                Objects.equals(theme, that.theme) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(theme, hall, date, ticketPrice);
    }
}
