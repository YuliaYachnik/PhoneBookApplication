package org.services;

/**
 * Created by Юлия on 22.06.2017.
 */
public class CheckManager {
    private String name;
    private String phone;
    private String fileName;
    private String dirName;

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

    public CheckManager returnValideObject(Check check){
        return this;
    }
}
