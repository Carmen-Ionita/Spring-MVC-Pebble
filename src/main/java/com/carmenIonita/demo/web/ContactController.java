package com.carmenIonita.demo.web;

import com.carmenIonita.demo.entity.Contact;
import com.carmenIonita.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;


@Controller
public class ContactController {

    private final ContactService service;

    @Autowired
    public ContactController(ContactService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getContactsTable(Map<String, Object> model) {
        Iterable<Contact> contacts = service.getAll();

        model.put("contacts", contacts);
        return "contactTable";
    }

    @GetMapping("/addContact")
    public String addNewContact() {
        return "saveContact";
    }

    @PostMapping("/addContact")
    public String addNewContact(Contact contact) {
        this.service.add(contact);
        return "redirect:/";
    }

    @PostMapping("/deleteContact/{contactId}")
    public String deleteContact(@PathVariable("contactId") Long contactId) {
        service.deleteContact(contactId);
        return "redirect:/";
    }

    @GetMapping("/updateContact/{contactId}")
    public String updateContact(@PathVariable("contactId") Long contactId, Map<String, Object> model) {
        Contact contact = service.getById(contactId);
        model.put("contact", contact);
        return "saveContact";
    }

    @PostMapping("/updateContact/{contactId}")
    public String updateContact(@PathVariable("contactId") Long contactId, Contact contact) {
        contact.setId(contactId);
        service.updateContact(contact);
        return "redirect:/";
    }

}
