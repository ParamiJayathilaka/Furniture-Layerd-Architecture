package lk.ijse.Furniture.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.Furniture.dto.CustomerDto;
import lk.ijse.Furniture.dto.EmployeeDto;
import lk.ijse.Furniture.dto.ItemDto;
import lk.ijse.Furniture.model.Delivery;
import lk.ijse.Furniture.model.Employee;
import lk.ijse.Furniture.model.Item;
import lk.ijse.Furniture.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;

public class ItemUpdateFormController {


    private static ItemUpdateFormController controller;
    public JFXTextField txtTemName;
    public JFXTextField txtMaterial;
    public JFXTextField txtUnitPrize;
    public JFXTextField txtColour;
    public JFXTextField txtSize;
    public JFXTextField txtIID;
    public JFXTextField txtISerch;


    private static ItemDto dto;
    public JFXTextField txtQty;

    public ItemUpdateFormController() {
        controller = this;
    }

    public static ItemUpdateFormController getInstance() {
        return controller;
    }

    public static void setObject(ItemDto dto) {
        ItemUpdateFormController.dto = dto;
    }

    public void btnIUpdateOnAction(ActionEvent event) {
        ItemDto itemDto = new ItemDto();
        itemDto.setItemName(txtTemName.getText());
        itemDto.setMatirialType(txtMaterial.getText());
        itemDto.setUnitPrize(txtUnitPrize.getText());
        itemDto.setColor(txtColour.getText());
        itemDto.setSize(txtSize.getText());
        itemDto.setIID(txtIID.getText());
        itemDto.setQtyOnHand(txtQty.getText());

        try {
            boolean update = Item.update(itemDto);
            if (update){
                new Alert(Alert.AlertType.CONFIRMATION, "Update Item !").show();
            }else {
                new Alert(Alert.AlertType.ERROR, "Something wrong !").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void btnIDeleteOnAction(ActionEvent event) {
        String itemId = txtIID.getText();

        Item item = new Item();
        try {
            boolean add = item.delete(itemId);
            if (add){
                new Alert(Alert.AlertType.CONFIRMATION, "Delete Item !").show();
            }else {
                new Alert(Alert.AlertType.CONFIRMATION, "Something wrong !").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void serchItemOnClick(KeyEvent keyEvent) {

        String IId = txtISerch.getText();
        Item item = new Item();
        try {
            ItemDto search = item.search(IId);

            if (search != null) {
                txtTemName.setText(search.getItemName());
                txtMaterial.setText(search.getMatirialType());
                txtUnitPrize.setText(search.getUnitPrize());
                txtColour.setText(search.getColor());
                txtSize.setText(search.getSize());
                txtIID.setText(search.getIID());

            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void backOnMouseClick(MouseEvent event) {
        try {
            Navigation.switchNavigation("ItemPage_form.fxml", event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
