package lk.ijse.Furniture.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.Furniture.dto.AttendeDto;
import lk.ijse.Furniture.dto.EmployeeDto;
import lk.ijse.Furniture.model.Attendance;
import lk.ijse.Furniture.model.Employee;
import lk.ijse.Furniture.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeAttendanceFormController {
    private static AttendeDto dto;

    @FXML
    private DatePicker txtDate;

    public JFXTextField txtEAID;
    public JFXTextField txtEID;
    public JFXTextField txtAttend;
    public JFXTextField txtTime;
    public TableColumn colAttendId;
    public TableColumn colEid;
    public TableColumn colWorkingHourese;
    public TableColumn colAttend;
    public TableColumn colDate;
    public ImageView btnExitAttend;
    public JFXButton btnEADelete;
    public JFXButton btnEAUpdate;
    public JFXTextField txtSearchEAttend;
    public TableView tblEmpAttend;

    public void initialize(){

        colAttendId.setCellValueFactory(new PropertyValueFactory("AID"));
        colEid.setCellValueFactory(new PropertyValueFactory("EID"));
        colWorkingHourese.setCellValueFactory(new PropertyValueFactory("workingHourse"));
        colAttend.setCellValueFactory(new PropertyValueFactory("attendance"));
        colDate.setCellValueFactory(new PropertyValueFactory("date"));


        loadAllEmployee();
    }

    private void loadAllEmployee() {
        try {
            tblEmpAttend.getItems().clear();
            Attendance attendance = new Attendance();
            ArrayList<AttendeDto> all = attendance.getAll();
            for (AttendeDto dto:all) {
                tblEmpAttend.getItems().add(
                        new AttendeDto(
                                dto.getEID(),
                                dto.getAID(),
                                dto.getAttendance(),
                                dto.getWorkingHourse(),
                                dto.getDate()
                        )
                );
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void btnEDoneOnAction(ActionEvent event) {

        String empId = txtEID.getText();
        String empAttend = txtEAID.getText();
        String date = String.valueOf(txtDate.getValue());
        String attend = txtAttend.getText();
        String time = txtTime.getText();

        Attendance attendance = new Attendance();
//        try {
//            boolean add = attendance.add(new AttendeDto(empId, empAttend, date, attend , time));
//            if (add){
//                new Alert(Alert.AlertType.CONFIRMATION, "Save Employee !").show();
//            }else {
//                new Alert(Alert.AlertType.CONFIRMATION, "Something wrong !").show();
//            }
//        } catch (SQLException | ClassNotFoundException throwables) {
//            throwables.printStackTrace();
//        }

    }

    public void exitAttendOnClick(MouseEvent event) {
        try {
            Navigation.switchNavigation("EmployeePage_form.fxml", event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnEADeleteOnAction(ActionEvent event) {

    }

    public void btnEAUpdatOnAction(ActionEvent event) {

    }

    public void SerchEAttendOnClick(MouseEvent event) {

    }
}
