package com.gluonapplication.Model.Enum;


public enum Format {

    JSON("json"),XML("xml");

    private String format;
    Format(String format){
        setFormat(format);
    }
    private void setFormat(String format){
        this.format=format;
    }
    public String getFormat(){
        return this.format;
    }
}
