package org.date;

public class LibraryData{
    private String name;
    private String authorSurName;
    private String filename;
    private String dirname;

    public LibraryData(String name, String authorSurName, String filename, String dirname) {
        this.name = name;
        this.authorSurName = authorSurName;
        this.filename = filename;
        this.dirname = dirname;
    }

    public LibraryData() {
    }

    public String getBookName() {
        return name;
    }

    public String getAuthorSurName() {
        return authorSurName;
    }

    public String getFilename() {
        return filename;
    }

    public String getDirname() {
        return dirname;
    }

    public void setBookName(String name) {
        this.name = name;
    }

    public void setAuthorSurName(String authorSurName) {
        this.authorSurName = authorSurName;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setDirname(String dirname) {
        this.dirname = dirname;
    }


    public String print() {
        return "Book name ='Library" + name + '\'' +
                ",Author Surname ='" + authorSurName + '\'' +
                ", File name ='" + filename + '\'' +
                ", Name of directory ='" + dirname;
    }
}
