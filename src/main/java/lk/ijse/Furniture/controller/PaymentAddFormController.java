package lk.ijse.Furniture.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.Furniture.dto.ItemDto;
import lk.ijse.Furniture.dto.PaymentDto;
import lk.ijse.Furniture.model.Order;
import lk.ijse.Furniture.model.Payment;
import lk.ijse.Furniture.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;

public class PaymentAddFormController {
    public JFXTextField txtCash;
    public JFXTextField txtBalance;
    public JFXTextField txtPID;
    public JFXTextField txtTime;
    public JFXTextField txtOrderDate;
    public ImageView btnPaymetExit;
    public JFXButton btnPaymentDone;
    public DatePicker txtPayAddDate;

    public void btnPDoneOnAction(ActionEvent event) {
        String paymentId = txtPID.getText();
        String cash = txtCash.getText();
        String balance = txtBalance.getText();
        String time = txtTime.getText();
        String orderdate = txtPayAddDate.getEditor().getText();

        Payment payment = new Payment();
        try {
            boolean add = payment.add(new PaymentDto(paymentId,cash,balance,time,orderdate ));
            if (add){
                new Alert(Alert.AlertType.CONFIRMATION, "Save Payment !").show();
            }else {
                new Alert(Alert.AlertType.CONFIRMATION, "Something wrong !").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void exitPaymentOnClock(MouseEvent event) {
        try {
            Navigation.switchNavigation("PaymentPageForm.fxml", event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
