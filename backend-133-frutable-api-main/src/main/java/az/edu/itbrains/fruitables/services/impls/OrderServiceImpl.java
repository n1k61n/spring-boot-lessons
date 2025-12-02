package az.edu.itbrains.fruitables.services.impls;

import az.edu.itbrains.fruitables.repositories.OrderRepository;
import az.edu.itbrains.fruitables.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
}
