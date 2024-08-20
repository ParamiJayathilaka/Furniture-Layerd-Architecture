package lk.ijse.Furniture.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.Furniture.db.DBConnection;
import lk.ijse.Furniture.util.Navigation;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;

public class ReportFormController {

    public JFXButton btnCusReport;

    public void btnCustomerReport(ActionEvent event) {
        try {



            JasperReport jasperReport = JasperCompileManager.compileReport("E:/FurnitureShop/src/main/resources/report/customerReport.jrxml");
            JRDataSource jrDataSource = new JRBeanCollectionDataSource(Arrays.asList(new Object()));

            HashMap hm = new HashMap();

            Connection connection = DBConnection.getInstance().getConnection();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hm, connection);
            JasperViewer.viewReport(jasperPrint, false);

        } catch (JRException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
}
    }

    public void btnIUpdateOnAction(ActionEvent event) {

    }

    public void btnEmployeeOnAction(ActionEvent event) {
    }

    public void btnSalaryOnAction(ActionEvent event) {
    }

    public void btnCustomerOnAction(ActionEvent event) {
        
    }

    public void btnItemOnAction(ActionEvent event) {
        
    }

    public void btnOrderOnAction(ActionEvent event) {
    }

    public void btnPaymentOnAction(ActionEvent event) {
    }

    public void btnReportOnAction(ActionEvent event) {
    }

    public void backHomeOnMouseClick(MouseEvent event) {
        try {
            Navigation.switchNavigation("HomePage_form.fxml",event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnCusReportOnAction(ActionEvent event) {

    }
}
