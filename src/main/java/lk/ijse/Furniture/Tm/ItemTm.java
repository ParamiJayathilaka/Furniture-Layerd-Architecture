package lk.ijse.Furniture.Tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ItemTm {
    private String IID;
    private String itemName;
    private String MatirialType;
    private String Size;
    private String Colour;
    private String UnitPrize;
    private String QtyOnHand;

}
