package dev.ridhoy.controller;

import dev.ridhoy.model.ContactMessage;
import dev.ridhoy.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ContactController {

    @Autowired
    private ContactMessageRepository repository;

    @PostMapping("/contact")
    public ContactMessage submitMessage(@RequestBody ContactMessage message) {
        return repository.save(message);
    }
}