package org.date;

public class PhoneBookData implements SetGetObject {
    private String name;
    private String phone;
    private String file;
    private String dir;
    
    public PhoneBookData(String name, String phone, String file, String dir) {
        this.name = name;
        this.phone = phone;
        this.file = file;
        this.dir = dir;
    }

    public PhoneBookData() {
    }

    @Override
    public String toString() {
        return "Name ='" + name + '\'' +
                ", Phone number ='" + phone + '\'' +
                ", File Name ='" + file + '\'' +
                ", Name of Directory ='" + dir + '\'';
    }

    @Override
    public void setParams(String name, String phone, String file, String dir) {
        this.name = name;
        this.phone = phone;
        this.file = file;
        this.dir = dir;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public String getFile() {
        return file;
    }

    @Override
    public String getDir() {
        return dir;
    }
}
