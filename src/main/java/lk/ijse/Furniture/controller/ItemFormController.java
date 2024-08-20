package lk.ijse.Furniture.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.Furniture.dto.EmployeeDto;
import lk.ijse.Furniture.dto.ItemDto;
import lk.ijse.Furniture.model.Employee;
import lk.ijse.Furniture.model.Item;
import lk.ijse.Furniture.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemFormController {

    private static ItemDto dto;


    public TableColumn colItemId;
    public TableColumn colItemName;
    public TableColumn colMaterialType;
    public TableColumn colSize;
    public TableColumn colColour;
    public TableColumn colUnitPrize;
    public TableColumn colQTY;
    public JFXTextField txtSearchItem;
    public JFXButton btnAdd;
    public JFXButton btnModify;
    public TableView tblItem;

    public void initialize(){

        colItemId.setCellValueFactory(new PropertyValueFactory("IID"));
        colItemName.setCellValueFactory(new PropertyValueFactory("ItemName"));
        colMaterialType.setCellValueFactory(new PropertyValueFactory("MatirialType"));
        colSize.setCellValueFactory(new PropertyValueFactory("Size"));
        colColour.setCellValueFactory(new PropertyValueFactory("color"));
        colUnitPrize.setCellValueFactory(new PropertyValueFactory("UnitPrize"));
        colQTY.setCellValueFactory(new PropertyValueFactory("QtyOnHand"));


        loadAllItem();
    }

    private void loadAllItem() {
        try {
            tblItem.getItems().clear();
            Item item = new Item();
            ArrayList<ItemDto> all = item.getAll();
            for (ItemDto dto:all) {
                tblItem.getItems().add(
                        new ItemDto(
                                dto.getIID(),
                                dto.getItemName(),
                                dto.getMatirialType(),
                                dto.getSize(),
                                dto.getColor(),
                                dto.getUnitPrize(),
                                dto.getQtyOnHand()

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


    public void btnOrderOnAction(ActionEvent event) {

        try {
            Navigation.switchNavigation("OrderPageForm,fxml",event);
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
            Navigation.switchNavigation("DeliveryPage.fxml",event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void btnIUpdateOnAction(ActionEvent event) {
        try {
            Navigation.popupNavigation("ItemUpdateForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnAddItemOnAction(ActionEvent event) {
        try {
            Navigation.popupNavigation("ItemAddForm.fxml");
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

    public void serchItemOnClick(MouseEvent event) {

    }


    public void orderOnMouseCilck(MouseEvent event) {

    }
}
