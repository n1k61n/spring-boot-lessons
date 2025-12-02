package az.edu.itbrains.fruitables.dtos.basket;

import az.edu.itbrains.fruitables.dtos.basketItem.BasketItemCreateDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BasketCreateDto {

    private List<BasketItemCreateDto> items;
}
