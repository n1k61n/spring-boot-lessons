package az.edu.itbrains.fruitables.dtos.basketItem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BasketItemUpdateDto {
    private Long productId;
    private Long basketId;
    private Integer quantity;
}
