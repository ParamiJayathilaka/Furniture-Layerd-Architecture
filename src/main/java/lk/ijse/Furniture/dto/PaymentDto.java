package lk.ijse.Furniture.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class PaymentDto {
    private String PID;
    private String cash;
    private String balance;
    private String time;
    private String orderDate;

}
