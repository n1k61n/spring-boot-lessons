package az.edu.itbrains.fruitables.services.impls;

import az.edu.itbrains.fruitables.repositories.PhotoRepository;
import az.edu.itbrains.fruitables.services.PhotoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {
    private final PhotoRepository photoRepository;
    private final ModelMapper modelMapper;
}
