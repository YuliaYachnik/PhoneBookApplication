package org.date;


public class HotelBookData implements SetGetObject  {
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

    public HotelBookData(){}

    public String print() {
        return "Name ='Hotel" + name + '\'' +
                ", Hotel name ='" + hotelName + '\'' +
                ", File name ='" + fileName + '\'' +
                ", Name of directory ='" + dirName;
    }

    @Override
    public void setParams(String str1, String str2, String str3, String str4) {
        this.name = str1;
        this.hotelName = str2;
        this.fileName = str3;
        this.dirName = str4;
    }

    @Override
    public String getField1() {
        return name;
    }

    @Override
    public String getField2() {
        return hotelName;
    }

    @Override
    public String getField3() {
        return fileName;
    }

    @Override
    public String getField4() {
        return dirName;
    }
}
