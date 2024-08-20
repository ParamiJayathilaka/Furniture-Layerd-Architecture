package lk.ijse.Furniture.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.Furniture.dto.CustomerDto;
import lk.ijse.Furniture.dto.DeliveryDto;
import lk.ijse.Furniture.model.Customer;
import lk.ijse.Furniture.model.Delivery;
import lk.ijse.Furniture.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;

public class CustomerAddFormController {

    public JFXTextField txtFName;
    public JFXTextField txtLName;
    public JFXTextField txtLane;
    public JFXTextField txtStreet;
    public JFXTextField txtCity;
    public JFXTextField txtNic;
    public JFXTextField txtNo;
    public JFXTextField txtCID;
    public ImageView btnCusExit;
    public JFXButton btnCusDone;

    public void btnDoneOnAction(ActionEvent event) {
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
            boolean add = customer.add(new CustomerDto(cusId, fName, lName, lane , street ,city ,nic , mNo ));
            if (add){
                CustomerFormController c1 = new CustomerFormController();
                c1.loadAllCustomer();
                new Alert(Alert.AlertType.CONFIRMATION, "Save Customer !").show();
            }else {
                new Alert(Alert.AlertType.CONFIRMATION, "Something wrong !").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }


    }

    public void exitCusOnMouseClick(MouseEvent event) {
        try {
            Navigation.switchNavigation("CustomerPage_form.fxml", event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
