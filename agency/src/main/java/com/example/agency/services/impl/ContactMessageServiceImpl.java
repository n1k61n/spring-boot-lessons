package com.example.agency.services.impl;

import com.example.agency.dtos.responce.ContactMessageResponceDTO;
import com.example.agency.models.ContactMessage;
import com.example.agency.repositories.ContactMessageRepository;
import com.example.agency.services.ContactMessageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;


@RequiredArgsConstructor
public class ContactMessageServiceImpl implements ContactMessageService {
    private final ContactMessageRepository contactMessageRepository;
    private final ModelMapper modelMapper;

    @Override
    public ContactMessageResponceDTO getContactMessageById(Long id) {
        ContactMessage contactMessage = contactMessageRepository.findById(id).orElse(null);
        if (contactMessage == null)
            return null;
        return modelMapper.map(contactMessage, ContactMessageResponceDTO.class);
    }

    @Override
    public ContactMessageResponceDTO createContactMessage(ContactMessageResponceDTO contactMessageResponceDTO) {
        ContactMessage contactMessage = new ContactMessage();
        contactMessage.setName(contactMessageResponceDTO.getName());
        contactMessage.setEmail(contactMessageResponceDTO.getEmail());
        contactMessage.setMessage(contactMessageResponceDTO.getMessage());
        contactMessage.setPhone(contactMessageResponceDTO.getPhone());
        contactMessageRepository.save(contactMessage);
        return modelMapper.map(contactMessage, ContactMessageResponceDTO.class);
    }

    @Override
    public ContactMessageResponceDTO updateContactMessage(Long id, ContactMessageResponceDTO dto) {
        ContactMessage contactMessage = contactMessageRepository.findById(id).orElse(null);
        if (contactMessage != null) {
            contactMessage.setName(dto.getName());
            contactMessage.setEmail(dto.getEmail());
            contactMessage.setMessage(dto.getMessage());
            contactMessage.setPhone(dto.getPhone());
            contactMessageRepository.save(contactMessage);
            return modelMapper.map(contactMessage, ContactMessageResponceDTO.class);
        }
        return dto;
    }

    @Override
    public boolean deleteContactMessage(Long id) {
        if (contactMessageRepository.existsById(id)) {
            contactMessageRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
