package lk.ijse.Furniture.Tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class SalaryTm {
    private String SID;
    private String EID;
    private String basic;
    private String bonus;

}
