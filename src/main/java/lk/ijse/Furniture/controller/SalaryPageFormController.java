package lk.ijse.Furniture.controller;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.Furniture.Tm.SalaryTm;
import lk.ijse.Furniture.dto.EmployeeDto;
import lk.ijse.Furniture.dto.SalaryDto;
import lk.ijse.Furniture.model.Employee;
import lk.ijse.Furniture.model.Salary;
import lk.ijse.Furniture.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalaryPageFormController {
    private static SalaryDto dto;
    public TableColumn colSID;
    public TableColumn colEID;
    public TableColumn colBasic;
    public TableColumn colBonus;
    public TableView tblSalary;
    ObservableList<SalaryDto>list= FXCollections.observableArrayList();

    public void initialize(){

        colSID.setCellValueFactory(new PropertyValueFactory("SID"));
        colEID.setCellValueFactory(new PropertyValueFactory("EID"));
        colBasic.setCellValueFactory(new PropertyValueFactory("Basic"));
        colBonus.setCellValueFactory(new PropertyValueFactory("Bonus"));
       

        loadAllSalary();
        loadIds();
    }

    private void loadIds() {
        try {
            ArrayList <String> id=Salary.getAllIds();
            for (int i = 0; i < id.size(); i++) {
               loadData(id.get(i));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private void loadData(String id) {
        try {
            SalaryDto dto=Salary.get(id);
            list.add(dto);

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }



    public void loadAllSalary() {
        try {
            tblSalary.getItems().clear();
            Salary salary = new Salary();
            ArrayList<SalaryTm> all = salary.getAll();
            for (SalaryTm dto:all) {
                tblSalary.getItems().add(
                        new SalaryDto(
                                dto.getSID(),
                                dto.getEID(),
                                dto.getBasic(),
                                dto.getBonus()
                                
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

    public void btnDelivartOnAction(ActionEvent event) {
        try {
            Navigation.switchNavigation("DelivaryPageForm.fxml",event);
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

    public void btnSalaryAddOnAction(ActionEvent event) {
        try {
            Navigation.popupNavigation("SalaryAddForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnSalaryModifyOnAction(ActionEvent event) {
        try {
            Navigation.popupNavigation("SalaryUpdateForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ancpOnMouseEnteredAction(MouseEvent event) {
        loadAllSalary();
    }
}
