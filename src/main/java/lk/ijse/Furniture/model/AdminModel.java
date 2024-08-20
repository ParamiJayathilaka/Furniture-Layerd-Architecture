package lk.ijse.Furniture.model;

import javafx.scene.control.Alert;
import lk.ijse.Furniture.db.DBConnection;
import lk.ijse.Furniture.dto.Admin;
import lk.ijse.Furniture.util.CrudUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminModel {
    public static Admin check(String name,String pass) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.crudUtil("SELECT*from user where Password=? && UserName=?",pass,name);
        if (rst.next()){
            return new Admin(
              rst.getString(1),
              rst.getString(2)
            );
        }
        return null;
    }
}
