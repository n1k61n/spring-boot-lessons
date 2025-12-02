package az.edu.itbrains.fruitables.dtos.about;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AboutCreateDto {
    private String title;
    private String description;
    private String image;
}

