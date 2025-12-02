package az.edu.itbrains.fruitables.dtos.photo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhotoUpdateDto {
    private String name;
    private String path;
    private Long productId;
}
