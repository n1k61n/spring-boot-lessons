package az.edu.itbrains.fruitables.repositories;

import az.edu.itbrains.fruitables.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
