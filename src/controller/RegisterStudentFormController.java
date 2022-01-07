package controller;

import bo.BOFactory;
import bo.custom.ProgramBO;
import bo.custom.ReserveDetailBO;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import dto.ProgramDTO;
import dto.ReserveDTO;
import dto.StudentDTO;
import entity.Program;
import entity.ReserveDetails;
import entity.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class RegisterStudentFormController {
    public AnchorPane FIRegister;
    public FontAwesomeIconView close;
    public JFXButton btnAdd;
    public JFXButton btnDelete;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtContact;
    public TextField txtId;
    public DatePicker dateBirth;
    public ComboBox cmbGender;
    public ComboBox cmbProgram;
    public Label lblDate;
    public AnchorPane p3;
    private final StudentBO studentBO = BOFactory.getInstance().getBO(BOFactory.BOType.STUDENT);
    private final ReserveDetailBO reserveDetailBO = BOFactory.getInstance().getBO(BOFactory.BOType.RESERVE);
    private final ProgramBO programBO = BOFactory.getInstance().getBO(BOFactory.BOType.PROGRAM);

    public void initialize(){
        cmbGender.getItems().addAll(
                "Male",
                "Female"
        );
        loadDate();
        loadAllPrograms();
    }

    private void loadAllPrograms() {
        try {
            List<ProgramDTO> all = programBO.selectAll();
            for (ProgramDTO dto : all) {
                cmbProgram.getItems().add(dto.getId());
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadDate() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(f.format(date));
    }


    public void closeWindowOnAction(MouseEvent mouseEvent) throws IOException {
        URL resource  = (getClass().getResource("../view/DashBoardForm.fxml"));
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage)FIRegister.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void addStudentOnAction(ActionEvent actionEvent) throws Exception {
        String id = txtId.getText();
        String regDate = lblDate.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String Gender = (String) cmbGender.getValue();
        LocalDate date = dateBirth.getValue();
        String proId = (String) cmbProgram.getValue();


        try {
            if (studentBO.add(new StudentDTO(
                    id,
                    name,
                    address,
                    Gender,
                    date,
                    contact

            )) && reserveDetailBO.add(new ReserveDTO(
                    id,
                    proId,
                    regDate))){

                new Alert(Alert.AlertType.INFORMATION, " Added..!").show();

                txtId.setText(null);
                txtName.setText(null);
                txtContact.setText(null);
                txtAddress.setText(null);

            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.INFORMATION, " Student Added..!").show();
        }
    }

    public void textFields_Key_Released(KeyEvent keyEvent) {
    }

    public void clearOnAction(ActionEvent actionEvent) {
    }
}
