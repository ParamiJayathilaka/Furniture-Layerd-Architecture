package lk.ijse.Furniture.model;

import lk.ijse.Furniture.Tm.EmployeeTm;
import lk.ijse.Furniture.dto.EmployeeDto;
import lk.ijse.Furniture.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Employee {

    public boolean add(EmployeeDto employee) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO employee VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        return CrudUtil.crudUtil(sql,
                employee.getEID(),
                employee.getFistName(),
                employee.getLastName(),
                employee.getStreet(),
                employee.getCity(),
                employee.getLane(),
                employee.getNic(),
                employee.getContact()
        );
    }

    public static boolean update(EmployeeDto employeeDto) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE employee set firstName=?,lastName=?,street=?,city=?,lane=?,NIC=?,mobileNumber=? where EID=?";
        return CrudUtil.crudUtil(sql,
                employeeDto.getFistName(),
                employeeDto.getLastName(),
                employeeDto.getStreet(),
                employeeDto.getCity(),
                employeeDto.getLane(),
                employeeDto.getNic(),
                employeeDto.getContact(),
                employeeDto.getEID());

    }

    public EmployeeDto search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst= CrudUtil.crudUtil("SELECT*FROM employee where EID=?", id);
        if (rst.next()){
           return new EmployeeDto(
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
        return CrudUtil.crudUtil("DELETE FROM  employee WHERE EID=?", id);
    }

    public ArrayList<EmployeeDto> getAll() throws SQLException, ClassNotFoundException {

        ArrayList<EmployeeDto> all = new ArrayList<>();
        ResultSet rst = CrudUtil.crudUtil("SELECT*from employee");
        while (rst.next()) {
            all.add(
                    new EmployeeDto(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getString(4),
                            rst.getString(5),
                            rst.getString(6),
                            rst.getString(7),
                            rst.getString(8)
                    ));
        }
        return all;
    }

}
