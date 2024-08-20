package lk.ijse.Furniture.Tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class PaymentTm {
    private String PID;
    private String cash;
    private String balance;
    private String time;
    private String orderDate;

}
