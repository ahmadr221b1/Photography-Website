package dev.ridhoy.repository;

import dev.ridhoy.model.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMessageRepository  extends JpaRepository<ContactMessage, Long> {
}