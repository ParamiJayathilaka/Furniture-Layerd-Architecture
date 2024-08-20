package lk.ijse.Furniture.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.Furniture.Tm.CustomerTm;
import lk.ijse.Furniture.dto.CustomerDto;
import lk.ijse.Furniture.dto.EmployeeDto;
import lk.ijse.Furniture.model.Customer;
import lk.ijse.Furniture.model.Employee;
import lk.ijse.Furniture.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerFormController {

    private static CustomerDto dto;

    public TableView tblCustomer;
    public TableColumn colCFirstName;
    public TableColumn colCLName;
    public TableColumn colCStreet;
    public TableColumn colCLane;
    public TableColumn colCCity;
    public TableColumn colCNic;
    public TableColumn colCMobileNumber;
    public TableColumn colCCID;
    public JFXTextField txtSearchCus;

    public void initialize(){

        colCCID.setCellValueFactory(new PropertyValueFactory("CID"));
        colCFirstName.setCellValueFactory(new PropertyValueFactory("fistName"));
        colCLName.setCellValueFactory(new PropertyValueFactory("lastName"));
        colCStreet.setCellValueFactory(new PropertyValueFactory("street"));
        colCLane.setCellValueFactory(new PropertyValueFactory("lane"));
        colCCity.setCellValueFactory(new PropertyValueFactory("city"));
        colCNic.setCellValueFactory(new PropertyValueFactory("NIC"));
        colCMobileNumber.setCellValueFactory(new PropertyValueFactory("MobileNumber"));

        loadAllCustomer();
    }

    public void loadAllCustomer() {
        try {
            tblCustomer.getItems().clear();
            Customer customer = new Customer();
            ArrayList<CustomerTm> all = customer.getAll();
            for (CustomerTm dto:all) {
                tblCustomer.getItems().add(
                        new CustomerTm(
                                dto.getCID(),
                                dto.getFistName(),
                                dto.getLastName(),
                                dto.getStreet(),
                                dto.getCity(),
                                dto.getLane(),
                                dto.getMobileNumber(),
                                dto.getNIC()
                        )
                );
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }


    public void btnSalaryOnAction(ActionEvent event) {
        try {
            Navigation.switchNavigation("SalaryPageForm.fxml",event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnEmployeeOnAction(ActionEvent event) {
        try {
            Navigation.switchNavigation("EmployeePage_form.fxml",event);
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

    public void btnDelivaryOnAction(ActionEvent event) {
        try {
            Navigation.switchNavigation("DeliveryPageForm.fxml",event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void backHomeOnMouseClick(MouseEvent event) {
        try {
            Navigation.switchNavigation("HomePage_form.fxml",event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnAddOnAction(ActionEvent event) {
        try {
            Navigation.popupNavigation("CustomerAddForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void OnMouseCilck(MouseEvent event) {

        dto= (CustomerDto) tblCustomer.getSelectionModel().getSelectedItem();
    }

    public void btnModifyOnAction(ActionEvent event) {
        try {
            //CustomerUpdateFormController.setObject(dto);
            Navigation.popupNavigation("CustomerUpdateForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SerchOnCusKeyPressed(MouseEvent event) {

    }
}
