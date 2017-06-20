package org.date;

public class Data {
    private String name;
    private String phone;
    private String fileName;
    private String dirName;
    
    public Data(String name, String phone, String fileName, String dirName) {
        this.name = name;
        this.phone = phone;
        this.fileName = fileName;
        this.dirName = dirName;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getFileName() {
        return fileName;
    }

    public String getDirName() {
        return dirName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    @Override
    public String toString() {
        return "Name ='" + name + '\'' +
                ", Phone number ='" + phone + '\'' +
                ", File Name ='" + fileName + '\'' +
                ", Name of Directory='" + dirName + '\'';
    }
}
