package lk.ijse.Furniture.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AttendeDto {

    private String AID;
    private String EID;
    private String workingHourse;
    private String attendance;
    private String date;

}
