package com.library.model;

public class Librarian {
    private String librarianId;
    private String name;
    private String password;

    public Librarian(String librarianId, String name, String password) {
        this.librarianId = librarianId;
        this.name = name;
        this.password = password;
    }

    public String getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(String librarianId) {
        this.librarianId = librarianId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return librarianId + " | " + name;
    }
}
