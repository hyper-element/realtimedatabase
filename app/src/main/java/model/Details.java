package model;

/**
 * Created by ADMIN on 10-10-2016.
 */

public class Details {
    int id;
    String name;
    String surname;
    String extra;

    public Details(int id, String name, String surname, String extra) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.extra = extra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
