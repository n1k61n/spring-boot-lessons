package az.edu.itbrains.fruitables.dtos.contact;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {
    private Long id;
    private String map;
    private String phone;
    private String email;
    private String address;
}


