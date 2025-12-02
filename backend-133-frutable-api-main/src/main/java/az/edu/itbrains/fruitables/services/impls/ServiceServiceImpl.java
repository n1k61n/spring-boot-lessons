package az.edu.itbrains.fruitables.services.impls;

import az.edu.itbrains.fruitables.repositories.ServiceRepository;
import az.edu.itbrains.fruitables.services.ServiceService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {
    private final ServiceRepository serviceRepository;
    private final ModelMapper modelMapper;
}
