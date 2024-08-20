package lk.ijse.Furniture.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import lk.ijse.Furniture.dto.DeliveryDto;
import lk.ijse.Furniture.model.Delivery;
import lk.ijse.Furniture.model.Payment;
import lk.ijse.Furniture.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;


public class DelivaryAddFormController {

    public JFXTextField txtEmpId;
    public JFXTextField txtTime;
    public JFXTextField txtDate;
    public JFXTextField txtDid;

    public void btnDoneOnAction(ActionEvent event) {
        String did = txtDid.getText();
        String empId = txtEmpId.getText();
        String time = txtTime.getText();
        String date = txtDate.getText();

        Delivery delivery = new Delivery();
        try {
            boolean add = delivery.add(new DeliveryDto(did, empId, time, date));
            if (add){
                new Alert(Alert.AlertType.CONFIRMATION, "Save Delivery !").show();
            }else {
                new Alert(Alert.AlertType.CONFIRMATION, "Something  wrong!").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }



    public void exitDelivaryOnMouseClick(MouseEvent event) {
        try {
            Navigation.switchNavigation("DelivaryPage_form.fxml", event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
