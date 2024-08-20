package lk.ijse.Furniture.controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.Furniture.dto.ItemDto;
import lk.ijse.Furniture.dto.OrderDto;
import lk.ijse.Furniture.model.Item;
import lk.ijse.Furniture.model.Order;
import lk.ijse.Furniture.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class OrderAddFormController {
    @FXML
    private AnchorPane ancpOrderDetail;


    public JFXTextField txtOID;
    public JFXTextField txtCID;
    public JFXTextField txtIID;
    public JFXTextField txtPID;
    public JFXTextField txtDID;
    public JFXTextField txtQTY;
    public JFXTextField txtPrize;
    public DatePicker txtDate;

    private String dateToday(){
    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
    return format.format(new Date());
}
    public void btnODoneOnAction(ActionEvent event) {
        String orderid = txtOID.getText();
        String cusId = txtCID.getText();
        String itemId = txtIID.getText();
        String paymentId = txtPID.getText();
        String deliverId = txtDID.getText();
        String OrderDate = dateToday();
        String qty = txtQTY.getText();
        String price = txtPrize.getText();

        Order order = new Order();
        try {
            boolean add = order.add(new OrderDto(orderid, cusId,deliverId,paymentId,qty,OrderDate));
            if (add){
                System.out.println("Save");
                OrderPageFormController o1 = new OrderPageFormController();
//                o1.loadAllOrder();
            }else {
                System.out.println("not Save");
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void exitOrderOnAction(MouseEvent event) throws IOException {

           // Navigation.switchNavigation("OrderPageForm.fxml", event);
        Parent parent =  FXMLLoader.load(getClass().getResource("/view/OrderAddForm.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("");
        stage.centerOnScreen();

        stage.close();
    }
}
