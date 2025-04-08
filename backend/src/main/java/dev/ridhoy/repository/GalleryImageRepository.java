package dev.ridhoy.repository;

import dev.ridhoy.model.GalleryImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryImageRepository extends JpaRepository<GalleryImage, Long> {
}