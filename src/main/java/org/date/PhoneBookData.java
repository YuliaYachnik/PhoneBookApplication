package org.date;

public class PhoneBookData implements DataObjectWorking {
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

    public PhoneBookData(){}
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
    public String getField1() {
        return name;
    }

    @Override
    public String getField2() {
        return phone;
    }

    @Override
    public String getField3() {
        return file;
    }

    @Override
    public String getField4() {
        return dir;
    }
}
