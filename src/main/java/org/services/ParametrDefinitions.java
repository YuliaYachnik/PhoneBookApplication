package org.services;

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


