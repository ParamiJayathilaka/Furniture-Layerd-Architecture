package lk.ijse.Furniture.Tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeTm {

    private String EID;
    private String fistName;
    private String lastName;
    private String street;
    private String city;
    private String lane;
    private String contact;

   }