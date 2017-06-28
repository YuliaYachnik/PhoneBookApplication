package org.date;

public class LibraryData implements PrintObject{
    private String bookName;
    private String authorSurName;
    private String edition; //тираж
    private String filename;
    private String dirname;

    public LibraryData(String bookName, String authorSurName, String edition, String filename, String dirname) {
        this.bookName = bookName;
        this.authorSurName = authorSurName;
        this.edition = edition;
        this.filename = filename;
        this.dirname = dirname;
    }

    public LibraryData() {
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorSurName() {
        return authorSurName;
    }

    public String getEdition() {
        return edition;
    }

    public String getFilename() {
        return filename;
    }

    public String getDirname() {
        return dirname;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthorSurName(String authorSurName) {
        this.authorSurName = authorSurName;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setDirname(String dirname) {
        this.dirname = dirname;
    }

    @Override
    public String print() {
        return "Book name ='" + bookName + '\'' +
                ",Author Surname ='" + authorSurName + '\'' +
                ", Number of edition ='" + edition + '\'' +
                ", File name ='" + filename + '\'' +
                ", Name of directory ='" + dirname;
    }
}
