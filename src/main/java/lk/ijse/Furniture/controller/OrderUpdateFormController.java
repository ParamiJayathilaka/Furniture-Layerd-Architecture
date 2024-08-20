package lk.ijse.Furniture.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.Furniture.dto.CustomerDto;
import lk.ijse.Furniture.dto.EmployeeDto;
import lk.ijse.Furniture.dto.OrderDto;
import lk.ijse.Furniture.model.Customer;
import lk.ijse.Furniture.model.Employee;
import lk.ijse.Furniture.model.Item;
import lk.ijse.Furniture.model.Order;
import lk.ijse.Furniture.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;

public class OrderUpdateFormController {

    private static OrderUpdateFormController controller;
    public JFXTextField txtOID;
    public JFXTextField txtCID;
    public JFXTextField txtIID;
    public JFXTextField txtPID;
    public JFXTextField txtDID;
    public JFXTextField txtODate;
    public JFXTextField txtQTY;
    public JFXTextField txtPrice;
    public JFXButton btnOrderDelete;
    public JFXTextField txtSearchOrder;
    public JFXButton btnOrderUpdate;

    private static OrderDto dto;
    public DatePicker txtOrderDate;


    public OrderUpdateFormController() {
        controller = this;
    }

    public static OrderUpdateFormController getInstance() {
        return controller;
    }

    public static void setObject(OrderDto dto) {
        OrderUpdateFormController.dto = dto;
    }

    public void btnODeleteOnAction(ActionEvent event) {
        String itemId = txtIID.getText();

        Order order = new Order();
        try {
            boolean add = order.delete(itemId);
            if (add){
                new Alert(Alert.AlertType.CONFIRMATION, "Delete Employee !").show();
            }else {
                new Alert(Alert.AlertType.CONFIRMATION, "Something wrong !").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void btnOUpdateOnAction(ActionEvent event) {

        String cusId = txtCID.getText();
        String orderId = txtOID.getText();
        String itemId = txtIID.getText();
        String payId = txtPID.getText();
        String dilId = txtDID.getText();
        String orderDate = txtODate.getText();
        String qty = txtQTY.getText();
        String price = txtPrice.getText();

        Customer customer = new Customer();
        try {
            boolean update = customer.update(new CustomerDto(cusId, orderId, itemId, payId , dilId ,orderDate ,qty , price ));
            if (update){
                System.out.println("Save");
            }else {
                System.out.println("not Save");
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

//        OrderDto orderDto = new OrderDto();
//        orderDto.setOID(txtOID.getText());
//        orderDto.setCID(txtCID.getText());
//        orderDto.setIID(txtIID.getText());
//        orderDto.setPID(txtPID.getText());
//        orderDto.setDID(txtDID.getText());
//        orderDto.setOrderDate(txtODate.getText());
//        orderDto.setQTY(txtQTY.getText());
//        orderDto.setPrice(txtPrice.getText());
//        try {
//            boolean update = Order.update(orderDto);
//        } catch (SQLException | ClassNotFoundException throwables) {
//            throwables.printStackTrace();
//        }

    }

    public void SerchOrderOnClick(MouseEvent event) {
        String OId = txtSearchOrder.getText();

        Order order = new Order();
        try {
            OrderDto search = order.search(OId);

            if (search != null) {
                txtOID.setText(search.getOID());
                txtCID.setText(search.getCID());
                txtIID.setText(search.getIID());
                txtPID.setText(search.getPID());
                txtDID.setText(search.getDID());
                txtODate.setText(search.getOrderDate());
                txtQTY.setText(search.getQTY());
                txtPrice.setText(search.getPrice());
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void backOrderOnClick(MouseEvent event) {
        try {
            Navigation.switchNavigation("OrderPageForm.fxml", event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
