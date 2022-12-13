package com.gluonapplication.Controller.Enum;


public enum Constants {
    API_KEY("AYQF7dunWQaMNbITI6JJbdtsxhTAOWEqRbrQ-ZfO9_9tq1GQbFZ67gzS");

    final String key;
    Constants(String key){
        this.key = key;
    }
    public String getKey(){
        return this.key;
    }

}
