package com.gluonapplication.Controller.Enum;

public enum View {
    API("api.fxml"),

    DASHBOARD("dashboard.fxml"),
    SCRAPPING("scrapping.fxml"),
    MENU("Menu-View.fxml"),
    PROFILE("profile.fxml"), NEW_DASHBOARD("newdashboard.fxml");

    private String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
