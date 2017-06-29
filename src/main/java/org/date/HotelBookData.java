package org.date;


public class HotelBookData {
    private String name;
    private String hotelName;
    private String fileName;
    private String dirName;

    public HotelBookData(String name,String hotelName, String fileName, String dirName) {
        this.name = name;
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


    public String print() {
        return "Name ='Hotel" + name + '\'' +
                ", Hotel name ='" + hotelName + '\'' +
                ", File name ='" + fileName + '\'' +
                ", Name of directory ='" + dirName;
    }
}
