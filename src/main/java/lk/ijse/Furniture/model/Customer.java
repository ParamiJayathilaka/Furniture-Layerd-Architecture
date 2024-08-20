package lk.ijse.Furniture.model;

import lk.ijse.Furniture.Tm.CustomerTm;
import lk.ijse.Furniture.dto.CustomerDto;
import lk.ijse.Furniture.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Customer {
    public boolean add(CustomerDto customer) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO customer VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        return CrudUtil.crudUtil(sql,
                customer.getCID(),
                customer.getFistName(),
                customer.getLastName(),
                customer.getStreet(),
                customer.getCity(),
                customer.getLane(),
                customer.getNIC(),
                customer.getMobileNumber());
    }

    public static boolean update(CustomerDto customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("UPDATE customer set firstName=?,lastName=?,street=?,city=?,lane=?,NIC=?,MobileNumber=? where CID=?",
                customer.getFistName(),
                customer.getLastName(),
                customer.getStreet(),
                customer.getCity(),
                customer.getLane(),
                customer.getNIC(),
                customer.getMobileNumber(),
                customer.getCID());
    }

    public CustomerDto search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.crudUtil("SELECT*FROM customer where CID=?", id);
        if (rst.next()) {
            return new CustomerDto(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8)
                    );
        }
        return null;

    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("DELETE FROM  customer WHERE CID=?", id);
    }

    public ArrayList<CustomerTm> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.crudUtil("Select * from customer");
        ArrayList<CustomerTm> AllCustomer = new ArrayList<>();
        while (resultSet.next()) {
            AllCustomer.add(
                    new CustomerTm(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8)
                    ));
        }
        return AllCustomer;
    }

}
