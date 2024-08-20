package lk.ijse.Furniture.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.Furniture.dto.CustomerDto;
import lk.ijse.Furniture.dto.EmployeeDto;
import lk.ijse.Furniture.dto.OrderDto;
import lk.ijse.Furniture.dto.PaymentDto;
import lk.ijse.Furniture.model.Employee;
import lk.ijse.Furniture.model.Order;
import lk.ijse.Furniture.model.Payment;
import lk.ijse.Furniture.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class PaymentUpdateFormController {

    private static PaymentUpdateFormController controller;
    public JFXTextField txtCash;
    public JFXTextField txtBalance;
    public JFXTextField txtPID;
    public JFXTextField txtTime;
    public JFXTextField txtOrderDate;
    public JFXButton btnPaymentUpdate;
    public JFXTextField txtSearch;
    public JFXButton btnPaymentDelete;

    private static PaymentDto dto;
    public DatePicker txtPayDate;

    public PaymentUpdateFormController() {
        controller = this;
    }

    public static PaymentUpdateFormController getInstance() {
        return controller;
    }

    public static void setObject(PaymentDto dto) {
        PaymentUpdateFormController.dto = dto;
    }

    public void btnODeleteOnAction(ActionEvent event) {
        String paymentId = txtPID.getText();

        try {
            boolean add = Payment.delete(paymentId);
            if (add){
                new Alert(Alert.AlertType.CONFIRMATION, "Delete Payment !").show();
            }else {
                new Alert(Alert.AlertType.CONFIRMATION, "Something wrong !").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void btnOUpdateOnAction(ActionEvent event) {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setCash(txtCash.getText());
        paymentDto.setBalance(txtBalance.getText());
        paymentDto.setPID(txtPID.getText());
        paymentDto.setTime(txtTime.getText());
        paymentDto.setOrderDate(txtOrderDate.getText());

        try {
            boolean update = Payment.update(paymentDto);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void SerchOrderOnMouseClick(MouseEvent event) {

        String PId = txtSearch.getText();

        Payment payment = new Payment();
        try {
            PaymentDto search = payment.search(PId);

            if (search != null) {
                txtPID.setText(search.getPID());
                txtCash.setText(search.getCash());
                txtBalance.setText(search.getBalance());
                txtTime.setText(search.getTime());
                txtOrderDate.setText(search.getOrderDate());
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    public void backPayOnMouseClick(MouseEvent event) {
        try {
            Navigation.switchNavigation("PaymentPageForm.fxml", event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
