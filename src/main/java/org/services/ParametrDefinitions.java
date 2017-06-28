package org.services;

/**
 * Created by Юлия on 19.06.2017.
 */
public class ParametrDefinitions {
    private String name;
    private boolean isMandatory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMandatory() {
        return isMandatory;
    }

    public ParametrDefinitions(String name, boolean isMandatory) {
        this.name = name;
        this.isMandatory = isMandatory;
    }
}


