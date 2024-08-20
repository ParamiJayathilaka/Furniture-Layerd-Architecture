package lk.ijse.Furniture.model;

import lk.ijse.Furniture.dto.CustomerDto;
import lk.ijse.Furniture.dto.DeliveryDto;
import lk.ijse.Furniture.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Delivery {
    public boolean add(DeliveryDto delivary) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO delivarydetails VALUES(?, ?, ?, ?)";

        return CrudUtil.crudUtil(sql,
                delivary.getDID(),
                delivary.getEID(),
                delivary.getTime(),
                delivary.getDate());
    }

    public static boolean update(DeliveryDto delivary) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE delivarydetails set EID=?,time=?,date=? where DID=?";
        return CrudUtil.crudUtil(sql, delivary.getDID(), delivary.getEID(), delivary.getTime(), delivary.getDate());
    }


    public DeliveryDto search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT*FROM delivarydetails where DID=?";
        ResultSet rst = CrudUtil.crudUtil(sql, id);
        if (rst.next()) {
            return new DeliveryDto(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            );
        }
        return null;
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "delete from delivarydetails where DID=?";
        return CrudUtil.crudUtil(sql, id);
    }

    public ArrayList<DeliveryDto> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.crudUtil("Select * from delivarydetails");
        ArrayList<DeliveryDto> AllDelivery = new ArrayList<>();
        while (resultSet.next()) {
            AllDelivery.add(
                    new DeliveryDto(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4)
                    ));
        }
        return AllDelivery;
    }
}
