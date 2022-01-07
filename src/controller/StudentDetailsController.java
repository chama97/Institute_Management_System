package controller;

import bo.BOFactory;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.tm.ProgramTM;
import view.tm.StudentTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

public class StudentDetailsController {
    public AnchorPane studentDetails;
    public TableView<StudentTM> tblStudent;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colGender;
    public TableColumn colBirth;
    public TableColumn colContact;
    public JFXButton btnDelete;
    public JFXButton btnUpdate;
    private final StudentBO studentBO = BOFactory.getInstance().getBO(BOFactory.BOType.STUDENT);

    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colBirth.setCellValueFactory(new PropertyValueFactory<>("date"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));

        tblStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnDelete.setDisable(newValue == null);
            btnUpdate.setDisable(newValue == null);
        });
        loadAllStudent();
    }

    private void loadAllStudent() {
        tblStudent.getItems().clear();
        try {
            List<StudentDTO> allStudents = studentBO.selectAll();
            for (StudentDTO studentDTO : allStudents) {
                tblStudent.getItems().add(new StudentTM(studentDTO.getId(), studentDTO.getName(), studentDTO.getAddress(), studentDTO.getGender(), studentDTO.getDate(), studentDTO.getContact()));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeWindowOnAction(MouseEvent mouseEvent) throws IOException {
        URL resource  = (getClass().getResource("../view/DashBoardForm.fxml"));
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage)studentDetails.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void deleteStudentOnAction(ActionEvent actionEvent) {
        String id = tblStudent.getSelectionModel().getSelectedItem().getId();
        try {
            if(studentBO.delete(id))
                tblStudent.getItems().remove(tblStudent.getSelectionModel().getSelectedItem());
            tblStudent.getSelectionModel().clearSelection();
            new Alert(Alert.AlertType.CONFIRMATION, "Deleted Successfully " + id).show();


        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to delete the customer " + id).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateStudentOnAction(ActionEvent actionEvent) {
    }
}
