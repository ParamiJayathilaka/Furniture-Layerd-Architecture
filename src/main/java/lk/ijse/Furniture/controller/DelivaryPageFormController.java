package lk.ijse.Furniture.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.Furniture.dto.DeliveryDto;
import lk.ijse.Furniture.dto.EmployeeDto;
import lk.ijse.Furniture.model.Delivery;
import lk.ijse.Furniture.model.Employee;
import lk.ijse.Furniture.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DelivaryPageFormController {

    private static DeliveryDto dto;

    public JFXButton btnDAdd;
    public JFXButton btnDModify;
    public TableColumn colDID;
    public TableColumn colEID;
    public TableColumn colTime;
    public TableColumn colDate;
    public TableView tblDeliveryForm;

    public void initialize(){

        colDID.setCellValueFactory(new PropertyValueFactory("DID"));
        colEID.setCellValueFactory(new PropertyValueFactory("EID"));
        colTime.setCellValueFactory(new PropertyValueFactory("time"));
        colDate.setCellValueFactory(new PropertyValueFactory("date"));

        loadAllDelivary();
    }

    private void loadAllDelivary() {
        try {
            tblDeliveryForm.getItems().clear();
            Delivery delivery = new Delivery();
            ArrayList<DeliveryDto> all = delivery.getAll();
            for (DeliveryDto dto:all) {
                tblDeliveryForm.getItems().add(
                        new DeliveryDto(
                                dto.getDID(),
                                dto.getEID(),
                                dto.getTime(),
                                dto.getDate()
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

    public void btnEmployeeOnAction(ActionEvent event) {
        try {
            Navigation.switchNavigation("EmployeePage_form.fxml",event);
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

    public void btnPaymentOnAction(ActionEvent event) {
        try {
            Navigation.switchNavigation("PaymentPageForm.fxml",event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnDelevaryAddOnAction(ActionEvent event) {
        try {
            Navigation.popupNavigation("DeliveryAddForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnModifyOnAction(ActionEvent event) {
        try {
            Navigation.popupNavigation("DelivaryUpdateForm.fxml");
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

    public void btnAddOnAction(ActionEvent event)  {
        try {
            Navigation.popupNavigation("DeliveryAddForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void btnReportOnAction(ActionEvent event) {
        try {
            Navigation.switchNavigation("ReportFrom.fxml",event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
