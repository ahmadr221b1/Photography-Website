package dev.portfolio;

import dev.ridhoy.model.GalleryImage;
import dev.ridhoy.repository.GalleryImageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"dev.portfolio", "dev.ridhoy"})
@EntityScan(basePackages = {"dev.ridhoy.model"})
@EnableJpaRepositories(basePackages = {"dev.ridhoy.repository"})
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(GalleryImageRepository repository) {
        return args -> {
            // Clear existing images
            repository.deleteAll();

            // sample images from static resources.
            repository.save(new GalleryImage("/images/photo1.jpg", "Front view of the House"));
            repository.save(new GalleryImage("/images/photo2.jpg", "Side angle view of the House"));
            repository.save(new GalleryImage("/images/photo3.jpg", "Side view of the House"));
        };
    }
}