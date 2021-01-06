package com.carmenIonita.demo.service;

import com.carmenIonita.demo.entity.Contact;
import com.carmenIonita.demo.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContactService {

    private final ContactRepository repository;

    @Autowired
    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    public Iterable<Contact> getAll() {
        return repository.findAll();
    }

    public Contact getById(Long id) {
        return repository.findById(id)
                .orElse(null);
    }

    public Contact add(Contact contact) {
        return repository.save(contact);
    }


    public void deleteContact(Long contactId) {
        repository.deleteById(contactId);
    }

    public void updateContact(Contact newContact) {
        repository.findById(newContact.getId())
                .ifPresentOrElse(contact -> {
                            contact.setFirstName(newContact.getFirstName());
                            contact.setLastName(newContact.getLastName());
                            contact.setEmail(newContact.getEmail());
                            contact.setPhoneNumber(newContact.getPhoneNumber());

                            repository.save(contact);
                        },
                        () -> new RuntimeException("Could not find contact id"));
    }

}
