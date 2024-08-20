package lk.ijse.Furniture.Tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeliveryTm {
    private String DID;
    private String EID;
    private String time;
    private String date;

}
