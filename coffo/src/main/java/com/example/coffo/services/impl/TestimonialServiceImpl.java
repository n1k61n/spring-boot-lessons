package com.example.coffo.services.impl;

import com.example.coffo.DTOs.request.TestimonialRequestDTO;
import com.example.coffo.DTOs.responce.TestimonialResponceDTO;
import com.example.coffo.repositories.TestimonialRepository;
import com.example.coffo.services.OrderItemService;
import com.example.coffo.services.TestimonialService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestimonialServiceImpl implements TestimonialService {
    private final TestimonialRepository testimonialRepository;
    private final TestimonialResponceDTO testimonialResponceDTO;
    private final ModelMapper modelMapper;


    @Override
    public List<TestimonialResponceDTO> getAll() {
        return List.of();
    }
}
