package lk.ijse.Furniture.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import lk.ijse.Furniture.dto.DeliveryDto;
import lk.ijse.Furniture.dto.EmployeeDto;
import lk.ijse.Furniture.model.Delivery;
import lk.ijse.Furniture.model.Employee;
import lk.ijse.Furniture.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;

public class EmployeeAddFormController {
    public JFXTextField txtFname;
    public JFXTextField txtLName;
    public JFXTextField txtLane;
    public JFXTextField txtStreet;
    public JFXTextField txtCity;
    public JFXTextField txtNic;
    public JFXTextField txtNo;
    public JFXTextField txtEID;
    public JFXButton btnEDone;
    public JFXButton btnEmpExit;

    public void btnEDoneOnAction(ActionEvent event) {


        String empId = txtEID.getText();
        String fName = txtFname.getText();
        String lName = txtLName.getText();
        String lane = txtLane.getText();
        String street = txtStreet.getText();
        String city = txtCity.getText();
        String nic = txtNic.getText();
        String mNo = txtNo.getText();


        Employee employee = new Employee();
        try {
            boolean add = employee.add(new EmployeeDto(empId, fName, lName, lane , street ,city ,nic , mNo));
            if (add){
                new Alert(Alert.AlertType.CONFIRMATION, "Save Employee !").show();
            }else {
                new Alert(Alert.AlertType.CONFIRMATION, "Something wrong !").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }



    }


    public void backEOnMouseClick(MouseEvent event) {
        try {
            Navigation.switchNavigation("EmployeePage_form.fxml", event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
