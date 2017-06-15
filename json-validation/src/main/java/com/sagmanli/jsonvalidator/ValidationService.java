package com.sagmanli.jsonvalidator;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;


public final class ValidationService {
  private ValidationService(){}
  

  public static boolean isJSONValid(Validation validation ) {
    try {
       final ObjectMapper mapper = new ObjectMapper();
       String jsonString = validation.getContent();
       validation.setTreeRep(mapper.readTree(jsonString).toString());
       validation.setValid(true);
       return true;
    } catch (IOException e) {
       return false;
    }
  }
  
}