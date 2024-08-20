package lk.ijse.Furniture.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lk.ijse.Furniture.dto.CustomerDto;
import lk.ijse.Furniture.dto.ItemDto;
import lk.ijse.Furniture.dto.SalaryDto;
import lk.ijse.Furniture.model.Customer;
import lk.ijse.Furniture.model.Payment;
import lk.ijse.Furniture.model.Salary;
import lk.ijse.Furniture.util.AlertController;
import lk.ijse.Furniture.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;

public class SalaryAddFormController {
    public JFXTextField txtSID;
    public JFXTextField txtEID;
    public JFXTextField txtBasic;
    public JFXTextField txtBonus;
    public ImageView btnSalaryExit;
    public JFXButton btnSalaryDone;

    public void btnSDoneOnAction(ActionEvent event) {
        String salaryId = txtSID.getText();
        String empId = txtEID.getText();
        String basic = txtBasic.getText();
        String bonus = txtBonus.getText();

        Salary salary = new Salary();

        try {
            boolean add = salary.add(new SalaryDto(salaryId, empId,basic,bonus));
            if (add){

                //Navigation.switchNavigation("SalaryPageForm.fxml", event);
                //SalaryPageFormController.tblSalary.refresh();
              //new Alert(Alert.AlertType.CONFIRMATION, "Save Salary !");
                btnSalaryDone.getScene().getWindow().hide();
                AlertController.confirmmessage("Save Salary");

            }else {
                //new Alert(Alert.AlertType.CONFIRMATION, "Something wrong !").show();
                AlertController.errormessage("Something wrong !");
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void exitSalaryOnClick(MouseEvent event) {
        try {
            Navigation.switchNavigation("SalaryPageForm.fxml", event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
