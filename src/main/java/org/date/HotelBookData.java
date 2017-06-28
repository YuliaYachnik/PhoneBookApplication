package org.date;


public class HotelBookData implements PrintObject {
    private String name;
    private String Surname;
    private String Passport;
    private String hotelName;
    private String fileName;
    private String dirName;

    public HotelBookData(String name, String surname, String passport, String hotelName, String fileName, String dirName) {
        this.name = name;
        Surname = surname;
        Passport = passport;
        this.hotelName = hotelName;
        this.fileName = fileName;
        this.dirName = dirName;
    }

    public HotelBookData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getPassport() {
        return Passport;
    }

    public void setPassport(String passport) {
        Passport = passport;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    @Override
    public String print() {
        return "Name ='" + name + '\'' +
                ", Surname ='" + Surname + '\'' +
                ", Passport ='" + Passport + '\'' +
                ", Hotel name ='" + hotelName + '\'' +
                ", File name ='" + fileName + '\'' +
                ", Name of directory ='" + dirName;
    }
}
