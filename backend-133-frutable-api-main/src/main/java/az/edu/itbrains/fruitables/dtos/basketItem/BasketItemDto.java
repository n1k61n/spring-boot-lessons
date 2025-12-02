package az.edu.itbrains.fruitables.dtos.basketItem;

import az.edu.itbrains.fruitables.dtos.product.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BasketItemDto {

    private Long id;
    private ProductDto product;
    private Integer quantity;
}


