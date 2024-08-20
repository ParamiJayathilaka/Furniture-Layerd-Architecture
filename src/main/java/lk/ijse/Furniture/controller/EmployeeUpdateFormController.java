package lk.ijse.Furniture.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.Furniture.dto.CustomerDto;
import lk.ijse.Furniture.dto.EmployeeDto;
import lk.ijse.Furniture.model.Delivery;
import lk.ijse.Furniture.model.Employee;
import lk.ijse.Furniture.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EmployeeUpdateFormController  {

    private static EmployeeUpdateFormController controller;
    public JFXTextField txtEID;
    public JFXTextField txtFN;
    public JFXTextField txtLN;
    public JFXTextField txtLane;
    public JFXTextField txtStreet;
    public JFXTextField txtCity;
    public JFXTextField txtNIC;
    public JFXTextField txtNo;
    public JFXButton btn;
    public JFXTextField txtESearch;

    private static EmployeeDto dto;

    public EmployeeUpdateFormController() {
        controller = this;
    }

    public static EmployeeUpdateFormController getInstance() {
        return controller;
    }

    public static void setObject(EmployeeDto dto) {
        EmployeeUpdateFormController.dto = dto;
    }

    public void btnDeleteOnAction(ActionEvent event) {

        String empId = txtEID.getText();

        Employee employee = new Employee();
        try {
            boolean add = employee.delete(empId);
            if (add) {
                new Alert(Alert.AlertType.CONFIRMATION, "Delete Employee !").show();
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "Something wrong !").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void SerchOnKeyPressed(KeyEvent keyEvent) {
        String empId = txtESearch.getText();

        Employee employee = new Employee();
        try {
            EmployeeDto search = employee.search(empId);

            if (search != null) {
                txtEID.setText(search.getEID());
                txtFN.setText(search.getFistName());
                txtLN.setText(search.getLastName());
                txtCity.setText(search.getCity());
                txtLane.setText(search.getLane());
                txtStreet.setText(search.getStreet());
                txtNIC.setText(search.getNic());
                txtNo.setText(search.getContact());
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void btnUpdateOnAction(ActionEvent event) {
        String empId = txtEID.getText();
        String fName = txtFN.getText();
        String lName = txtLN.getText();
        String lane = txtLane.getText();
        String street = txtStreet.getText();
        String city = txtCity.getText();
        String nic = txtNIC.getText();
        String mNo = txtNo.getText();

        Employee employee = new Employee();
        try {
            if (empId.equals(null)){
                new Alert(Alert.AlertType.ERROR, "ID is Empty!").show();
            }else {
                boolean update = employee.update(new EmployeeDto(empId, fName, lName, lane , street ,city ,nic , mNo));
                if (update){
                    new Alert(Alert.AlertType.CONFIRMATION, "Update Employee !").show();

                }else {
                    new Alert(Alert.AlertType.ERROR, "Something wrong !").show();
                }
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setFistName(txtFN.getText());
//                employeeDto.setLastName(txtLN.getText());
//                employeeDto.setCity(txtCity.getText());
//                employeeDto.setContact(txtNo.getText());
//                employeeDto.setEID(txtEID.getText());
//                employeeDto.setLane(txtLane.getText());
//                employeeDto.setNic(txtNIC.getText());
//                employeeDto.setStreet(txtStreet.getText());
//        try {
//            boolean update = Employee.update(employeeDto);
//        } catch (SQLException | ClassNotFoundException throwables) {
//            throwables.printStackTrace();
//        }

    }

    public void backEOnMouseClick(MouseEvent event) {
        try {
            Navigation.switchNavigation("EmployeePage_form.fxml", event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        txtFN.setText(dto.getFistName());
//        txtLane.setText(dto.getLastName());
//        txtEID.setText(dto.getEID());
//        txtCity.setText(dto.getCity());
//        txtLane.setText(dto.getLane());
//        txtStreet.setText(dto.getStreet());
//        txtNIC.setText(dto.getNic());
//        txtNo.setText(dto.getContact());
//
//    }
}
