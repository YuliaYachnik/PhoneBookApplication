package org.date;

public class LibraryData implements SetGetObject{
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

    public LibraryData(){}

    @Override
    public String toString() {
        return "Book name ='" + name + '\'' +
                ", Author Surname ='" + authorSurName + '\'' +
                ", File name ='" + filename + '\'' +
                ", Name of directory ='" + dirname;
    }

    @Override
    public void setParams(String str1, String str2, String str3, String str4) {
        this.name = str1;
        this.authorSurName = str2;
        this.filename = str3;
        this.dirname = str4;
    }

    @Override
    public String getField1() {
        return name;
    }

    @Override
    public String getField2() {
        return authorSurName;
    }

    @Override
    public String getField3() {
        return filename;
    }

    @Override
    public String getField4() {
        return dirname;
    }
}
