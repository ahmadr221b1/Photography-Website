package dev.ridhoy.controller;

import dev.ridhoy.model.ContactMessage;
import dev.ridhoy.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactController {

    @Autowired
    private ContactMessageRepository repository;

    @PostMapping
    public ContactMessage submitMessage(@RequestBody ContactMessage message) {
        return repository.save(message);
    }
}