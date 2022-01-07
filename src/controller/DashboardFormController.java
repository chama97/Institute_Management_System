package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class DashboardFormController {
    public AnchorPane DashFID;
    public Label lblRole;
    public Label lblUserName;
    public AnchorPane Dash2FID;
    public AnchorPane p3;
    public AnchorPane p3shadow;
    public Label lblDate;
    public Label lblTime;
    public AnchorPane p2;
    public AnchorPane p2shadow;
    public Label lblSale;
    public Label lblOrder;

    public void logOutAction(ActionEvent actionEvent) throws IOException {
        URL resource  = (getClass().getResource("../view/LoginForm.fxml"));
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) DashFID.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    void loadUi(String fileName) throws IOException {
        URL resource = getClass().getResource("../view/"+fileName+".fxml");
        Parent load = FXMLLoader.load(resource);
        Dash2FID.getChildren().clear();
        Dash2FID.getChildren().add(load);
    }

    public void registerStudentOnAction(ActionEvent actionEvent) throws IOException {
        loadUi("RegisterStudentForm");
    }

    public void studentsOnAction(ActionEvent actionEvent) throws IOException {
        loadUi("StudentDetails");
    }

    public void incomeReportOnAction(ActionEvent actionEvent) throws IOException {
       // loadUi("CustomerForm");
    }

    public void programsOnAction(ActionEvent actionEvent) throws IOException {
        loadUi("ProgramForm");
    }

    public void reserveDetailsOnAction(ActionEvent actionEvent) throws IOException {
        loadUi("ReserveDetailsForm");
    }

}
