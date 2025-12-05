package com.example.agency.services;

import com.example.agency.dtos.responce.ContactMessageResponceDTO;

public interface ContactMessageService {
    ContactMessageResponceDTO getContactMessageById(Long id);
    ContactMessageResponceDTO createContactMessage(ContactMessageResponceDTO contactMessageResponceDTO);
    ContactMessageResponceDTO updateContactMessage(Long id, ContactMessageResponceDTO contactMessageResponceDTO);
    boolean deleteContactMessage(Long id);

}
