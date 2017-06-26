package org.services;

import java.util.List;
import java.util.Map;

/**
 * Created by Юлия on 20.06.2017.
 */
public interface Check {
    /**
     *
     * @param parametrDefinitions
     * @param args
     * @return
     */
    public boolean check(List<ParametrDefinitions> parametrDefinitions, Map<String,String> optionalArguments, String args[]);
}
