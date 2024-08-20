package lk.ijse.Furniture.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.Furniture.dto.DeliveryDto;
import lk.ijse.Furniture.dto.ItemDto;
import lk.ijse.Furniture.model.Employee;
import lk.ijse.Furniture.model.Item;
import lk.ijse.Furniture.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;

public class ItemAddFormController {

    public JFXTextField txtItemName;
    public JFXTextField txtMaterial;
    public JFXTextField txtUnitPrize;
    public JFXTextField txtColour;
    public JFXTextField txtSize;
    public JFXTextField txtIID;
    public JFXTextField txtQtyAdd;

    public void btnEDoneOnAction(ActionEvent event) {
        String itemId = txtIID.getText();
        String itemName = txtItemName.getText();
        String matiril = txtMaterial.getText();
        String price = txtUnitPrize.getText();
        String colour = txtColour.getText();
        String size = txtSize.getText();
        String qty = txtQtyAdd.getText();


        Item item = new Item();
        try {
            boolean add = item.add(new ItemDto(itemId,itemName, matiril,size, colour,price,qty ));
            if (add){
                System.out.println("Save");
            }else {
                System.out.println("not Save");
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void exitItemOnClock(MouseEvent event) {
        try {
            Navigation.switchNavigation("ItemPage_form.fxml", event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
