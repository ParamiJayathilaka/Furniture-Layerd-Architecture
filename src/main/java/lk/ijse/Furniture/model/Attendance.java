package lk.ijse.Furniture.model;

import lk.ijse.Furniture.Tm.EmployeeTm;
import lk.ijse.Furniture.dto.AttendeDto;
import lk.ijse.Furniture.dto.EmployeeDto;
import lk.ijse.Furniture.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Attendance {
    public boolean add(AttendeDto attend) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO employee VALUES(?, ?, ?, ?, ?)";
        return CrudUtil.crudUtil(sql,
                attend.getAttendance(),
                attend.getEID(),
                attend.getAID(),
                attend.getDate(),
                attend.getWorkingHourse()
        );
    }

    public static boolean update(AttendeDto attend) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE attend set EID=?,workingHourse=?,attendance=?,date=? where AID=?";
        return CrudUtil.crudUtil(sql,
                attend.getAttendance(),
                attend.getEID(),
                attend.getAID(),
                attend.getDate(),
                attend.getWorkingHourse());

    }

    public AttendeDto search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst= CrudUtil.crudUtil("SELECT*FROM attend where AID=?", id);
        if (rst.next()){
            return new AttendeDto(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
            );
        }
        return null;
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("DELETE FROM  attend WHERE AID=?", id);
    }

    public ArrayList<AttendeDto> getAll() throws SQLException, ClassNotFoundException {

        ArrayList<AttendeDto> all = new ArrayList<>();
        ResultSet rst = CrudUtil.crudUtil("SELECT*from employeeattendance");
        while (rst.next()) {
            all.add(
                    new AttendeDto(
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
