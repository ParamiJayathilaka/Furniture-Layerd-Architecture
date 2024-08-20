package lk.ijse.Furniture.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.Furniture.dto.CustomerDto;
import lk.ijse.Furniture.dto.DeliveryDto;
import lk.ijse.Furniture.dto.EmployeeDto;
import lk.ijse.Furniture.model.Customer;
import lk.ijse.Furniture.model.Delivery;
import lk.ijse.Furniture.model.Employee;
import lk.ijse.Furniture.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.net.URL;
import java.util.ResourceBundle;

public class DelivaryUpdateFormController implements Initializable {

    private static DelivaryUpdateFormController controller;
    public JFXTextField txtTime;
    public JFXTextField txtEid;
    public JFXTextField txtDid;
    public JFXTextField txtDate;
    public JFXButton btnDDelete;
    public JFXButton btnDUpdate;
    public JFXTextField txtDSerch;

    private static DeliveryDto dto;

    public DelivaryUpdateFormController() {
        controller = this;
    }

    public static DelivaryUpdateFormController getInstance() {
        return controller;
    }

    public static void setObject(DeliveryDto dto) {
        DelivaryUpdateFormController.dto = dto;
    }

    public void btnDUpdateOnAction(ActionEvent event) {
        String did = txtDid.getText();
        String empId = txtEid.getText();
        String time = txtTime.getText();
        String date = txtDate.getText();

        Delivery delivery = new Delivery();
//        try {
////            boolean update = employee.update(new EmployeeDto(empId, fName, lName, lane , street ,city ,nic , mNo));
////            if (update){
////                new Alert(Alert.AlertType.CONFIRMATION, "Update Employee !").show();
////            }else {
////                new Alert(Alert.AlertType.CONFIRMATION, "Something wrong !").show();
////            }
//        } catch (SQLException | ClassNotFoundException throwables) {
//            throwables.printStackTrace();
//        }

        DeliveryDto deliveryDto = new DeliveryDto();
        deliveryDto.setDID(txtDid.getText());
        deliveryDto.setEID(txtEid.getText());
        deliveryDto.setTime(txtTime.getText());
        deliveryDto.setDate(txtDate.getText());

        try {
            boolean update = Delivery.update(deliveryDto);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }


    }

    public void btnDDeleteOnAction(ActionEvent event) {

        String did = txtDid.getText();

        Delivery delivery = new Delivery();
        try {
            boolean delete = delivery.delete(did);
            if (delete){
                new Alert(Alert.AlertType.CONFIRMATION, "Delete Delivery !").show();
            }else {
                new Alert(Alert.AlertType.ERROR, "Something Wrong !").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void SerchDelivaryOnKeyPressed(KeyEvent keyEvent) {
        String did = txtDSerch.getText();

        Delivery delivery = new Delivery();
        try {
            DeliveryDto  search = delivery.search(did);

            if (search != null) {
                txtDid.setText(search.getEID());
                txtEid.setText(search.getEID());
                txtTime.setText(search.getTime());
                txtDate.setText(search.getDate());

            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void backPageOnClicked(MouseEvent event) {
        try {
            Navigation.switchNavigation("DelivaryPage_form.fxml",event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtDid.setText(dto.getDID());
        txtEid.setText(dto.getDID());
        txtTime.setText(dto.getTime());
        txtDate.setText(dto.getDate());


    }
}
