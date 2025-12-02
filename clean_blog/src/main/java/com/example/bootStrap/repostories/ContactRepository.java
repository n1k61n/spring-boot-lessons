package com.example.bootStrap.repostories;

import com.example.bootStrap.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
