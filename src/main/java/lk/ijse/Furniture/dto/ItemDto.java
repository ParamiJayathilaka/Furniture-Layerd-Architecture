package lk.ijse.Furniture.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ItemDto {
    private String IID;
    private String itemName;
    private String MatirialType;

    private String Size;

    private String color;

    private String UnitPrize;
    private String QtyOnHand;

    public ItemDto(String IID, String itemName, String matirialType, String size, String color, String unitPrize) {
        this.IID = IID;
        this.itemName = itemName;
        MatirialType = matirialType;
        Size = size;
        this.color = color;
        UnitPrize = unitPrize;
    }
}

