package lk.ijse.Furniture.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.Furniture.dto.CustomerDto;
import lk.ijse.Furniture.dto.EmployeeDto;
import lk.ijse.Furniture.model.Customer;
import lk.ijse.Furniture.model.Employee;
import lk.ijse.Furniture.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerUpdateFormController   {

    private static CustomerUpdateFormController controller;
    public JFXTextField txtCID;
    public JFXTextField txtFName;
    public JFXTextField txtLName;
    public JFXTextField txtLane;
    public JFXTextField txtStreet;
    public JFXTextField txtCity;
    public JFXTextField txtNic;
    public JFXTextField txtNo;
    public JFXTextField txtSearchId;

    private static CustomerDto dto;
    public CustomerUpdateFormController() {
        controller = this;
    }

    public static CustomerUpdateFormController getInstance() {
        return controller;
    }

    public static void setObject(CustomerDto dto) {
        CustomerUpdateFormController.dto = dto;
    }

    public void btnDeleteOnAction(ActionEvent event) {
        String cusId = txtCID.getText();

        Customer customer = new Customer();
        try {
            boolean add = customer.delete(cusId);
            if (add){
                new Alert(Alert.AlertType.CONFIRMATION, "Delete Customer !").show();
            }else {
                new Alert(Alert.AlertType.ERROR, "Something Wrong !").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void backOnMouseClick(MouseEvent event) {
        try {
            Navigation.switchNavigation("CustomerPage_form.fxml",event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnUpdateOnAction(ActionEvent event) {
        String cusId = txtCID.getText();
        String fName = txtFName.getText();
        String lName = txtLName.getText();
        String lane = txtLane.getText();
        String street = txtStreet.getText();
        String city = txtCity.getText();
        String nic = txtNic.getText();
        String mNo = txtNo.getText();

        Customer customer = new Customer();
        try {
            boolean update = customer.update(new CustomerDto(cusId, fName, lName, lane , street ,city ,nic , mNo ));
            if (update){
                System.out.println("Save");
            }else {
                System.out.println("not Save");
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void SerchCusOnKeyPressed(KeyEvent keyEvent) {
        String empId = txtSearchId.getText();

        Customer customer = new Customer();
        try {
            CustomerDto search = customer.search(empId);

            if (search != null) {
                txtCID.setText(search.getCID());
                txtFName.setText(search.getFistName());
                txtLName.setText(search.getLastName());
                txtCity.setText(search.getCity());
                txtLane.setText(search.getLane());
                txtStreet.setText(search.getStreet());
                txtNic.setText(search.getNIC());
                txtNo.setText(search.getMobileNumber());
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}



