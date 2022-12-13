package com.gluonapplication.Controller.Enum;

public enum Extensions {

    EXCEL("*.xlsx"),
    CSV("*.csv");

   private String extension;
    Extensions(String extension){
        this.extension = extension;
    }
    public String getExtension(){
        return extension;
    }
}
