package lk.ijse.Furniture.model;

import lk.ijse.Furniture.dto.CustomerDto;
import lk.ijse.Furniture.dto.EmployeeDto;
import lk.ijse.Furniture.dto.ItemDto;
import lk.ijse.Furniture.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Item {
    public static boolean add(ItemDto item) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO item VALUES(?, ?, ?, ?, ?, ?, ?)";

        return CrudUtil.crudUtil(sql,item.getIID(),
                item.getItemName(),
                item.getMatirialType(),
                item.getSize(),
                item.getColor(),
                item.getUnitPrize(),
                item.getQtyOnHand());
    }
    public static boolean update(ItemDto itemDto) throws SQLException, ClassNotFoundException {
       return CrudUtil.crudUtil("UPDATE item SET ItemName=?,MatirialType=?,Size=?,Colour=?,UnitPrize=?,QtyOnHand=? WHERE IID=?",
               itemDto.getItemName(),
               itemDto.getMatirialType(),
               itemDto.getSize(),
               itemDto.getColor(),
               itemDto.getUnitPrize(),
               itemDto.getQtyOnHand(),
               itemDto.getIID()
       );
    }

    public ItemDto search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT*FROM item where IID=?";
        ResultSet rst = CrudUtil.crudUtil(sql, id);
        if (rst.next()){
            return new ItemDto(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7)
            );
        }
        return null;
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "delete FROM item where IID=?";
        return CrudUtil.crudUtil(sql,id);
    }


    public ArrayList<ItemDto> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDto> all = new ArrayList<>();
        ResultSet rst = CrudUtil.crudUtil("SELECT*from item");
        while (rst.next()) {
            all.add(
                    new ItemDto(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getString(4),
                            rst.getString(5),
                            rst.getString(6)

                    ));
        }
        return all;
    }
}
