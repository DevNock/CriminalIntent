package com.google.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Sergey on 23.11.2015.
 */
public class Crime {

    private UUID id;
    private String title;
    private Date date;
    private Date time;

    private boolean solved;

    public Crime() {
        id = UUID.randomUUID();
        setDate(new Date());
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return title;
    }
}
