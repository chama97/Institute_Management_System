package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginFormController {
    public AnchorPane adminLogin;
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public Label lblWrong;

    public void dashboardOnAction(ActionEvent actionEvent) throws IOException {
        URL resource  = (getClass().getResource("../view/DashboardForm.fxml"));
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) adminLogin.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void UserAction(ActionEvent actionEvent) {
        txtPassword.requestFocus();
    }
}
