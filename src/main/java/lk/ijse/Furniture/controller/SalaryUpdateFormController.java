package lk.ijse.Furniture.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.Furniture.dto.CustomerDto;
import lk.ijse.Furniture.dto.EmployeeDto;
import lk.ijse.Furniture.dto.SalaryDto;
import lk.ijse.Furniture.model.Customer;
import lk.ijse.Furniture.model.Employee;
import lk.ijse.Furniture.model.Payment;
import lk.ijse.Furniture.model.Salary;

import java.sql.SQLException;

public class SalaryUpdateFormController {

    private static SalaryUpdateFormController controller;
    public JFXTextField txtSID;
    public JFXTextField txtEID;
    public JFXTextField txtBasic;
    public JFXTextField txtBonus;
    public JFXButton btnSalaUpdate;
    public JFXTextField txtSearchSalary;
    public JFXButton btnSalaDelete;

    private static SalaryDto dto;

    public SalaryUpdateFormController() {
        controller = this;
    }

    public static SalaryUpdateFormController getInstance() {
        return controller;
    }

    public static void setObject(SalaryDto dto) {
        SalaryUpdateFormController.dto = dto;
    }

    public void btnSDeleteOnAction(ActionEvent event) {
        String salaryId = txtSID.getText();
        Salary salary = new Salary();

        try {
            boolean delete = salary.delete(salaryId);
            if (delete){
                new Alert(Alert.AlertType.CONFIRMATION, "Delete Salary !").show();
            }else {
                new Alert(Alert.AlertType.CONFIRMATION, "Something wrong !").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnSUpdateOnAction(ActionEvent event) {

        String SID = txtSID.getText();
        String EID = txtEID.getText();
        String Basic = txtBasic.getText();
        String Bonus = txtBonus.getText();


        Salary salary = new Salary();
        try {
            boolean update = salary.update(new SalaryDto(SID, EID, Basic, Bonus));
            if (update){
                new Alert(Alert.AlertType.CONFIRMATION, "Salary Update !").show();
            }else {
                new Alert(Alert.AlertType.CONFIRMATION, "Something wrong !").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }



    }

    public void backSalaryOnMouseClick(MouseEvent event) {
    }

    public void searchSalaryOnClick(KeyEvent keyEvent) {
        String SId = txtSearchSalary.getText();
        Salary salary = new Salary();
        try {
            SalaryDto search = salary.search(SId);

            if (search != null) {
                txtEID.setText(search.getEID());
                txtSID.setText(search.getSID());
                txtBasic.setText(search.getBasic());
                txtBonus.setText(search.getBonus());
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
