package lk.ijse.Furniture.controller;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lk.ijse.Furniture.dto.Admin;
import lk.ijse.Furniture.model.AdminModel;
import lk.ijse.Furniture.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {
    
    public TextField userName;
    public TextField password;
    public AnchorPane root;


    @FXML
    public void loginBtnOnAction(ActionEvent actionEvent) throws IOException {
        String name = userName.getText();
        String pass = password.getText();
if (name!=null && pass!=null){
    try {
        Admin check = AdminModel.check(name, pass);
        if (check!=null){
            Navigation.switchNavigation("HomePage_form.fxml",actionEvent);
        }
    } catch (SQLException | ClassNotFoundException throwables) {
        throwables.printStackTrace();
    }
}else {
    new Alert(Alert.AlertType.CONFIRMATION, "Enter User Name And Password !").show();
}















}
}