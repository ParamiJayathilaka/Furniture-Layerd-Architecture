package lk.ijse.Furniture.model;

import lk.ijse.Furniture.db.DBConnection;
import lk.ijse.Furniture.dto.CustomerDto;
import lk.ijse.Furniture.dto.ItemDto;
import lk.ijse.Furniture.dto.OrderDto;
import lk.ijse.Furniture.dto.PaymentDto;
import lk.ijse.Furniture.util.CrudUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Payment {
    public static boolean add(PaymentDto payment) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO payment VALUES(?, ?, ?, ?, ?)";

        return CrudUtil.crudUtil(sql,
                payment.getPID(),
                payment.getCash(),
                payment.getBalance(),
                payment.getTime(),
                payment.getOrderDate());
    }

    public static boolean update(PaymentDto paymentDto) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE payment set cash=?,balance=?,time=?,orderDate=? where PID=?";
        return CrudUtil.crudUtil(sql,
                paymentDto.getCash(),
                paymentDto.getBalance(),
                paymentDto.getTime(),
                paymentDto.getOrderDate(),
                paymentDto.getPID());
    }

    public PaymentDto search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT*FROM payment where PID=?";
        ResultSet rst = CrudUtil.crudUtil(sql, id);
        if (rst.next()) {
           return new PaymentDto(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)

            );
        }
        return null;
    }

    public static boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM payment WHERE PID = ?";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1, id);

        return pstm.executeUpdate() > 0;

    }

    public ArrayList<PaymentDto> getAll() throws SQLException, ClassNotFoundException {

        ArrayList<PaymentDto> all = new ArrayList<>();
        ResultSet rst = CrudUtil.crudUtil("SELECT*from payment");
        while (rst.next()) {
            all.add(
                    new PaymentDto(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getString(4),
                            rst.getString(5)


                    ));
        }
        return all;
    }
}
