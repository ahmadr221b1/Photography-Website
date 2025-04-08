package dev.ridhoy.controller;

import dev.ridhoy.model.GalleryImage;
import dev.ridhoy.repository.GalleryImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gallery")
@CrossOrigin(origins = "http://localhost:5173")
public class GalleryController {

    @Autowired
    private GalleryImageRepository repository;

    @GetMapping
    public List<GalleryImage> getGalleryImages() {
        return repository.findAll();
    }
}