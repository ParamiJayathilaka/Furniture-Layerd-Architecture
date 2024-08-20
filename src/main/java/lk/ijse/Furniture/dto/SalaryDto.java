package lk.ijse.Furniture.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class SalaryDto {
    private String SID;
    private String EID;
    private String basic;
    private String bonus;

}
