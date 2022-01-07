package controller;

import bo.BOFactory;
import bo.custom.ProgramBO;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXButton;
import dto.ProgramDTO;
import dto.StudentDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.tm.ProgramTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramFormController {
    public AnchorPane FIDProgram;
    public TableView<ProgramTM> tblProgram;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colDuration;
    public TableColumn colFee;
    public JFXButton btnDelete;
    public JFXButton btnUpdate;
    public JFXButton btnAdd;
    public TextField txtId;
    public TextField txtProgram;
    public TextField txtDuration;
    public TextField txtFee;

    private final ProgramBO programBO = BOFactory.getInstance().getBO(BOFactory.BOType.PROGRAM);

    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("program"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("fee"));

        initUI();
        tblProgram.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnDelete.setDisable(newValue == null);
            btnUpdate.setDisable(newValue == null);
        });
        loadAllPrograms();
    }

    private void loadAllPrograms() {
        tblProgram.getItems().clear();
        try {
            List<ProgramDTO> allPrograms = programBO.selectAll();
            for (ProgramDTO programDTO : allPrograms) {
                tblProgram.getItems().add(new ProgramTM(programDTO.getId(), programDTO.getProgram(), programDTO.getDuration(), programDTO.getFee()));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initUI() {
        txtId.clear();
        txtProgram.clear();
        txtDuration.clear();
        txtFee.clear();
    }


    public void closeWindowOnAction(MouseEvent mouseEvent) throws IOException {
        URL resource  = (getClass().getResource("../view/DashBoardForm.fxml"));
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage)FIDProgram.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void deleteProgramOnAction(ActionEvent actionEvent) {
        String id = tblProgram.getSelectionModel().getSelectedItem().getId();
        try {
            if(programBO.delete(id))
            tblProgram.getItems().remove(tblProgram.getSelectionModel().getSelectedItem());
            tblProgram.getSelectionModel().clearSelection();
            new Alert(Alert.AlertType.CONFIRMATION, "Deleted Successfully " + id).show();
            initUI();

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to delete the customer " + id).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateProgramOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        String name = txtProgram.getText();
        String duration = txtDuration.getText();
        double fee = Double.parseDouble(txtFee.getText());

        try {
            if(programBO.update(new ProgramDTO(
                    id,
                    name,
                    duration,
                    fee
            ))){
                new Alert(Alert.AlertType.INFORMATION, "Updated").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addProgramOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        String name = txtProgram.getText();
        String duration = txtDuration.getText();
        double fee = Double.parseDouble(txtFee.getText());

        try {
            if(programBO.add(new ProgramDTO(
                    id,
                    name,
                    duration,
                    fee
            ))){
                initUI();
                new Alert(Alert.AlertType.INFORMATION, "Program saved Successfully..!").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error..! try again..").showAndWait();
        }
    }

    public void textFields_Key_Released(KeyEvent keyEvent) {
    }
}
