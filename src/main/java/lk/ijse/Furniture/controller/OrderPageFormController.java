package lk.ijse.Furniture.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.Furniture.Tm.CustomerTm;
import lk.ijse.Furniture.Tm.OrderTm;
import lk.ijse.Furniture.dto.EmployeeDto;
import lk.ijse.Furniture.dto.OrderDto;
import lk.ijse.Furniture.model.Customer;
import lk.ijse.Furniture.model.Order;
import lk.ijse.Furniture.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderPageFormController {

    private static OrderDto dto;
    public TableColumn colORDERID;
    public TableColumn colCusid;
    public TableColumn colDriID;
    public TableColumn colPayId;
    public TableColumn colOrderDate;
    public TableColumn colUnitPrice;
    public TableColumn colQTY;
    public JFXTextField txtSerchOrder;
    public TableView tblOrder;
    public JFXButton btnModify;
    public JFXButton btnODetails;

    public void initialize(){

        colORDERID.setCellValueFactory(new PropertyValueFactory("OID"));
        colCusid.setCellValueFactory(new PropertyValueFactory("CID"));
        colDriID.setCellValueFactory(new PropertyValueFactory("DID"));
        colPayId.setCellValueFactory(new PropertyValueFactory("PID"));
        colOrderDate.setCellValueFactory(new PropertyValueFactory("orderDate"));
        //colUnitPrice.setCellValueFactory(new PropertyValueFactory("unitPrice"));
        //colQTY.setCellValueFactory(new PropertyValueFactory("qty"));

        loadAllOrder();
    }

    public void loadAllOrder() {
        try {
            tblOrder.getItems().clear();
            Order order = new Order();
            ArrayList<OrderTm> all = order.getAll();
            for (OrderTm dto:all) {
                tblOrder.getItems().add(
                        new OrderTm(
                                dto.getOID(),
                                dto.getCID(),
                                dto.getDID(),
                                dto.getPID(),
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

    public void btnPaymentOnAction(ActionEvent event) {
        try {
            Navigation.switchNavigation("PaymentPageForm.fxml",event);
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


    public void backHomeOnAction(MouseEvent event) {
        try {
            Navigation.switchNavigation("HomePage_form.fxml",event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnOrderModifyOnAction(ActionEvent event) {
        try {
            Navigation.popupNavigation("OrderUpdateForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnOrderAddOnAction(ActionEvent event) {
        try {
            Navigation.popupNavigation("OrderAddForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serchOrderOnClick(MouseEvent event) {
    }

    public void orderDetailOnAction(ActionEvent event) {
        try {
            Navigation.popupNavigation("OrderDetailsForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
