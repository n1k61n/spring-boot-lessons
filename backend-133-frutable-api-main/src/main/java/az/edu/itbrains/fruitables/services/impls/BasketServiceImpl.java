package az.edu.itbrains.fruitables.services.impls;

import az.edu.itbrains.fruitables.repositories.BasketRepository;
import az.edu.itbrains.fruitables.services.BasketService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
    private final BasketRepository basketRepository;
    private final ModelMapper modelMapper;
}
