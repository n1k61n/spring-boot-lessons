package az.edu.itbrains.fruitables.services.impls;

import az.edu.itbrains.fruitables.repositories.ContactRepository;
import az.edu.itbrains.fruitables.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;
}
