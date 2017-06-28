package org.check;

import org.services.ParametrDefinitions;

import java.util.List;
import java.util.Map;


/**
 * Created by Юлия on 20.06.2017.
 */
public interface Check {
  boolean check(List<ParametrDefinitions> parametrDefinitions, Map<String,String> optionalArguments, String args[]);
}
