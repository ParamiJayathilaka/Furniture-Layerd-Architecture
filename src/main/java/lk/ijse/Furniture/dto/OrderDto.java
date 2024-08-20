package lk.ijse.Furniture.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class OrderDto {
    private String OID;
    private String CID;
    private String IID;
    private String DID;
    private String PID;
    private String QTY;
    private String orderDate;
    private String Price;
    private String role;

    public OrderDto(String orderid, String cusId, String deliverId, String paymentId, String qty, String orderDate) {
        this.OID=orderid;
        this.CID=cusId;
        this.DID=deliverId;
        this.PID=paymentId;
        this.role=qty;
        this.orderDate=orderDate;
    }


}
