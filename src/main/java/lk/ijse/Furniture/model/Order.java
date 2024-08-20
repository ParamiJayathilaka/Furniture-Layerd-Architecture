package lk.ijse.Furniture.model;

import lk.ijse.Furniture.Tm.OrderTm;
import lk.ijse.Furniture.dto.CustomerDto;
import lk.ijse.Furniture.dto.EmployeeDto;
import lk.ijse.Furniture.dto.OrderDto;
import lk.ijse.Furniture.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Order {
    public static boolean add(OrderDto order) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO `order` VALUES(?, ?, ?, ?, ?)";

        return CrudUtil.crudUtil(sql,
                order.getOID(),
                order.getCID(),
                order.getDID(),
                order.getPID(),
                order.getOrderDate()
        );
    }

    public static boolean update(OrderDto orderDto) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE order set PID=?,CID=?,DID=?,IID=?,orderDate=?,qty=?, where OID=?";
        return CrudUtil.crudUtil(sql,
                orderDto.getOID(),
                orderDto.getCID(),
                orderDto.getDID(),
                orderDto.getPID(),
                orderDto.getRole(),
                orderDto.getOrderDate());
    }

    public OrderDto search(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("DELETE FROM  order WHERE OID=?", id);
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "delete `order` where OID=?";
        return CrudUtil.crudUtil(sql,id);
    }

    public ArrayList<OrderTm> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<OrderTm> all = new ArrayList<>();
        ResultSet rst = CrudUtil.crudUtil("SELECT*from `Order`");
        while (rst.next()) {
            all.add(
                    new OrderTm(
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
