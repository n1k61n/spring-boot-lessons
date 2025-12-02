package az.edu.itbrains.fruitables.services.impls;

import az.edu.itbrains.fruitables.repositories.OrderItemRepository;
import az.edu.itbrains.fruitables.services.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final ModelMapper modelMapper;
}
