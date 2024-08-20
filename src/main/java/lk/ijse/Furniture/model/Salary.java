package lk.ijse.Furniture.model;

import lk.ijse.Furniture.Tm.SalaryTm;
import lk.ijse.Furniture.dto.SalaryDto;
import lk.ijse.Furniture.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Salary {
    public static boolean add(SalaryDto salary) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO salary VALUES(?, ?, ?, ?)";

        return CrudUtil.crudUtil(sql,
                salary.getSID(),
                salary.getEID(),
                salary.getBasic(),
                salary.getBonus());
    }

    public static boolean update(SalaryDto salaryDto) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE salary set EID=?,basic=?,bonus=? where SID=?";
        return CrudUtil.crudUtil(sql,
                salaryDto.getEID(),
                salaryDto.getBonus(),
                salaryDto.getBasic(),
                salaryDto.getSID());
    }

    public static ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException {
        ArrayList<String>ids=new ArrayList<>();
        ResultSet set=CrudUtil.crudUtil("SELECT SID FROM salary");
        while (set.next()){
            ids.add(set.getString(1));
        }
        return ids;
    }

    public static SalaryDto get(String id) throws SQLException, ClassNotFoundException {
        SalaryDto dto=new SalaryDto();
        ResultSet set=CrudUtil.crudUtil("SELECT * FROM salary WHERE SID=?",id);
        while (set.next()){
            dto.setBonus(set.getString(4));
            dto.setSID(set.getString(1));
            dto.setEID(set.getString(2));
            dto.setBasic(set.getString(3));
        }
        return dto;
    }

    public SalaryDto search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT*FROM salary where SID=?";
        ResultSet rst= CrudUtil.crudUtil(sql,id);
        if (rst.next()){
           return new SalaryDto(
                   rst.getString(1),
                   rst.getString(2),
                   rst.getString(3),
                   rst.getString(4)
           );
        }
        return null;
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "delete from salary where SID=?";
        return CrudUtil.crudUtil(sql,id);
    }

    public ArrayList<SalaryTm> getAll() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = CrudUtil.crudUtil("Select * from Salary");
        ArrayList<SalaryTm> AllSalary = new ArrayList<>();
        while (resultSet.next()) {
            AllSalary.add(
                    new SalaryTm(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4)
                    ));
        }
        return AllSalary;
    }
}
