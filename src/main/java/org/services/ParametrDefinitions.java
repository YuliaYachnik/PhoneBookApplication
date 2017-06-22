package org.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Юлия on 19.06.2017.
 */
public class ParametrDefinitions {
    private String name;
    private boolean isOptional;


    public ParametrDefinitions(String name, boolean isOptional) {
        this.name = name;
        this.isOptional = isOptional;
    }

    }


