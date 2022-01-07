package controller;


import bo.BOFactory;
import bo.custom.ProgramBO;
import bo.custom.ReserveDetailBO;
import dto.ProgramDTO;
import dto.ReserveDTO;
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
import view.tm.ReserveTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

public class ReserveDetailsFormController {
    public AnchorPane FIDReserveDetails;
    public TableView<ReserveTM> tblReserve;
    public TableColumn colSID;
    public TableColumn colPID;
    public TableColumn colDuration;
    public TableColumn colFee;

    private final ReserveDetailBO reserveDetailBO = BOFactory.getInstance().getBO(BOFactory.BOType.RESERVE);

    public void initialize() {
        colSID.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colPID.setCellValueFactory(new PropertyValueFactory<>("proId"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("date"));


        tblReserve.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        });
        loadAllPrograms();
    }

    private void loadAllPrograms() {
        tblReserve.getItems().clear();
        try {
            List<ReserveDTO> allReserves = reserveDetailBO.selectAll();
            for (ReserveDTO reserveDTO : allReserves) {
                tblReserve.getItems().add(new ReserveTM(reserveDTO.getStudentId(), reserveDTO.getProId(), reserveDTO.getDate()));
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
        Stage window = (Stage)FIDReserveDetails.getScene().getWindow();
        window.setScene(new Scene(load));
    }

}
