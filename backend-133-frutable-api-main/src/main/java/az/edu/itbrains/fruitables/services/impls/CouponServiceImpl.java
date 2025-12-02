package az.edu.itbrains.fruitables.services.impls;

import az.edu.itbrains.fruitables.repositories.CouponRepository;
import az.edu.itbrains.fruitables.services.CouponService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {
    private final CouponRepository couponRepository;
    private final ModelMapper modelMapper;
}
