package com.carmenIonita.demo.repository;
import com.carmenIonita.demo.entity.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {
}
