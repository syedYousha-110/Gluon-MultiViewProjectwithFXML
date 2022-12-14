package com.gluonapplication.Model.Enum;

public enum FXMLView {
    API("api.fxml"),

    DASHBOARD("dashboard.fxml"),
    SCRAPPING("scrapping.fxml"),
    MENU("menu.fxml"),
    PROFILE("profile.fxml"), NEW_DASHBOARD("dashboard.fxml");

    private String fileName;

    FXMLView(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
