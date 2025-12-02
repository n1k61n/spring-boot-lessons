package az.edu.itbrains.fruitables.services.impls;

import az.edu.itbrains.fruitables.repositories.ProductRepository;
import az.edu.itbrains.fruitables.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
}
