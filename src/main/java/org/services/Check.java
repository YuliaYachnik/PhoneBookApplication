package org.services;

import java.util.List;

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
    public boolean check(List<ParametrDefinitions> parametrDefinitions, String args[]);
}
