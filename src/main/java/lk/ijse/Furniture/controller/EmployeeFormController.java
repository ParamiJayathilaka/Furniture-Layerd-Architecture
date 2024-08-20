package lk.ijse.Furniture.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.Furniture.Tm.EmployeeTm;
import lk.ijse.Furniture.dto.EmployeeDto;
import lk.ijse.Furniture.model.Employee;
import lk.ijse.Furniture.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeFormController {

    private static EmployeeDto dto;

    public TableColumn colEID;
    public TableColumn colFirstName;
    public TableColumn colLName;
    public TableColumn colStreet;
    public TableColumn colLane;
    public TableColumn colCity;
    public TableColumn colNic;
    public TableColumn colMobileNumber;
    public TableView tblEmployee;


    public void initialize(){

        colEID.setCellValueFactory(new PropertyValueFactory("EID"));
        colFirstName.setCellValueFactory(new PropertyValueFactory("fistName"));
        colLName.setCellValueFactory(new PropertyValueFactory("lastName"));
        colStreet.setCellValueFactory(new PropertyValueFactory("street"));
        colLane.setCellValueFactory(new PropertyValueFactory("lane"));
        colCity.setCellValueFactory(new PropertyValueFactory("city"));
        colNic.setCellValueFactory(new PropertyValueFactory("Nic"));
        colMobileNumber.setCellValueFactory(new PropertyValueFactory("contact"));

        loadAllEmployee();
    }

    private void loadAllEmployee() {
        try {
            tblEmployee.getItems().clear();
            Employee employee = new Employee();
            ArrayList<EmployeeDto> all = employee.getAll();
            for (EmployeeDto dto:all) {
                tblEmployee.getItems().add(
                       new EmployeeDto(
                               dto.getEID(),
                               dto.getFistName(),
                               dto.getLastName(),
                               dto.getStreet(),
                               dto.getCity(),
                               dto.getLane(),
                               dto.getNic(),
                               dto.getContact()
                       )
                );
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void btnCusOnAction(ActionEvent event) {
        try {
            Navigation.switchNavigation("CustomerPage_form.fxml",event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnItemOnAction(ActionEvent event) {
        try {
            Navigation.switchNavigation("ItemPage_form.fxml",event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnOrderOnAction(ActionEvent event) {
        try {
            Navigation.switchNavigation("OrderPageForm.fxml",event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnPaymentOnAction(ActionEvent event) {
        try {
            Navigation.switchNavigation("PaymentPageForm.fxml",event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnSalaryOnAction(ActionEvent event) {
        try {
            Navigation.switchNavigation("SalaryPageForm.fxml",event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnDelivaryOnAction(ActionEvent event) {
        try {
            Navigation.switchNavigation("DeliveryPageForm.fxml",event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void btnCustomerOnAction(ActionEvent event) {
        try {
            Navigation.switchNavigation("CustomerPage_form.fxml",event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnEmployeeAddOnAction(ActionEvent event) {
        try {
            Navigation.popupNavigation("EmployeeAddForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnEModifyOnAction(ActionEvent event) {

        try {
            EmployeeUpdateFormController.setObject(dto);
            Navigation.popupNavigation("EmployeeUpdateForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnEAttenOnAction(ActionEvent event) {
        try {
            Navigation.popupNavigation("EmployeeAttendanceForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnAddOnAction(ActionEvent event) {
        try {
            Navigation.popupNavigation("EmployeeAddForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void OnMouseCilck(MouseEvent event) {
        dto= (EmployeeDto) tblEmployee.getSelectionModel().getSelectedItem();

    }
}
