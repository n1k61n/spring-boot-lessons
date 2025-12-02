package az.edu.itbrains.fruitables.repositories;

import az.edu.itbrains.fruitables.models.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
