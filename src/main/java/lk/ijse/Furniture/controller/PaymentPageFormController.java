package lk.ijse.Furniture.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.Furniture.dto.EmployeeDto;
import lk.ijse.Furniture.dto.PaymentDto;
import lk.ijse.Furniture.model.Employee;
import lk.ijse.Furniture.model.Payment;
import lk.ijse.Furniture.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentPageFormController {
    private static PaymentDto dto;

    public TableColumn colPID;
    public TableColumn colCash;
    public TableColumn colBalance;
    public TableColumn colTime;
    public TableColumn colOrderDate;
    public TableView tblPayment;

    public void initialize(){
        loadAllEmployee();
        setTable();

    }

    private void setTable() {
        colPID.setCellValueFactory(new PropertyValueFactory("PID"));
        colCash.setCellValueFactory(new PropertyValueFactory("cash"));
        colBalance.setCellValueFactory(new PropertyValueFactory("balance"));
        colTime.setCellValueFactory(new PropertyValueFactory("time"));
        colOrderDate.setCellValueFactory(new PropertyValueFactory("orderDate"));
    }

    private void loadAllEmployee() {
        try {
            tblPayment.getItems().clear();
            Payment payment = new Payment();
            ArrayList<PaymentDto> all = payment.getAll();
            for (PaymentDto dto:all) {
                tblPayment.getItems().add(
                        new PaymentDto(
                                dto.getPID(),
                                dto.getCash(),
                                dto.getTime(),
                                dto.getBalance(),
                                dto.getOrderDate()


                        )
                );
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void btnCustomerOnAction(ActionEvent event) {
        try {
            Navigation.switchNavigation("CustomerPage_form.fxml",event);
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

    public void btnDelivaryOnAction(ActionEvent event) {
        try {
            Navigation.switchNavigation("DelivaryPageForm.fxml",event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnEmployeetOnAction(ActionEvent event) {
        try {
            Navigation.switchNavigation("EmployeePage_form.fxml",event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void backHomeOnClick(MouseEvent event) {
        try {
            Navigation.switchNavigation("HomePage_form.fxml",event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnPaymentAddOnAction(ActionEvent event) {
        try {
            Navigation.popupNavigation("PaymentAddForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnPaymentModifyOnAction(ActionEvent event) {
        try {
            Navigation.popupNavigation("PaymentUpdateForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
