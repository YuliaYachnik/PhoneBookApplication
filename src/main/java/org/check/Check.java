package org.check;

import org.services.ParametrDefinitions;
import java.util.List;
import java.util.Map;

public interface Check {
  boolean check(List<ParametrDefinitions> parametrDefinitions, Map<String,String> optionalArguments, String args[]);
}
