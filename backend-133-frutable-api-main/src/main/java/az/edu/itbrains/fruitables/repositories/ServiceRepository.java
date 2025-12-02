package az.edu.itbrains.fruitables.repositories;

import az.edu.itbrains.fruitables.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
